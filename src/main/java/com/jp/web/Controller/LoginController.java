package com.jp.web.Controller;

import com.jp.web.Model.userstorage;
import com.jp.web.Service.Login;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    HttpSession session;

    @Autowired
    private Login Login;
//
//    private userstorage userstorage;
//
//    private jpaRepository repository;

    /**
     * @return 1.ログイン画面に遷移
     * @author 角谷　亮洋
     */
    @GetMapping("/")
    public ModelAndView index(ModelAndView mv) {
        mv.addObject("showSection1", true);
        mv.setViewName("account");
        return mv;
    }

    /**
     * @return 1.次の画面に遷移
     * 2.新規ユーザ追加画面に遷移
     * @author 角谷　亮洋
     */
    @PostMapping("/Login")
    public ModelAndView Login(@ModelAttribute userstorage userstorage,ModelAndView mv) {
        String USER = userstorage.getMail();
        String PW = userstorage.getPw();
        //アカウントが存在している場合
        if (!Login.check(USER, PW)) {
            session.setAttribute("USER", USER);
            mv.setViewName("redirect:/test");
        } else {
            //アカウントが存在しない場合、
            //新規アカウント登録画面に遷移
            mv.addObject("showSection2", true);
            mv.setViewName("account");
        }
        return mv;
    }

//    @GetMapping("/postcode-search")
//    public ModelAndView Login3(ModelAndView mv) {
//        userstorage form = (userstorage) session.getAttribute("form");
//        if (form != null) {
//            mv.addObject("form", form);
//            mv.setViewName("test");
//        }
//        mv.setViewName("Login");
//        return mv;
//    }

//    /**
//     * @return 1.新規アカウント登録画面に遷移
//     * @author 角谷　亮洋
//     */
//    @GetMapping("/signup")
//    public ModelAndView signup(ModelAndView mv) {
//        mv.addObject("showSection2", true);
//        mv.setViewName("account");
//        return mv;
//    }

    /**
     * @return 1.次の画面に遷移
     * 2.新規ユーザ追加画面に遷移
     * @author 角谷　亮洋
     */
    @PostMapping("/userAdd")
    public ModelAndView userAdd(@ModelAttribute userstorage userstorage, ModelAndView mv) {
        //userが登録できる場合
        String USER = userstorage.getMail();
        String PW = userstorage.getPw();
        if (Login.check(USER, PW)) {
            Login.newUser(USER, PW);
            session.setAttribute("USER", USER);
            mv.setViewName("redirect:/test");
        } else {
            mv.addObject("showSection2", true);
            mv.setViewName("redirect:/Login");
        }
        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView mv) {
        session.invalidate();
        mv.setViewName("account");
        return mv;
    }
}