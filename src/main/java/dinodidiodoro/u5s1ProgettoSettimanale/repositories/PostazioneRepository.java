package dinodidiodoro.u5s1ProgettoSettimanale.repositories;

import dinodidiodoro.u5s1ProgettoSettimanale.classi.Postazione;
import dinodidiodoro.u5s1ProgettoSettimanale.classi.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    public List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}