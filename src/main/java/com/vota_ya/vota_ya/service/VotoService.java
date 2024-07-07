package com.vota_ya.vota_ya.service;

import com.vota_ya.vota_ya.repository.Voto;
import com.vota_ya.vota_ya.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {
    @Autowired
    private VotoRepository vr;

    public boolean registrarVoto(String student){
        try{
            Voto v = new Voto();
            v.setStudent(student);
            vr.save(v);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean habilVotar(String student){
        Voto v = vr.findByStudent(student);
        return v == null;
    }
}
