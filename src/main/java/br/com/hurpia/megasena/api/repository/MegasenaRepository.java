package br.com.hurpia.megasena.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hurpia.megasena.api.model.Megasena;

@Repository
public interface MegasenaRepository extends JpaRepository<Megasena, Integer> {

    @Query("SELECT m FROM Megasena m WHERE m.status = 1 ORDER BY m.id DESC LIMIT 1")
    Optional<Megasena> findUltimoSorteioEncerrado();

    @Query("SELECT m FROM Megasena m WHERE m.numero = :numero AND tipo = 1")
    Optional<Megasena> getSorteioByNumero(@Param("numero") int numero);

    @Query("SELECT m FROM Megasena m WHERE tipo = 1 ORDER BY m.numero DESC")
    List<Megasena> findAllByOrderByNrSorteioDesc();

}
