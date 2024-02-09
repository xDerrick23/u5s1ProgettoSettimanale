package dinodidiodoro.u5s1ProgettoSettimanale.classi;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "edificio")

@Getter
@Setter
@NoArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String indirizzo;
    private String citta;
    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;
    public Edificio(String nome, String indirizzo, String citta) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }
    @Override
    public String toString() {
        return "Edificio [nome=" + nome + ", indirizzo=" + indirizzo + ", citta=" + citta + "]";
    }

}