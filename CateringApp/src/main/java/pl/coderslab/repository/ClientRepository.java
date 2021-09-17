package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Client;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
@Transactional

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findById(Long id);
    @Query("select c from Client c where c.user.id = c.id")
    Optional<Client> findByUserId(Long id);
}
