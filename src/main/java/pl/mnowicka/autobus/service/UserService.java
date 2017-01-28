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

        logger.info("Creating new user account...");
        if (emailExist(accountDto.getEmail())) {
            logger.error("Account already exists with email "+accountDto.getEmail());
            throw new EmailExistsException(
                    "There is an account with that email address: "
                            + accountDto.getEmail());
        }

        User user = new User();
        user.setUsername(accountDto.getUsername());
        user.setSurname(accountDto.getSurname());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setPhone(accountDto.getPhone());

//        user.setUserRolesById(Acc);
        return repository.save(user);

    }
    private boolean emailExist(String email) {
        System.out.println("weszlo dp emailexists");

        User user = repository.findByEmail(email);
        if (user != null) {
            System.out.println("wuser != null");
            return true;
        }
        System.out.println("user == null");
        return false;
    }

    @Override
    public User getUser(String verificationToken) {
        User user = tokenRepository.findByToken(verificationToken).getUser();
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
        System.out.println("weszlo do create veri token");
        VerificationToken myToken = new VerificationToken(token, user);
        System.out.println("myToken:" + myToken);
        tokenRepository.save(myToken);
    }
}