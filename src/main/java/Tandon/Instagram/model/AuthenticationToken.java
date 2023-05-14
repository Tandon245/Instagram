package Tandon.Instagram.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor

public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    private String token;
    private LocalDate tokenCreationTime;
    @OneToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;

    public AuthenticationToken(User user) {
        this.user = user;
        this.tokenCreationTime=LocalDate.now();
        this.token= UUID.randomUUID().toString();

    }
}
