package com.jp.web.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "userstorage")
public class userstorage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    int id;

    @Column(name = "email", unique = true)
    String mail;

    @Column(name = "username", unique = true)
    String user;

    @Column(name = "password")
    String pw;

    @Column(name = "NG_flag")
    boolean NG_flag;

    @Column(name = "NG_date")
    Date NG_date;
}