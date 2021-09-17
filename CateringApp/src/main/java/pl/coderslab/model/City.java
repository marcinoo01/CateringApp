package pl.coderslab.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;

    public static class Builder{
        private final String cityName;

        public Builder(String val){
            this.cityName = val;
        }

        public City build(){
            return new City(this);
        }
    }

    private City(Builder builder){
        cityName = builder.cityName;
    }
}
