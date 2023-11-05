package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Datastorage;
import com.example.demo.Model.mailstorage;
import com.example.demo.Repository.Dataexecute;
import com.example.demo.Repository.findmail;

@Service
public class Login {

	private findmail findmail1;

	@Autowired
	public void datastorage(findmail findmail1) {
		this.findmail1 = findmail1;
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
		String[] a = findmail1.findById(Mailstorage.getMail()).toString().split(" ");
		try {
			if (a[1].replaceAll(",", "").replaceAll("mail=", "").contains("@")
					&& bCryptPasswordEncoder.matches(pw, a[2].replaceAll(",", "").replaceAll("pw=", ""))) {
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
