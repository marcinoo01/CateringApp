package pl.coderslab.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalPrice;

    @Column(name = "length_whole_plan")
    private Long lengthWholePlan;


    @Column(name = "start_date")
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "expire_date")
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;

    private String kcal;

    @Column(name = "created_on")
    private LocalDate created;


    @OneToOne
    private Diet diet;

    @OneToOne(cascade = {CascadeType.ALL})
    private User user;

    @PrePersist
    public void created(){
        created = LocalDate.now();
    }

    public Long calculateLengthOfPlan(LocalDate startDate, LocalDate expireDate){
        return ChronoUnit.DAYS.between(startDate, expireDate);
    }

    public static class Builder{
        private Double totalPrice;
        private Long lengthWholePlan;
        private LocalDate startDate;
        private LocalDate expireDate;
        private String kcal;
        private Diet diet;
        private User user;

        public Long calculateLengthOfPlan(LocalDate startDate, LocalDate expireDate){
            return ChronoUnit.DAYS.between(startDate, expireDate);
        }

        public Builder totalPrice(Double val){
            totalPrice = val;
            return this;
        }

        public Builder lengthWholePlan(){
            lengthWholePlan = calculateLengthOfPlan(startDate, expireDate);
            return this;
        }

        public Builder startDate(LocalDate val){
            startDate = val;
            return this;
        }


        public Builder expireDate(LocalDate val){
            expireDate = val;
            return this;
        }

        public Builder kcal(String val){
            kcal = val;
            return this;
        }

        public Builder diet(Diet val){
            diet = val;
            return this;
        }

        public Builder user(User val){
            user = val;
            return this;
        }

        public Order build(){
            return new Order(this);
        }

    }

    public Order(Builder builder){
        totalPrice = builder.totalPrice;
        startDate = builder.startDate;
        expireDate = builder.expireDate;
        lengthWholePlan = builder.lengthWholePlan;
        kcal = builder.kcal;
        diet = builder.diet;
        user = builder.user;
    }
}
