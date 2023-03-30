package reto.spring.retoinicialspringboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity @Builder
@Table(name = "languaje")
public class Languaje {

    // A la hora de usar GenerationType.IDENTITY no debo de generarlo en la bbdd , ya se genera solo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Si no lo llamo igual en @Colum que el atributo da fallo
    @Column(name = "iso")
    private String iso;

    @Column(name = "message")
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Languaje languaje = (Languaje) o;
        return iso.equals(languaje.iso) && message.equals(languaje.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iso, message);
    }
}
