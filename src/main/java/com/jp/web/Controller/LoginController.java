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
    private Login Login;
    /*
    * @param ログイン制御
     */
    @Autowired
    public void loginController(Login Login){
        this.Login = Login;
    }

    HttpSession session;
    /*
     * @param セッション制御
     */
    @Autowired
    public void sessionController(HttpSession session){
        this.session = session;
    }

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
     * @return 1.次の画面に遷移<br>
     * 2.新規ユーザ追加画面に遷移
     * @author 角谷　亮洋
     */
    @PostMapping("/Login")
    public ModelAndView Login(@ModelAttribute userstorage userstorage, ModelAndView mv) {
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

    /**
     * @return 1.次の画面に遷移<br>
     * 2.新規ユーザ追加画面に遷移
     * @author 角谷　亮洋
     */
    @PostMapping("/userAdd")
    public ModelAndView userAdd(@ModelAttribute userstorage userstorage, ModelAndView mv) {
        String USER = userstorage.getMail();
        String PW = userstorage.getPw();
        //アカウントが登録できる場合
        if (Login.check(USER, PW)) {
            Login.newUser(USER, PW);
            session.setAttribute("USER", USER);
            mv.setViewName("redirect:/test");
        } else {
            //アカウントが存在しない場合、
            //新規アカウント登録画面に遷移
            mv.addObject("showSection2", true);
            mv.setViewName("redirect:/Login");
        }
        return mv;
    }

    /**
     * @return ログイン画面に遷移
     * @author 角谷　亮洋
     */
    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView mv) {
        session.invalidate();
        mv.setViewName("account");
        return mv;
    }
    @GetMapping("/batch")
    public static String batch() {
        return "front";
    }
}