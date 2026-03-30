package com.turankerimov.service.authrequest;

import com.turankerimov.dto.user.UserDtoIU;
import com.turankerimov.dto.user.UserResponseDto;
import com.turankerimov.jwt.AuthRequest;

public interface IAuthRequestService {

   public UserResponseDto register(AuthRequest userDtoIU);

}
