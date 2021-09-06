package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = true)
    private User user;

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank
    @Size(min = 2, max = 50)
    private String surname;

    @NotBlank
    private String diet;

    @NotBlank
    @Size(min = 5, max = 150)
    private String email;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @Column(name = "phone_number")
    @Size(min = 9, max = 12)
    private Long phoneNumber;

    @NotBlank
    @OneToOne
    private City city;

    @NotBlank
    private String address;

    @Column(name = "zip_code")
    @Size(min = 6, max = 6)
    @NotBlank
    private String zip;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    private List<Order> orders;

    @ManyToMany
    @JoinTable(name = "favourite_diet")
    @Column(name = "diet_id")
    private List<Diet> favouriteDiets;


    @PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }
}
