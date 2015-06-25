package cn.sean.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DBDataAccessObject {
	/*
	 * ��ѯָ���û������ݿ����Ƿ���� select userid,password,emailid
	 */

	public boolean findUser(UserDTO user, Connection conn) {
		String sql = "select * from userinfo where userid= '" +user.getUserid()
				+ "' and password='" +user.getPassword()+"'";
		ResultSet rs = null;
		try{
		rs = execSelect(sql, conn);
		if(rs.next()){
			user.setEmail(rs.getString("email"));
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(null, rs);
		}
		return false;
	}
}
