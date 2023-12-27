package com.example.demo.Controller;

import com.example.demo.Model.userstorage;
import com.example.demo.Repository.jpaRepository;
import com.example.demo.Service.Login;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    HttpSession session;

    @Autowired
    private Login Login;

    private userstorage userstorage;

    @Autowired
    private jpaRepository repository;

    /**
     * @return ログイン画面に遷移
     * @author 角谷　亮洋
     */
    @GetMapping("/")
    public ModelAndView index(ModelAndView mv) {
        mv.addObject("showSection1", true);
        mv.setViewName("Login");
        return mv;
    }

    /**
     * @author 角谷　亮洋
     * @return ログイン画面か新規ユーザ追加画面のどちらかに遷移
     */
    @GetMapping("/login")
    public String Login1(@ModelAttribute userstorage userstorage) {
        if (Login.check(userstorage.getUser(),userstorage.getPw())) {
            session.setAttribute("form", userstorage);
            return "redirect:/Login3";
        } else {
            session.setAttribute("form", userstorage);
            return "redirect:/Login2";
        }
    }

    @GetMapping("/Login2")
    public ModelAndView Login2(ModelAndView mv) {
        mv.addObject("showSection2", true);
        mv.setViewName("Login");
        session.invalidate();
        return mv;
    }
    @GetMapping("/Login3")
    public ModelAndView Login3(ModelAndView mv) {
        userstorage form = (userstorage) session.getAttribute("form");
        if (form != null) {
            mv.addObject("form", form);
        }
        if (form == null) {
            mv.setViewName("Login");
            return mv;
        }
        mv.setViewName("home");
        session.invalidate();
        return mv;
    }

/*    @PostMapping("/userAdd")
    public ModelAndView Login4(@ModelAttribute userstorage data, ModelAndView mv) {
        String a = Newaccount.addUser(data.getMail(), data.getPw());
        if (a.equals("true")) {
            mv.addObject("form", a);
            mv.setViewName("Login");
            return mv;
        } else {
            mv.addObject("showSection1", true);
            mv.setViewName("Login");
            session.invalidate();
        }
        return mv;
    }*/

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView mv) {
        session.invalidate();
        mv.setViewName("logout");
        return mv;
    }

    /**
     *
     * @param pw　パスワード暗号化テスト
     */
    @GetMapping("/test")
    public void usertest(@NotBlank @RequestParam("user") String user, @NotBlank @RequestParam("pw") String pw) {
        Login.check(user,pw);
        Login.registerUser(user,pw);
        System.out.println();
    }

}