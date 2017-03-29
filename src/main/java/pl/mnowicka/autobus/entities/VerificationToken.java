package pl.mnowicka.autobus.entities;

import javax.persistence.*;
import java.sql.Timestamp;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "verification_token", schema = "public", catalog = "AutoBus")
public class VerificationToken {
    private static final int EXPIRATION = 60 * 24;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_id_generator")
    @SequenceGenerator(name = "token_id_generator", sequenceName = "token_id_seq", initialValue = 2, allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Basic
    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Basic
    @Column(name = "expiry_date")
    private Date expiryDate;
    private boolean verified;


    public VerificationToken(String token, User user) {
        super();
        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
        this.verified = false;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    protected VerificationToken() {
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public static int getEXPIRATION() {
        return EXPIRATION;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

}