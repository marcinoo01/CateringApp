package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 60)
    private String username;

    @Size(min = 8, max = 60)
    private String password;

    @NotBlank
    @Size(min = 5, max = 150)
    private String email;

    @Column(name = "created_on")
    private LocalDate createdOn;


    private String role;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }
}
