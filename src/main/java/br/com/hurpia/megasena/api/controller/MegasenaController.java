package br.com.hurpia.megasena.api.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.hurpia.megasena.api.model.Megasena;
import br.com.hurpia.megasena.api.service.MegasenaService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/megasena")
public class MegasenaController {

    private MegasenaService megasenaService;

    public MegasenaController(MegasenaService megasenaService) {
        this.megasenaService = megasenaService;
    }

    @GetMapping("/ultima")
    public ResponseEntity<?> getLastSorteio() {
        Optional<Megasena> sorteio = megasenaService.getLastActiveSorteio();

        return sorteio.map(s -> {
            Map<String, Object> response = new HashMap<>();
            response.put("nrSorteio", s.getNrSorteio());
            response.put("dtSorteio", s.getDtSorteio());
            response.put("dsSorteadosSorteio", s.getDsSorteadosSorteio());

            return ResponseEntity.ok(response);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{numero}")
    public ResponseEntity<?> getSorteioByNumero(@PathVariable int numero) {
        Optional<Megasena> sorteio = megasenaService.getSorteioByNumero(numero);

        return sorteio.map(s -> {
            Map<String, Object> response = new HashMap<>();
            response.put("nrSorteio", s.getNrSorteio());
            response.put("dtSorteio", s.getDtSorteio());
            response.put("dsSorteadosSorteio", s.getDsSorteadosSorteio());

            return ResponseEntity.ok(response);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
