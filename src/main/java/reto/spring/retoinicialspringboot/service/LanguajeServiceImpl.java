package reto.spring.retoinicialspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.spring.retoinicialspringboot.entity.Languaje;
import reto.spring.retoinicialspringboot.repository.LanguajeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguajeServiceImpl implements LanguajeService{

    @Autowired
    LanguajeRepository languajeRepository;

    @Override
    public List<Languaje> listAllLanguajes(){
        return languajeRepository.findAll();
    }

    @Override
    public Languaje getLanguaje(Long id){
        return languajeRepository.findById(id).orElse(null);
    }

    @Override
    public Languaje getLanguajeByIso(String iso){
        return languajeRepository.findLanguajeByIso(iso);
    }

    @Override
    public Languaje createLanguaje(Languaje languaje){
        return languajeRepository.save(languaje);
    }

    @Override
    public Languaje updateLanguaje(Languaje languaje){
        Languaje languaje1 = languajeRepository.findLanguajeByIso(languaje.getIso());
        if (languaje1 == null){
            return null;
        }

        languaje1.setIso(languaje.getIso().toUpperCase());
        languaje1.setMessage(languaje.getMessage().toUpperCase());

        return languajeRepository.save(languaje1);
    }

    @Override
    public Languaje deleteLanguaje(String iso){
        Languaje languaje = getLanguajeByIso(iso);
        languajeRepository.delete(languaje);
        return languaje;
    }

}
