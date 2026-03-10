package com.turankerimov.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDtoIU {

    private Long id;

    private String content;

    private LocalDate createdDate;

}
