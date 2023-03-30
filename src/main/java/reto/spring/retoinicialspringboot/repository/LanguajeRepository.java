package reto.spring.retoinicialspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reto.spring.retoinicialspringboot.entity.Languaje;

@Repository
public interface LanguajeRepository extends JpaRepository<Languaje, Long> {
    public Languaje findLanguajeByIso(String iso);
}
