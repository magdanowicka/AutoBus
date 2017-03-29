package pl.mnowicka.autobus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mnowicka.autobus.domain.UserDto;
import pl.mnowicka.autobus.entities.User;
import pl.mnowicka.autobus.entities.VerificationToken;
import pl.mnowicka.autobus.repositories.UserRepository;
import pl.mnowicka.autobus.repositories.VerificationTokenRepository;

/**
 * Created by magda on 2017-01-24.
 */
@Service
public class UserService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {

        logger.info("Tworzenie nowego konta...");
        if (emailExist(accountDto.getEmail())) {
            logger.error("Konto juz sitnieje dla emaila " + accountDto.getEmail());
            throw new EmailExistsException(
                    "Istenie już konto z tym adresem email: "
                            + accountDto.getEmail());
        }

        User user = new User();
        user.setUsername(accountDto.getUsername());
        user.setSurname(accountDto.getSurname());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));

        user.setEmail(accountDto.getEmail());
        user.setPhone(accountDto.getPhone());
        user.setEnabled(true);

        return repository.save(user);
    }

    @Override
    public User getUser(String verificationToken) {
        User user = tokenRepository.findByToken(verificationToken).getUser();
        user.setEnabled(true);
        repository.save(user);
        return user;
    }

    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void saveRegisteredUser(User user) {
        repository.save(user);
    }

    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}