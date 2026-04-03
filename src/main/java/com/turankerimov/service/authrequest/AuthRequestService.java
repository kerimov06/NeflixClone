package com.turankerimov.service.authrequest;

import com.turankerimov.dto.user.UserResponseDto;
import com.turankerimov.entity.User;
import com.turankerimov.jwt.AuthRequest;
import com.turankerimov.jwt.AuthResponse;
import com.turankerimov.jwt.JwtService;
import com.turankerimov.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

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

             String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new AuthResponse(token));
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
