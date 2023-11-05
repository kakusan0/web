package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Datastorage;
import com.example.demo.Service.Login;
import com.example.demo.Service.Newaccount;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;

	@Autowired
	private Login Login;

	private Newaccount Newaccount;

	@Autowired
	public void Newaccount(Newaccount Newaccount) {
		this.Newaccount = Newaccount;
	}

	@GetMapping("/")
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("showSection1", true);
		mv.setViewName("Login");
		return mv;
	}

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

	@GetMapping("Login2")
	public ModelAndView Login2(ModelAndView mv) {
		mv.addObject("showSection2", true);
		mv.setViewName("Login");
		session.invalidate();
		return mv;
	}

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

	@PostMapping("userAdd")
	public ModelAndView Login4(@ModelAttribute Datastorage data, ModelAndView mv) {
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
	}

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