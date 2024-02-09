package dinodidiodoro.u5s1ProgettoSettimanale;

import com.github.javafaker.Faker;
import dinodidiodoro.u5s1ProgettoSettimanale.classi.*;
import dinodidiodoro.u5s1ProgettoSettimanale.repositories.EdificioRepository;
import dinodidiodoro.u5s1ProgettoSettimanale.repositories.UtenteRepository;
import dinodidiodoro.u5s1ProgettoSettimanale.services.PostazioneService;
import dinodidiodoro.u5s1ProgettoSettimanale.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class MainRunner implements CommandLineRunner {

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private EdificioRepository edificiorepository;

    @Autowired
    private UtenteRepository utenterepository;

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker();

        Edificio edificio1 = new Edificio(faker.name().fullName(), faker.address().streetAddress(), faker.address().city());
        Edificio edificio2 = new Edificio(faker.name().fullName(), faker.address().streetAddress(), faker.address().city());

        Postazione postazione1 = new Postazione(faker.lorem().sentence(), TipoPostazione.PRIVATO, faker.number().numberBetween(10, 20));
        postazione1.setEdificio(edificio1);

        Postazione postazione2 = new Postazione(faker.lorem().sentence(), TipoPostazione.OPENSPACE, faker.number().numberBetween(10, 60));
        postazione2.setEdificio(edificio2);

        Utente utente1 = new Utente(faker.name().fullName(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
        Utente utente2 = new Utente(faker.name().fullName(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());

        edificiorepository.save(edificio1);
        edificiorepository.save(edificio2);
        postazioneService.save(postazione1);
        postazioneService.save(postazione2);
        utenterepository.save(utente1);
        utenterepository.save(utente2);

        String citta = "West Raymundoburgh";
        List<Postazione> postazioniMilano = postazioneService.ricercaPostazioniPerTipoECitta(TipoPostazione.OPENSPACE, citta);
        System.out.println("Postazioni a " + citta +": " + postazioniMilano);

        LocalDate dataPrenotazione = LocalDate.now();
        boolean disponibile = prenotazioneService.verificaDisponibilitaPostazionePerData(postazione1, dataPrenotazione);
        System.out.println("La postazione è disponibile");

        if (disponibile) {
            Prenotazione prenotazione1 = prenotazioneService.effettuaPrenotazione(postazione1, utente1, dataPrenotazione);
            System.out.println("Prenotazione effettuata: " + prenotazione1);

            List<Prenotazione> prenotazioniUtente1 = prenotazioneService.getPrenotazioniByUtente(utente1);
            System.out.println("Prenotazioni dell'utente: " + prenotazioniUtente1);
        } else {
            System.out.println("La postazione non è disponibile per la prenotazione.");
        }

        List<Prenotazione> prenotazioniUtente2 = prenotazioneService.getPrenotazioniByUtente(utente2);
        System.out.println("Prenotazioni dell'utente 2: " + prenotazioniUtente2);
    }
}
