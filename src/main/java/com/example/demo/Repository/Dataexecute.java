package com.example.demo.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Datastorage;

@Repository
public class Dataexecute {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//全件取得する場合は、queryか queryForList メソッドを利用します。
	public List<Datastorage> selectAll() {
		//全件取得のSQLを作成
		String sql = "select * from Datastorage;";
		//SQLを実行
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Datastorage>(Datastorage.class));
	}

	//ログイン時に使用
	//1件だけ取得したい場合は queryForObject メソッドを利用します。
	public Datastorage selectOne(Integer id) {
		//PKを使って1件のみ取得
		String sql = "select local_part from Datastorage where id=?;";
		//SQLを実行
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Datastorage>(Datastorage.class), id);
	}

	//DBを更新したい場合は update メソッドを利用します。
	public int insertOne(Datastorage Datastorage) {

		//1件を新規追加するSQLを作成
		String sql = "insert into Datastorage (id, name) values (?, ?);";
		//SQLを実行
		return jdbcTemplate.update(sql, Datastorage.getMail(), Datastorage.getPw());
	}

	//DBを更新したい場合は update メソッドを利用します。
	public int updateOne(Datastorage Datastorage) {
		//PKを使って1件のみ更新
		String sql = "update Datastorage set name=? where id=?;";
		//SQLを実行する
		return jdbcTemplate.update(sql, Datastorage.getMail(), Datastorage.getPw());
	}

	//DBを削除したい場合は update メソッドを利用します。
	public int deleteOne(Integer id) {
		//PKを使って1件のみ削除
		String sql = "delete from Datastorage where id=?;";
		//SQLを実行する
		return jdbcTemplate.update(sql, id);
	}
}