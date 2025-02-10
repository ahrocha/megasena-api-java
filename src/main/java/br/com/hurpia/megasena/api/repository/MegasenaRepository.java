package br.com.hurpia.megasena.api.repository;

import br.com.hurpia.megasena.api.model.Megasena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MegasenaRepository extends JpaRepository<Megasena, Integer> {

    @Query("SELECT m FROM Megasena m WHERE m.cdStatusSorteio = 3 ORDER BY m.cdSorteio DESC LIMIT 1")
    Optional<Megasena> findUltimoSorteioEncerrado();

}
