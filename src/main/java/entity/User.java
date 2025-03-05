package entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")  // primary key
    private int userId;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "role", length = 50)
    private String role;

    @Column(name = "permissions", length = 50)
    private String permissions;

    @Column(name = "project", length = 50)
    private String project;

    @Column(name = "status", length = 50)
    private String status;
}
