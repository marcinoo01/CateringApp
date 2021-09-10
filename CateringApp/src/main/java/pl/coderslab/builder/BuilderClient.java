package pl.coderslab.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.model.City;
import pl.coderslab.model.Diet;
import pl.coderslab.model.Order;
import pl.coderslab.model.User;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class BuilderClient {
    private Long id;
    private User user;
    private String name;
    private String surname;
    private String diet;
    private String email;
    private LocalDate createdOn;
    private Long phoneNumber;
    private City city;
    private String address;
    private String zip;
    private String description;
    private List<Order> orders;
    private List<Diet> favouriteDiets;

    public BuilderClient name(String val) {
        name = val;
        return this;
    }

    public BuilderClient surname(String val) {
        surname = val;
        return this;
    }

    public BuilderClient diet(String val) {
        diet = val;
        return this;
    }

    public BuilderClient email(String val) {
        email = val;
        return this;
    }

    public BuilderClient phoneNumber(Long val) {
        phoneNumber = val;
        return this;
    }

    public BuilderClient city(City val) {
        city = val;
        return this;
    }

    public BuilderClient address(String val) {
        address = val;
        return this;
    }

    public BuilderClient zip(String val) {
        zip = val;
        return this;
    }

    public BuilderClient description(String val) {
        description = val;
        return this;
    }

    public BuilderClient order(Order... val) {
        for (Order s : val) {
            orders.add(s);
        }
        return this;
    }

    public BuilderClient favouriteDiets(Diet... val) {
        for (Diet s : val) {
            favouriteDiets.add(s);
        }
        return this;
    }
}
