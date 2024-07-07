package com.vota_ya.vota_ya.service;

import com.vota_ya.vota_ya.repository.Candidato;
import com.vota_ya.vota_ya.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository cr;

    public List<Candidato> allCandidatos(){
        return cr.findAll();
    }

    public String addCandidato(Candidato c){
        try{
            cr.save(c);
            return "Guardado con éxito";
        } catch (Exception e){
            return e.getMessage();
        }
    }

    public void votar(Candidato c){
        Candidato ca = cr.findByPartido(c.getPartido());
        ca.addVote();
        cr.save(ca);
    }
}
