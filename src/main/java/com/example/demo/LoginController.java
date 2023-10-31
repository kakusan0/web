package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Datastorage;
import com.example.demo.Service.YourService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;

	/**
	 * アクセス時
	 * @param mv
	 * @param data
	 * @return
	 */
	@GetMapping("/")
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("Login");
		return mv;
	}

	/**　ログイン時：第一処理
	 * 
	 * @param data
	 * @return
	 */
	@PostMapping("login")
	public String Login1(@ModelAttribute Datastorage data) {
		// ログイン情報を保管する
		session.setAttribute("form", data);
		// ログイン後の最初の画面に遷移
		return "redirect:/loginPostView";
	}

	/** ログイン時：第二処理
	 * 
	 * @param mv
	 * @return
	 */
	@GetMapping("loginPostView")
	public ModelAndView Login2(ModelAndView mv) {
		Datastorage form = (Datastorage) session.getAttribute("form");
		// ログインの値がない場合
		if (form != null) {
			mv.addObject("form", form);
		}
		// ブラウザの更新ボタンを押したときに発動する。
		// ログインの値がない場合
		if (form == null) {
			mv.setViewName("Login");
			return mv;
		}
		System.out.print(form.getMail());
		mv.setViewName("home");
		session.invalidate();
		return mv;
	}
	@Autowired
    private YourService yourService;
	@GetMapping("test")
    public ResponseEntity<String> exportToCSV() {
        try {
            yourService.exportToCSV("output.csv");
            return ResponseEntity.ok("CSVファイルが正常に出力されました");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("CSVファイルの出力中にエラーが発生しました");
        }
    }

	/** ログアウト
	 * 
	 * @param mv
	 * @return
	 */
	@GetMapping("/logout")
	public ModelAndView logout(ModelAndView mv) {
		mv.setViewName("logout");
		return mv;
	}
}