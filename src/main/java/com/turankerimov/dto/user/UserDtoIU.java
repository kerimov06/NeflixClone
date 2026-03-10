package com.turankerimov.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoIU {

    private Long id;

    private String username;

    private String password;

    private LocalDate createdAt;


}
