package br.com.hurpia.megasena.api.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hurpia.megasena.api.model.Megasena;
import br.com.hurpia.megasena.api.service.MegasenaService;

@RestController
@RequestMapping("/megasena")
public class MegasenaController {

    private MegasenaService megasenaService;

    public MegasenaController(MegasenaService megasenaService) {
        this.megasenaService = megasenaService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllByOrderByNumeroDesc() {
        return ResponseEntity.ok(megasenaService.getAllByOrderByNumeroDesc());
    }

    @GetMapping("/ultima")
    public ResponseEntity<?> getLastSorteio() {
        Optional<Megasena> sorteio = megasenaService.getLastActiveSorteio();

        return sorteio.map(s -> {
            Map<String, Object> response = new HashMap<>();
            response.put("numero", s.getNumero());
            response.put("data", s.getData());
            response.put("sorteados", s.getSorteados());
            response.put("next", null);
            response.put("previous", s.getNumero() - 1);

            return ResponseEntity.ok(response);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{numero}")
    public ResponseEntity<?> getSorteioByNumero(@PathVariable int numero) {
        Optional<Megasena> sorteio = megasenaService.getSorteioByNumero(numero);

        return sorteio.map(s -> {
            Map<String, Object> response = new HashMap<>();
            response.put("nrSorteio", s.getNumero());
            response.put("dtSorteio", s.getData());
            response.put("dsSorteadosSorteio", s.getSorteados());
            response.put("next", s.getNumero() + 1);
            response.put("previous", s.getNumero() - 1);

            return ResponseEntity.ok(response);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
