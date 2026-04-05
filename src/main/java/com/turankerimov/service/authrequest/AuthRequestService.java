package com.turankerimov.service.authrequest;

import com.turankerimov.dto.user.UserResponseDto;
import com.turankerimov.entity.RefreshToken;
import com.turankerimov.entity.User;
import com.turankerimov.jwt.AuthRequest;
import com.turankerimov.jwt.AuthResponse;
import com.turankerimov.jwt.JwtService;
import com.turankerimov.repository.refreshtoken.RefreshTokenRepository;
import com.turankerimov.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthRequestService implements IAuthRequestService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder  bCryptPasswordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private RefreshTokenRepository refreshTokenRepository;





    public RefreshToken createRefreshToken(User user) {
          RefreshToken refreshToken = new RefreshToken();
          refreshToken.setToken(UUID.randomUUID().toString());
          refreshToken.setUser(user);
          refreshToken.setExpireDate(Instant.now().plus(30, ChronoUnit.DAYS));

          return refreshTokenRepository.save(refreshToken);

    }

    @Override
    public ResponseEntity<AuthResponse> authenticate(AuthRequest authRequest) {
           try {
               authenticationManager.authenticate(
                       new UsernamePasswordAuthenticationToken(
                               authRequest.getUsername(),
                               authRequest.getPassword()
                       )
               );
           }catch (Exception e) {
               e.printStackTrace();
               throw e;
           }

           User user =  userRepository.findByUsername(authRequest.getUsername())
                    .orElseThrow(()-> new RuntimeException("Username not found"));

             String accessToken = jwtService.generateToken(user);
             RefreshToken refreshToken = createRefreshToken(user);


        return ResponseEntity.ok(new AuthResponse(accessToken,refreshToken.getToken()));
    }

    @Override
    public ResponseEntity<AuthResponse> refresh(String requestToken) {
                   RefreshToken refreshToken = refreshTokenRepository.findByToken(requestToken)
                           .orElseThrow(()-> new RuntimeException("Refresh token not found"));

                   if (refreshToken.getExpireDate().isBefore(Instant.now())) {
                         refreshTokenRepository.delete(refreshToken);
                         throw new RuntimeException("Refresh token expired");
                   }

                        String newAccessToken =  jwtService.generateToken(refreshToken.getUser());


                   return ResponseEntity.ok(new AuthResponse(newAccessToken,refreshToken.getToken()));
    }

    @Override
    public ResponseEntity<UserResponseDto> register(AuthRequest userDtoIU) {

        User user = new User();

        user.setUsername(userDtoIU.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDtoIU.getPassword()));


        User saveUser = userRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto();
         userResponseDto.setUsername(saveUser.getUsername());
         userResponseDto.setCreationDate(new Date());

        return ResponseEntity.ok(userResponseDto);
    }


}
