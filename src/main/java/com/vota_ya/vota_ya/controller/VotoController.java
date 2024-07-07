package com.vota_ya.vota_ya.controller;

import com.vota_ya.vota_ya.repository.Candidato;
import com.vota_ya.vota_ya.service.CandidatoService;
import com.vota_ya.vota_ya.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/votaya")
@RestController
public class VotoController {
    @Autowired
    private VotoService vs;

    @Autowired
    private CandidatoService cs;

    @GetMapping("/habilVotar/{student}")
    public boolean habilVotar(@PathVariable String student){
        return vs.habilVotar(student);
    }

    @GetMapping("/candidatos")
    public List<Candidato> candidatos(){
        return cs.allCandidatos();
    }

    @PostMapping("/votar/{student}")
    public boolean votar(@RequestBody Candidato c, @PathVariable String student){
        if (vs.habilVotar(student)){
            if (vs.registrarVoto(student)){
                cs.votar(c);}
                return true;
        }

        return false;
    }

    @PostMapping("addCandidato")
    public String addCandidato(@RequestBody Candidato c){
        return cs.addCandidato(c);
    }

    @GetMapping("/estadisticas")
    public String estadísticas(){
        List<Candidato> can = cs.allCandidatos();
        String est = "";
        int totales = 0;

        for(Candidato c: can){
            totales += c.getVotos();
        }
        est += "Votos totales: " + totales + "\n\n";

        for(Candidato c: can){
            double porcentaje = (double) c.getVotos() / totales * 100;
            est += "Candidato: " + c.getNombreCandidato() +
                    "\nPartido: " + c.getPartido() +
                    "\nVotos: " + c.getVotos() + " (" + String.format("%.2f", porcentaje) + "%)\n\n";
        }

        return est;
    }

}
