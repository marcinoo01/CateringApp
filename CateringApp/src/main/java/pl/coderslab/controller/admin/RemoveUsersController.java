package pl.coderslab.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import java.util.Optional;

@Controller
public class RemoveUsersController {

    private final UserRepository userRepository;

    @Autowired
    public RemoveUsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/admin/delete/{id}")
    public String delete(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.get());
        return "redirect:/admin";
    }
}
