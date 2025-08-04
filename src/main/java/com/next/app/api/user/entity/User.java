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
    private Long id;

    @Column(nullable = false, unique = true)
    private String businessNumber;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String representativeName;

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String contactPhone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDate registeredAt;
}
