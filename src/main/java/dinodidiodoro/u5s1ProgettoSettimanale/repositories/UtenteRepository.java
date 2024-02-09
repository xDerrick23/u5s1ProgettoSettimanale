package dinodidiodoro.u5s1ProgettoSettimanale.repositories;

import dinodidiodoro.u5s1ProgettoSettimanale.classi.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
}