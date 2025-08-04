package com.next.app.api.user.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 기존 필드
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    private String phone;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // 🔽 추가해야 할 필드
    @Column(name = "contact_email", nullable = false, unique = true)
    private String contactEmail;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "representative_name")
    private String representativeName;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "address")
    private String address;

    @Column(name = "business_number")
    private String businessNumber;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
