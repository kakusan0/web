package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Datastorage;
import com.example.demo.Repository.Dataexecute;

@Service
public class Newaccount {

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

	@Autowired
	public Newaccount(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Transactional
	public void addUser(String email, String pw) {
		String encodedPassword = bCryptPasswordEncoder.encode(pw);
		datastorage.setMail(email);
		datastorage.setPw(encodedPassword);
		Dataexecute.save(datastorage);
	}

}
