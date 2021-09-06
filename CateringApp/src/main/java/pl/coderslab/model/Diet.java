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
    private String dietName;
    private Double price;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "amount_of_acquirer")
    private Long amountOfAcquirer;

    @Column(name = "total_amount_of_acquirer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totalAmountOfAcquirer;

    @ManyToMany
    @Column(name = "diet_id")
    private List<Client> clients;


}
