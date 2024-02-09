package dinodidiodoro.u5s1ProgettoSettimanale.repositories;

import dinodidiodoro.u5s1ProgettoSettimanale.classi.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}