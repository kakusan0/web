package com.jp.web.Service;

import com.jp.web.Model.userstorage;
import com.jp.web.Repository.jpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class Login {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private jpaRepository repository;

    /**
     * ユーザー情報存在確認
     *
     * @param user ユーザー名
     * @param pw   パスワード
     */
    public boolean check(String user, String pw) {
        userstorage checks = new userstorage();
        checks.setMail(user);
        checks.setPw(bCryptPasswordEncoder.encode(pw));
        Optional<userstorage> check = repository.findByUserAndPw(checks.getMail(), checks.getPw());
        return check.isEmpty();
    }

    /**
     * ユーザー情報を登録
     *
     * @param user ユーザー名
     * @param pw   パスワード
     */
    public void newUser(String user, String pw) {
        userstorage User = new userstorage();
        User.setMail(user);
        User.setPw(bCryptPasswordEncoder.encode(pw));
        repository.save(User);
    }
}
