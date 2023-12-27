package com.example.demo.Service;

import com.example.demo.Model.userstorage;
import com.example.demo.Repository.jpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Login {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private jpaRepository repository;

    public boolean check(String user, String pw) {
        userstorage newUser = new userstorage();
        newUser.setUser(user);
        newUser.setPw(bCryptPasswordEncoder.encode(pw));
        Optional<userstorage> check = repository.findByuser(user);
        return check.isPresent();
    }

    /**
     * ユーザー情報を登録するメソッド
     *
     * @param user ユーザー名
     * @param pw   パスワード
     */
    public void registerUser(String user, String pw) {
        userstorage newUser = new userstorage();
        newUser.setUser(user);
        newUser.setPw(bCryptPasswordEncoder.encode(pw));
        repository.save(newUser);
    }
}
