package br.com.hurpia.megasena.api.service;

import br.com.hurpia.megasena.api.model.Megasena;
import br.com.hurpia.megasena.api.repository.MegasenaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MegasenaService {

    private final MegasenaRepository megasenaRepository;

    public MegasenaService(MegasenaRepository megasenaRepository) {
        this.megasenaRepository = megasenaRepository;
    }

    public Optional<Megasena> getLastActiveSorteio() {
        return megasenaRepository.findUltimoSorteioEncerrado();
    }

    public List<Megasena> getAllResults() {
        return megasenaRepository.findAll();
    }

    public Optional<Megasena> getResultById(Integer id) {
        return megasenaRepository.findById(id);
    }

    public Megasena saveResult(Megasena megasena) {
        return megasenaRepository.save(megasena);
    }
}
