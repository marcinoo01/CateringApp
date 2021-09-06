package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
@ToString
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String totalPrice;

    @Column(name = "length_whole_plan")
    private Integer lengthWholePlan;

    @Column(name = "remain_days")
    private Long remainDays;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "expire_date")
    private LocalDate expireDate;

    @PrePersist
    public void startDate(){
        startDate = LocalDate.now();
    }

    public void calculateExpireDateAndLength(LocalDate startDate, int lengthInDays){
        this.lengthWholePlan = lengthInDays;
        this.expireDate = startDate.plusDays(lengthInDays);
    }

    public Long getCalculateRemainDays(){
         return ChronoUnit.DAYS.between(LocalDate.now(), this.expireDate);
    }
}
