package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @Column(name = "city_name")
    private String cityName;

    @Size(min = 2, max = 50, message = "input between 2 and 50 chars")
    private String name;

    @Size(min = 2, max = 50)
    private String surname;

    @NotBlank
    private String diet;

    @Size(min = 5, max = 150, message = "input between 5 and 150 chars")
    private String email;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @Column(name = "phone_number")
    @NotNull(message = "input between 9 and 12 digits")
    private Long phoneNumber;

    @NotBlank(message = "Enter your address")
    private String address;

    @OneToOne
    private City city;


    @Column(name = "zip_code")
    @Size(min = 6, max = 6, message = "input should have 6 chars")
    private String zip;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany
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
