package com.turankerimov.dto;

import com.turankerimov.entity.Movie;
import com.turankerimov.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {

    private String content;

    private LocalDate createdDate;

    private User user;

    private Movie movie;
}
