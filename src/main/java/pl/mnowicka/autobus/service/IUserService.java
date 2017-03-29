package pl.mnowicka.autobus.service;

import pl.mnowicka.autobus.domain.UserDto;
import pl.mnowicka.autobus.entities.User;
import pl.mnowicka.autobus.entities.VerificationToken;

/**
 * Created by magda on 2017-01-24.
 */
public interface IUserService {

    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);
}