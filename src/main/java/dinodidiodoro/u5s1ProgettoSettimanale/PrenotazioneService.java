package dinodidiodoro.u5s1ProgettoSettimanale;

import dinodidiodoro.u5s1ProgettoSettimanale.classi.Postazione;
import dinodidiodoro.u5s1ProgettoSettimanale.classi.Prenotazione;
import dinodidiodoro.u5s1ProgettoSettimanale.classi.Utente;
import dinodidiodoro.u5s1ProgettoSettimanale.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public boolean verificaDisponibilitaPostazionePerData(Postazione postazione, LocalDate dataPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
        return prenotazioni.isEmpty();
    }

    public Prenotazione effettuaPrenotazione(Postazione postazione, Utente utente, LocalDate dataPrenotazione) {
        if (verificaDisponibilitaPostazionePerData(postazione, dataPrenotazione)) {
            Prenotazione prenotazione = new Prenotazione(postazione, utente, dataPrenotazione);
            return prenotazioneRepository.save(prenotazione);
        }
        return null;
    }

    public List<Prenotazione> getPrenotazioniByUtente(Utente utente) {
        return prenotazioneRepository.findByUtente(utente);
    }
}