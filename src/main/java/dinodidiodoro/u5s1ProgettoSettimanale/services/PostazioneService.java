package dinodidiodoro.u5s1ProgettoSettimanale.services;

import dinodidiodoro.u5s1ProgettoSettimanale.classi.Postazione;
import dinodidiodoro.u5s1ProgettoSettimanale.classi.TipoPostazione;
import dinodidiodoro.u5s1ProgettoSettimanale.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> ricercaPostazioniPerTipoECitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

    public void save(Postazione postazione) {
        postazioneRepository.save(postazione);
    }
}