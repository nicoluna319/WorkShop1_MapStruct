package com.biblio.biblio.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "user")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
}

