package pl.mnowicka.autobus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mnowicka.autobus.entities.User;
import pl.mnowicka.autobus.repositories.UserRepository;

/**
 * Created by magda on 2017-01-24.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            +  accountDto.getEmail());
        }
        User user = new User();
        user.setUsername(accountDto.getUsername());
        user.setSurname(accountDto.getSurname());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
//        user.setUserRolesById(Acc);
        return repository.save(user);

    }
    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}