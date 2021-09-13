package pl.coderslab.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
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
    @Column(name = "orders_user")
    private List<Order> orders;

    @ManyToMany
    @JoinTable(name = "favourite_diet")
    @Column(name = "diet_id")
    private List<Diet> favouriteDiets;


    @PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }

    public static class Builder {
        private String name;
        private String surname;
        private String diet;
        private String email;
        private Long phoneNumber;
        private City city;
        private String address;
        private String zip;
        private String description;
        private List<Order> orders;
        private List<Diet> favouriteDiets;

        public Builder name (String val){
            name = val;
            return this;
        }

        public Builder surname (String val){
            surname = val;
            return this;
        }

        public Builder diet (String val){
            diet = val;
            return this;
        }

        public Builder email (String val){
            email = val;
            return this;
        }

        public Builder phoneNumber (Long val){
            phoneNumber = val;
            return this;
        }

        public Builder city (City val){
            city = val;
            return this;
        }

        public Builder address (String val){
            address = val;
            return this;
        }

        public Builder zip (String val){
            zip = val;
            return this;
        }

        public Builder description (String val){
            description = val;
            return this;
        }

        public Builder orders (Order...val){
            for (Order s : val) {
                orders.add(s);
            }
            return this;
        }

        public Builder favouriteDiets (Diet...val){
            for (Diet s : val) {
                favouriteDiets.add(s);
            }
            return this;
        }
    }

    private Client(Builder builder){
        name = builder.name;
        surname = builder.surname;
        email = builder.email;
        diet = builder.diet;
        phoneNumber = builder.phoneNumber;
        city = builder.city;
        address = builder.address;
        zip = builder.zip;
        description = builder.description;
        orders = builder.orders;
        favouriteDiets = builder.favouriteDiets;
    }
}
