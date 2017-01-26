package pl.mnowicka.autobus.service;

import pl.mnowicka.autobus.domain.UserDto;
import pl.mnowicka.autobus.entities.User;

/**
 * Created by magda on 2017-01-24.
 */
public interface IUserService {
    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}