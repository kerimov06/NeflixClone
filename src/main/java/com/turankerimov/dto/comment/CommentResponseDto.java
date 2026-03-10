package com.turankerimov.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {

    private Long id;

    private String content;

    private LocalDate createdDate;

}
