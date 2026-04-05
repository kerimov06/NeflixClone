package com.turankerimov.service.authrequest;

import com.turankerimov.dto.user.UserResponseDto;
import com.turankerimov.jwt.AuthRequest;
import com.turankerimov.jwt.AuthResponse;
import org.springframework.http.ResponseEntity;

public interface IAuthRequestService {

   public ResponseEntity<UserResponseDto> register(AuthRequest userDtoIU);
   public ResponseEntity<AuthResponse> authenticate(AuthRequest authRequest);
   public ResponseEntity<AuthResponse> refresh(String refreshToken);

}
