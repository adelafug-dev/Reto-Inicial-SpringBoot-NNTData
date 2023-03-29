package reto.spring.retoinicialspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "languaje")
public class Languaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iso")
    private String iso6391;

    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Languaje languaje = (Languaje) o;
        return id.equals(languaje.id) && iso6391.equals(languaje.iso6391) && message.equals(languaje.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iso6391, message);
    }

}
