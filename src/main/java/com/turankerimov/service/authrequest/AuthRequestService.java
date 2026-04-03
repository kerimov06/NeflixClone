package com.turankerimov.service.authrequest;

import com.turankerimov.dto.user.UserResponseDto;
import com.turankerimov.entity.User;
import com.turankerimov.jwt.AuthRequest;
import com.turankerimov.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthRequestService implements IAuthRequestService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder  bCryptPasswordEncoder;


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
