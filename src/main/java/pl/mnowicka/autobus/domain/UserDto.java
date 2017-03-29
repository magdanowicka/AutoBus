package pl.mnowicka.autobus.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import pl.mnowicka.autobus.entities.UserRoles;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by magda on 2017-01-24.
 */

public class UserDto {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String surname;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull(message = "not match")
    private String matchingPassword;

    @Email
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 9, max = 9)
    private String phone;


    public String getUsername() {
        return username;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
        checkPassword();
    }

    public void setEmail(String email) {
        this.email = email;
        isValidEmail(email);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private void checkPassword() {
        if (this.password == null || this.matchingPassword == null) {
            return;
        } else if (!this.password.equals(matchingPassword)) {
            this.matchingPassword = null;
        }
    }

    public static boolean isValidEmail(String enteredEmail){
        String EMAIL_REGIX = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(EMAIL_REGIX);
        Matcher matcher = pattern.matcher(enteredEmail);

        return ((!enteredEmail.isEmpty()) && (enteredEmail!=null) && (matcher.matches()));
    }
}
