package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Datastorage;
import com.example.demo.Model.mailstorage;
import com.example.demo.Repository.Dataexecute;
import com.example.demo.Repository.find;

@Service
public class Login {

	private find find;

	@Autowired
	public void datastorage(find find) {
		this.find = find;
	}

	private Datastorage datastorage;

	@Autowired
	private Dataexecute Dataexecute;

	@Autowired
	public void Dataexecute(Dataexecute dataexecute) {
		this.Dataexecute = dataexecute;
	}

	@Autowired
	public void datastorage(Datastorage datastorage) {
		this.datastorage = datastorage;
	}

	private mailstorage Mailstorage;

	@Autowired
	public void findlogin(mailstorage Mailstorage) {
		this.Mailstorage = Mailstorage;
	}

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public void bCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder, Dataexecute dataexecute) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public boolean logincheck(String mail, String pw) {
		Mailstorage.setMail(mail);
		Mailstorage.setPw(pw);
		String[] a = find.findById(Mailstorage.getMail()).toString().split(" ");
		int i = 0;
		try {
			if (a[1].replaceAll(",", "").replaceAll("mail=", "").contains("@")
					&& bCryptPasswordEncoder.matches(pw, a[2].replaceAll(",", "").replaceAll("pw=", ""))) {
			} else if (i == 0) {
				return true;
			} else {
				datastorage.setNG_flag(1);
				Dataexecute.save(datastorage);
			}
		} catch (InvalidDataAccessApiUsageException e) {
			//e.printStackTrace();
			return false;
		}
		return false;

	}
}
