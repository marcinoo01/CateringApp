package pl.coderslab.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.repository.CityRepository;
import pl.coderslab.repository.DietRepository;
import pl.coderslab.repository.UserRepository;

import java.time.LocalDate;


@Configuration
public class Main {

    private final UserRepository userRepository;
    private final DietRepository dietRepository;
    private final CityRepository cityRepository;

    public Main(UserRepository userRepository, PasswordEncoder passwordEncoder, DietRepository dietRepository, CityRepository cityRepository) {
        this.userRepository = userRepository;
        this.dietRepository = dietRepository;
        this.cityRepository = cityRepository;

//        City city1 = new City.Builder("Cracow").build();
//        City city2 = new City.Builder("Warsaw").build();
//        City city3 = new City.Builder("Gdansk").build();
//        City city4 = new City.Builder("Wrocław").build();
//        City city5 = new City.Builder("Łódź").build();
//        cityRepository.save(city1);
//        cityRepository.save(city2);
//        cityRepository.save(city3);
//        cityRepository.save(city4);
//        cityRepository.save(city5);
//
//        userRepository.delete(userRepository.findById(4L).get());
//        dietRepository.delete(dietRepository.getById(1));
//        Diet diet1 = new Diet.Builder("Vegan Diet", 38.60).description("Made rationally for those who rates healthy lifestyle").build();
//        Diet diet2 = new Diet.Builder("Slimming Diet", 35.60).description("Reductive diet, the best choice mens wanted to lose weight").build();
//        Diet diet3 = new Diet.Builder("Athletic Diet", 41.60).description("Diet created for people who do sports").build();
//        Diet diet4 = new Diet.Builder("Ketogenic Diet", 36.80).description("Restrictive diet relied on cut down on carbohydrate").build();
//        Diet diet5 = new Diet.Builder("Classic Diet", 42.80).description("Classic tastes, diverse ingredients - no limits").build();
//        User user1 = new User.Builder().username("Marcin").password(passwordEncoder.encode("1234")).email("marcin13@interia.pl").role("ROLE_ADMIN").build();
//        User user2 = new User.Builder().username("Spike")
//                .password(passwordEncoder.
//                        encode("1234")).
//                        email("spike13@interia.pl").
//                        role("ROLE_USER").
//                        build();
//        userRepository.save(user1);
//        userRepository.save(user2);
//        dietRepository.save(diet1);
//        dietRepository.save(diet2);
//        dietRepository.save(diet3);
//        dietRepository.save(diet4);
//        dietRepository.save(diet5);

//        dietRepository.updateDescription(1L, "Made rationally for those who rates healthy lifestyle");
//        dietRepository.updateDescription(2L, "Reductive diet, the best choice for mens wanted to lose weight");
//        dietRepository.updateDescription(3L, "Diet created for people who do sports");
//        dietRepository.updateDescription(4L, "Restrictive diet relied on cut down on carbohydrate");
//        dietRepository.updateDescription(5L, "Classic tastes, diverse ingredients - no limits");
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
    }


}