package com.turankerimov.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "average_rating")
    private Double averageRating = 0.0;

    @Column(name = "rating_count" )
    private Integer ratingCount = 0;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "movie")
    private List<Comment> comments= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "movie")
    private List<Watchlist>  watchlist = new ArrayList<>();


    public void addMovieRating(Rating rating){
          this.ratings.add(rating);
          rating.setMovie(this);
    }

    public void addMovieComment(Comment comment){
         this.comments.add(comment);
         comment.setMovie(this);
    }

    public void addMovieWatchlist(Watchlist watchlist){
        this.watchlist.add(watchlist);
          watchlist.setMovie(this);
    }


}
