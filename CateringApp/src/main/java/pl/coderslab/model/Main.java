package pl.coderslab.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.repository.DietRepository;
import pl.coderslab.repository.UserRepository;

import java.time.LocalDate;


@Configuration
public class Main {

    private UserRepository userRepository;
    private DietRepository dietRepository;

    public Main(UserRepository userRepository, PasswordEncoder passwordEncoder, DietRepository dietRepository) {
        this.userRepository = userRepository;
        this.dietRepository = dietRepository;

//        dietRepository.delete(dietRepository.getById(1));
//        Diet diet1 = new Diet.Builder("Vegan Diet", 38.60).description("Made rationally for those who rates healthy lifestyle").build();
//        Diet diet2 = new Diet.Builder("Slimming Diet", 35.60).description("Reductive diet, the best choice mens wanted to lose weight").build();
//        Diet diet3 = new Diet.Builder("Athletic Diet", 41.60).description("Diet created for people who do sports").build();
//        Diet diet4 = new Diet.Builder("Ketogenic Diet", 36.80).description("Restrictive diet relied on cut down on carbohydrate").build();
//        Diet diet5 = new Diet.Builder("Classic Diet", 42.80).description("Classic tastes, diverse ingredients - no limits").build();
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
//        userRepository.delete(userRepository.getById(5L));
//        User user2 = new User.Builder().username("Spike")
//                .password(passwordEncoder.
//                        encode("1234")).
//                        email("spike13@interia.pl").
//                        role("ROLE_USER").
//                        build();
//        userRepository.save(user2);