package com.market.auction.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Auction extends BaseEntity {
    private String title;
    private LocalDateTime endTime;
    @CreatedDate
    private LocalDateTime startTime;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private Long itemId;
    private Long quantity;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Category category;
}
