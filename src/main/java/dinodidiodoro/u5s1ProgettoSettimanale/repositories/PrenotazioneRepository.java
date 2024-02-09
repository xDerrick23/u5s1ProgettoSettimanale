package dinodidiodoro.u5s1ProgettoSettimanale.repositories;

import dinodidiodoro.u5s1ProgettoSettimanale.classi.Postazione;
import dinodidiodoro.u5s1ProgettoSettimanale.classi.Prenotazione;
import dinodidiodoro.u5s1ProgettoSettimanale.classi.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    public List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);

    public List<Prenotazione> findByUtente(Utente utente);
}