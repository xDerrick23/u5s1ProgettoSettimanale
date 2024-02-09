package dinodidiodoro.u5s1ProgettoSettimanale.classi;


import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prenotazione")
@Getter
@Setter
@NoArgsConstructor

public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Postazione postazione;
    @ManyToOne
    private Utente utente;
    private LocalDate dataPrenotazione;
    public Prenotazione(Postazione postazione, Utente utente, LocalDate dataPrenotazione) {

        this.postazione = postazione;
        this.utente = utente;
        this.dataPrenotazione = dataPrenotazione;
        utente.getPrenotazioni().add(this);
        postazione.getPrenotazioni().add(this);
    }
    @Override
    public String toString() {
        return "Prenotazione [postazione=" + postazione + ", dataPrenotazione=" + dataPrenotazione + "]";
    }
}