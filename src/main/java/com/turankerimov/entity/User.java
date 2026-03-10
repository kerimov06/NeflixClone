package com.turankerimov.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "username" , unique = true)
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Rating> ratings;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Watchlist> watchlist;

    public void addUserRating(Rating rating) {
         this.ratings.add(rating);
         rating.setUser(this);
    }

    public void addUserComment(Comment comment) {
        this.comments.add(comment);
        comment.setUser(this);
    }

    public void addUserWatchlist(Watchlist watchlist) {
        this.watchlist.add(watchlist);
        watchlist.setUser(this);
    }


}
