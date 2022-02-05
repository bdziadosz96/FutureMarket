package com.market.item.repository;

import com.market.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface ItemRepository extends JpaRepository<Item, Long> {
}
