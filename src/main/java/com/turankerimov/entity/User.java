package com.turankerimov.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

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
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Watchlist> watchlist = new ArrayList<>();

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
