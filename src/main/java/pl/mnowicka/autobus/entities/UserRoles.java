package pl.mnowicka.autobus.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by magda on 2017-01-26.
 */
@Entity
@Table(name = "user_roles", schema = "public", catalog = "AutoBus")
public class UserRoles {
    private int id;
    private int userId;
    private String role;
    private User userRolesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles that = (UserRoles) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(User userRolesById) {
        this.userRolesById = userRolesById;
    }

}
