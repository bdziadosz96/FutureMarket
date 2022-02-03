package com.market.auction.repository;

import com.market.auction.domain.Auction;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface AuctionRepository extends JpaRepository<Auction, Long> {
    Optional<Long> findByItemId(Long itemId);
}
