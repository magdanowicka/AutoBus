package pl.mnowicka.autobus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mnowicka.autobus.entities.User;
import pl.mnowicka.autobus.entities.VerificationToken;

/**
 * Created by magda on 2017-01-28.
 */
public interface VerificationTokenRepository
        extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}