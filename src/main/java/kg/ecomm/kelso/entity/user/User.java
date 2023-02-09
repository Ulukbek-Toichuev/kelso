package kg.ecomm.kelso.entity.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private long userId;

    @Column(name = "users_name")
    private String username;

    @Column(name = "users_email", nullable = false)
    private String userEmail;

    @Column(name = "users_phone_num")
    private String usersPhoneNum;

    @Column(name = "users_hash_password")
    private String usersPassword;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "users_registered_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userRegisteredDate;

    public User() {}

    public User(long userId, String username, String userEmail, String usersPhoneNum
            , String usersPassword, String userRole, Date userRegisteredDate) {
        this.userId = userId;
        this.username = username;
        this.userEmail = userEmail;
        this.usersPhoneNum = usersPhoneNum;
        this.usersPassword = usersPassword;
        this.userRole = userRole;
        this.userRegisteredDate = userRegisteredDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usersName) {
        this.username = usersName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUsersPhoneNum() {
        return usersPhoneNum;
    }

    public void setUsersPhoneNum(String usersPhoneNum) {
        this.usersPhoneNum = usersPhoneNum;
    }

    public String getUsersPassword() {
        return usersPassword;
    }

    public void setUsersPassword(String usersPassword) {
        this.usersPassword = usersPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String usersRole) {
        this.userRole = usersRole;
    }

    public Date getUserRegisteredDate() {
        return userRegisteredDate;
    }

    public void setUserRegisteredDate(Date userRegisteredDate) {
        this.userRegisteredDate = userRegisteredDate;
    }
}