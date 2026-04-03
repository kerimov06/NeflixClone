package com.turankerimov.controller.authrequest;

import com.turankerimov.dto.user.UserResponseDto;
import com.turankerimov.jwt.AuthRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthRequestController {

    public ResponseEntity<UserResponseDto> register(AuthRequest userDtoIU);

}
