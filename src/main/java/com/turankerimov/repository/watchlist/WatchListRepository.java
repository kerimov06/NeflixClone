package com.turankerimov.repository.watchlist;

import com.turankerimov.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchListRepository extends JpaRepository<Watchlist,Long> {
}
