package pl.mnowicka.autobus.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by magda on 2017-01-26.
 */
@Entity
@Table(name = "user", schema = "public", catalog = "AutoBus")
public class User {

    private int id;
    private String username;
    private String surname;
    private String password;
    private String email;
    private String phone;
    private boolean enabled;
    private List<Ticket> userTicketsById;
    private List<UserRoles> rolesByUserId;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
    @SequenceGenerator(name="user_id_generator", sequenceName = "user_id_seq", initialValue=2, allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (enabled != that.enabled) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public List<Ticket> getTicketsById() {
        return userTicketsById;
    }

    public void setTicketsById(List<Ticket> ticketsById) {
        this.userTicketsById = ticketsById;
    }

    @OneToMany(mappedBy = "userRolesById")
    public List<UserRoles> getUserByUserId() {
        return rolesByUserId;
    }

    public void setUserByUserId(List<UserRoles> rolesByUserId) {
        this.rolesByUserId = rolesByUserId;
    }



//    @ManyToOne
//    @JoinColumn(name = "id", referencedColumnName = "user_id", nullable = false)
//    public UserRoles getUserRolesById() {
//        return userRolesById;
//    }
//
//    public void setUserRolesById(UserRoles userRolesById) {
//        this.userRolesById = userRolesById;
//    }

}
