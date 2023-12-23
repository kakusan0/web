package com.example.demo.Service;

import com.example.demo.Model.userstorage;
import com.example.demo.Repository.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Login {

	private userstorage userstorage;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public void bCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

//	public boolean logincheck() {
////		String[] a = find.findById(userstorage.getMail()).toString().split(" ");
//		JdbcRepository.singleselect("select * from ");
//		int i = 0;
//		try {
//			if (a[1].replaceAll(",", "").replaceAll("mail=", "").contains("@")
//					&& bCryptPasswordEncoder.matches(pw, a[2].replaceAll(",", "").replaceAll("pw=", ""))) {
//			} else if (i == 0) {
//				return true;
//			} else {
//				userstorage.setNG_flag(false);
//				Dataexecute.save(datastorage);
//			}
//		} catch (InvalidDataAccessApiUsageException e) {
//			//e.printStackTrace();
//			return false;
//		}
//		return false;
//
//	}
}
