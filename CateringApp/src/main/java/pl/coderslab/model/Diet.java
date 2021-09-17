package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    public Diet() {
    }

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "total_amount_of_acquirer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totalAmountOfAcquirer;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @Column(name = "diet_id")
    private List<Client> clients;

    public List<Client> add(Client client){
        clients.add(client);
        return clients;
    }

    public static class Builder {
        private String dietName;
        private Double price;
        private String description;
        private List<Client> clients;


        public Builder(String dietName, Double price) {
            this.dietName = dietName;
            this.price = price;
        }

        public Builder price(Double val) {
            price = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder clients(Client client) {
            clients.add(client);
            return this;
        }

        public Diet build() {
            return new Diet(this);
        }
    }

    public Diet(Builder builder) {
        name = builder.dietName;
        price = builder.price;
        description = builder.description;
        clients = builder.clients;
    }
}
