package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Diet;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface DietRepository extends JpaRepository<Diet, Long> {
    Optional<Diet> findByDietName(String dietName);

    @Modifying
    @Query("update Diet d set d.description = :description where d.id = :id")
    void updateDescription(@Param(value = "id") Long id, @Param(value = "description") String description);
}

