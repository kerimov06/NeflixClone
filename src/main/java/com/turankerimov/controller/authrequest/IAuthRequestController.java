package com.turankerimov.controller.authrequest;

import com.turankerimov.dto.user.UserResponseDto;
import com.turankerimov.entity.RefreshToken;
import com.turankerimov.entity.RequestRefreshToken;
import com.turankerimov.jwt.AuthRequest;
import com.turankerimov.jwt.AuthResponse;
import org.springframework.http.ResponseEntity;

public interface IAuthRequestController {

    public ResponseEntity<UserResponseDto> register(AuthRequest userDtoIU);
    public ResponseEntity<AuthResponse> authenticate(AuthRequest authRequest);
    public ResponseEntity<AuthResponse> refresh(RequestRefreshToken request);

}
