package pl.coderslab.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.repository.UserRepository;


@Configuration
public class Main {

    private UserRepository userRepository;

    public Main(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

//        userRepository.delete(userRepository.getById(5L));
//        User user2 = new User.Builder().username("Spike")
//                .password(passwordEncoder.
//                        encode("1234")).
//                        email("spike13@interia.pl").
//                        role("ROLE_USER").
//                        build();
//        userRepository.save(user2);
    }


}
