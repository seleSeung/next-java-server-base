package com.next.app.api.user.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 고유 식별자 (PK)

    @Column(nullable = false, unique = true)
    private String businessNumber;      // 사업자 등록번호

    @Column(nullable = false)
    private String companyName;         // 회사명

    @Column(nullable = false)
    private String representativeName;  // 대표자명

    @Column(nullable = false)
    private String contactEmail;        // 연락 이메일

    @Column(nullable = false)
    private String contactPhone;        // 연락 전화번호

    @Column(nullable = false)
    private String address;             // 사업장 주소

    @Column(nullable = false)
    private LocalDate registeredAt;     // 등록일자

}
