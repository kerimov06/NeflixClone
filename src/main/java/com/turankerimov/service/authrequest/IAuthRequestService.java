package com.turankerimov.service.authrequest;

import com.turankerimov.dto.user.UserResponseDto;
import com.turankerimov.jwt.AuthRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthRequestService {

   public ResponseEntity<UserResponseDto> register(AuthRequest userDtoIU);

}
