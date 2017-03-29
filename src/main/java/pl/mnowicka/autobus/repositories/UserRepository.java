package pl.mnowicka.autobus.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mnowicka.autobus.entities.User;

/**
 * Created by magda on 2017-01-24.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findByEmail(String email);

    User findOneByUsername(String username);

    User findOneByEmail(String email);

    User findOneByUsernameOrEmail(String username, String email);

}
