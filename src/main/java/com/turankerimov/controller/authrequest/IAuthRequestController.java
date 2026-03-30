package com.turankerimov.controller.authrequest;

import com.turankerimov.dto.user.UserResponseDto;
import com.turankerimov.jwt.AuthRequest;

public interface IAuthRequestController {

    public UserResponseDto register(AuthRequest userDtoIU);

}
