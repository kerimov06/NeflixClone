package com.turankerimov.controller.authrequest;

import com.turankerimov.dto.user.UserResponseDto;
import com.turankerimov.jwt.AuthRequest;
import com.turankerimov.service.authrequest.IAuthRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRequestController implements IAuthRequestController {


    @Autowired
    private IAuthRequestService authRequestService;



    @PostMapping("/register")
    @Override
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody AuthRequest userDtoIU) {
        return authRequestService.register(userDtoIU);
    }





}
