package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Datastorage;
import com.example.demo.Repository.Dataexecute;
import com.example.demo.Service.Login;
import com.example.demo.Service.Newaccount;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;

	@Autowired
	private Login Login;

	private Dataexecute findlogin;

	@Autowired
	public void findlogin(Dataexecute dataexecute) {
		this.findlogin = dataexecute;
	}

	private Newaccount Newaccount;

	@Autowired
	public void aaaa(Newaccount Newaccount) {
		this.Newaccount = Newaccount;
	}

	/**
	 * アクセス時
	 * @param mv
	 * @param data
	 * @return
	 */
	@GetMapping("/")
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("showSection1", true);
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
		boolean isAuthenticated = Login.logincheck(data.getMail(), data.getPw());
		if (isAuthenticated) {
			session.setAttribute("form", data);
			return "redirect:/Login3";
		} else {
			return "redirect:/Login2";
		}
	}

	/** ログイン時：第二処理
	 * 
	 * @param mv
	 * @return
	 */
	@GetMapping("Login2")
	public ModelAndView Login2(ModelAndView mv) {
		mv.addObject("showSection2", true);
		mv.setViewName("Login");
		session.invalidate();
		return mv;
	}

	/** ログイン時：第三処理
	 * 
	 * @param mv
	 * @return
	 */
	@GetMapping("Login3")
	public ModelAndView Login3(ModelAndView mv) {
		Datastorage form = (Datastorage) session.getAttribute("form");
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

	/** ログイン時：第四処理
	 * 
	 * @param mv
	 * @return
	 */
	@PostMapping("userAdd")
	public ModelAndView Login4(@ModelAttribute Datastorage data, ModelAndView mv) {
		//boolean isAuthenticated = Login.login();
		Newaccount.addUser(data.getMail(), data.getPw());
		mv.setViewName("Login");
		session.invalidate();
		return mv;
	}

	/** ログアウト
	 * 
	 * @param mv
	 * @return
	 */
	@GetMapping("/logout")
	public ModelAndView logout(ModelAndView mv) {
		session.invalidate();
		mv.setViewName("logout");
		return mv;
	}

	//	@Autowired
	//	private YourService yourService;
	//
	//	@GetMapping("test")
	//	public ResponseEntity<String> exportToCSV() throws IOException {
	//		//yourService.exportToCSV("output.csv");
	//		yourService.updateData2Column();
	//		return ResponseEntity.ok("CSVファイルが正常に出力されました");
	//	}

}