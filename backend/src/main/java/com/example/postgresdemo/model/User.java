package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "users", indexes = {@Index(name = "i1",  columnList="username", unique = true)})
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userid;

    @Column(name="username")
    private String username;

    @Column()
    private String password;

    @Column()
    private String email;

    @Column()
    private String name;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }
}
