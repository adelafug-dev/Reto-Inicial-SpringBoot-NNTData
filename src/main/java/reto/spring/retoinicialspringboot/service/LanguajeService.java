package reto.spring.retoinicialspringboot.service;

import reto.spring.retoinicialspringboot.entity.Languaje;

import java.util.List;

public interface LanguajeService {

    List<Languaje> listAllLanguajes();
    Languaje createLanguaje(Languaje languaje);
    Languaje getLanguaje(Long id);
    Languaje updateLanguaje(Languaje languaje);
    Languaje getLanguajeByIso(String iso);
    Languaje deleteLanguaje(String iso);

}
