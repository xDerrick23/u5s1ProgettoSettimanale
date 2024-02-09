package dinodidiodoro.u5s1ProgettoSettimanale.classi;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "postazione")
@Getter
@Setter
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    private int numeroMassimoOccupanti;
    @ManyToOne
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;
    public Postazione(String descrizione, TipoPostazione tipo, int numeroMassimoOccupanti) {

        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroMassimoOccupanti = numeroMassimoOccupanti;
        this.prenotazioni = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Postazione [descrizione=" + descrizione + ", tipo=" + tipo + ", numeroMassimoOccupanti="
                + numeroMassimoOccupanti + "]";
    }

}