package com.okta.examples.jpa.BeyondAuthentication;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class UserEvent {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Lob
    private String token;

    private String userId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date loginAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date tokenIssuedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastViewedAt;

    public UserEvent() {}

    public UserEvent(String userId, String name, String token, Date loginAt, Date issueAt) {
        this.userId=userId;
        this.name = name;
        this.token = token;
        this.loginAt = loginAt;
        this.lastViewedAt=loginAt;
        this.tokenIssuedAt=issueAt;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", loginAt='" + loginAt + '\'' +
                '}';
    }

    // put boilerplate getters and setters here

    @Transient
    public String getTokenIssuedAtString() {
        return formatter.format(tokenIssuedAt);
    }

    @Transient
    public String getLastViewedAtString() {
        return formatter.format(lastViewedAt);
    }

    @Transient
    public String getLoginAtString() {
        return formatter.format(loginAt);
    }

    public void setLastViewedAt(Date lastViewedAt) {
        this.lastViewedAt = lastViewedAt;
    }

    public static void setFormatter(SimpleDateFormat formatter) {
        UserEvent.formatter = formatter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLoginAt(Date loginAt) {
        this.loginAt = loginAt;
    }

    public void setTokenIssuedAt(Date tokenIssuedAt) {
        this.tokenIssuedAt = tokenIssuedAt;
    }

    public static SimpleDateFormat getFormatter() {
        return formatter;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }

    public Date getLoginAt() {
        return loginAt;
    }

    public Date getTokenIssuedAt() {
        return tokenIssuedAt;
    }

    public Date getLastViewedAt() {
        return lastViewedAt;
    }
}