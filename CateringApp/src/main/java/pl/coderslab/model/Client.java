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


    @Size(min = 2, max = 50, message = "input between 2 and 50 chars")
    private String name;

    @Size(min = 2, max = 50)
    private String surname;

    @OneToOne
    private Diet diet;

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

    @OneToOne(cascade = {CascadeType.ALL})
    private Order order;


    @PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }


    public static class Builder {
        private String name;
        private String surname;
        private Diet diet;
        private String email;
        private Long phoneNumber;
        private City city;
        private String address;
        private String zip;
        private User user;
        private String description;
        private Order order;

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder surname(String val) {
            surname = val;
            return this;
        }

        public Builder user(User val){
            user = val;
            return this;
        }


        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder diet(Diet val){
            diet = val;
            return this;
        }

        public Builder phoneNumber(Long val) {
            phoneNumber = val;
            return this;
        }

        public Builder city(City val) {
            city = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder zip(String val) {
            zip = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder order(Order val){
            order = val;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    private Client(Builder builder) {
        name = builder.name;
        surname = builder.surname;
        email = builder.email;
        user = builder.user;
        phoneNumber = builder.phoneNumber;
        address = builder.address;
        zip = builder.zip;
        description = builder.description;
        order = builder.order;
        city = builder.city;
        diet = builder.diet;
    }
}
