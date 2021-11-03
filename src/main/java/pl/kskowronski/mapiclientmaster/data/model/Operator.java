package pl.kskowronski.mapiclientmaster.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "operatorzy")
public class Operator {

    @Id
    @Column(name="id_operator")
    private BigDecimal id;

    @Column(name="kod")
    private String login;

    @Column(name="haslo")
    private String password;

    public Operator() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
