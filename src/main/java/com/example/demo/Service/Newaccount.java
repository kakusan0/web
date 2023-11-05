package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Datastorage;
import com.example.demo.Model.NG;
import com.example.demo.Repository.Dataexecute;
import com.example.demo.Repository.NGrepository;

@Service
public class Newaccount {

	@Autowired
	private Login Login;

	private static NG NG;

	@Autowired
	public void NG(NG NG) {
		Newaccount.NG = NG;
	}

	private static NGrepository NGrepository;

	@Autowired
	public void NGrepository(NGrepository NGrepository) {
		Newaccount.NGrepository = NGrepository;
	}

	@Autowired
	private Dataexecute Dataexecute;

	@Autowired
	public void Dataexecute(Dataexecute dataexecute) {
		this.Dataexecute = dataexecute;
	}

	private Datastorage datastorage;

	@Autowired
	public void datastorage(Datastorage datastorage) {
		this.datastorage = datastorage;
	}

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public Newaccount(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Transactional
	public String addUser(String email, String pw) {
		Boolean check = Login.logincheck(email, pw);
		if (!check) {
			return isStats(0);
		}
		String encodedPassword = bCryptPasswordEncoder.encode(pw);
		datastorage.setMail(email);
		datastorage.setPw(encodedPassword);
		Dataexecute.save(datastorage);
		return "true";	
	}

	public String isStats(int... is) {
		if (is[0] == 1) {
			NG.setId(0);
			String[] a = NGrepository.findById(0).toString().split(" ");
			String b = a[1].replaceAll(",", "").replaceAll("text=", "");
			return b;
		}
		return null;
	}

}
