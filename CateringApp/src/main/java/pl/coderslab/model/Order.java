package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
@ToString
@Table(name = "orders")
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
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "expire_date")
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;

    private String kcal;

    @PrePersist
    public void startDate(){
        startDate = LocalDate.now();
    }

    public void calculateExpireDateAndLength(LocalDate startDate, int lengthInDays){
        this.lengthWholePlan = lengthInDays;
        this.expireDate = startDate.plusDays(lengthInDays);
    }

    public Long calculateLengthOfPlan(LocalDate startDate, LocalDate expireDate){
        return ChronoUnit.DAYS.between(startDate, expireDate);
    }

    public Long getCalculateRemainDays(){
         return ChronoUnit.DAYS.between(LocalDate.now(), this.expireDate);
    }

}
