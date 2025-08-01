package com.next.app.api.user.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "business_selee")  // 실제 DB 테이블명에 맞게 바꿔줘
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 고유 식별자 (PK)

    @Column(nullable = false)
    private String name;  // 상품명

    @Column(nullable = false)
    private BigDecimal price;  // 가격

    @Column(columnDefinition = "TEXT")
    private String description;  // 상품 설명
}
