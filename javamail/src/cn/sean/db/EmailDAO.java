package cn.sean.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmailDAO extends DBDataAccessObject {
	/*
	 * 保存邮件信息
	 */
	public boolean saveEmail(EmailDTO email, Connection conn) {
		String sql = "insert into  EmailInfo values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email.getMailDate());
			pst.setString(2, email.getFrom());
			pst.setString(3, email.getTitle());
			pst.setString(4, email.getContent());
			if (email.getAttFilePath() != null) {
				pst.setString(5, email.getAttFilePath());
			} else {
				pst.setString(5, null);
			}
			pst.setString(6, email.getUserID());
			int flag = pst.executeUpdate();
			if (flag == 1) {
				return true;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pst, null);
		}
		return false;
	}

	/*
	 * 取得用户邮件列表
	 */
	public List<EmailDTO> getMailList(EmailDTO email, Connection conn) {
		List<EmailDTO> mailList = new ArrayList<EmailDTO>();
		String sql = "Select edate,econtent,emailid,efrom,theme,attPath from emailinfo where userid= "
				+ email.getUserID() + " order by emailid desc";
		ResultSet rs = null;
		try {
			rs = execSelect(sql, conn);
			while (rs.next()) {
				EmailDTO mail = new EmailDTO();
				mail.setMailDate(rs.getString("edate"));
				mail.setContent(rs.getString("econtent"));
				mail.setEmailID(rs.getString("emailid"));
				mail.setFrom(rs.getString("efrom"));
				mail.setTitle(rs.getString("theme"));
				mail.setAttFilePath(rs.getString("attPath"));
				mailList.add(mail);
			}
			return mailList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, rs);
		}
		return null;
	}

	/*
	 * 取得指定邮件 编号的邮件 信息
	 */
	public EmailDTO getEmail(int emailID, Connection conn) {
		String sql="select * from emailinfo where emailid="+ emailID;
		ResultSet rs=null;
		EmailDTO mail=new EmailDTO();
		try{
			rs=execSelect(sql, conn);
			if(rs.next()){
				mail.setMailDate(rs.getString("edate"));
				mail.setContent(rs.getString("econtent"));
				mail.setEmailID(rs.getString("emailid"));
				mail.setFrom(rs.getString("efrom"));
				mail.setTitle(rs.getString("theme"));
				mail.setAttFilePath(rs.getString("attPath"));
			}
			return mail;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(null, rs);
		}
		return null;
	}

	/*
	 * 彻底删除指定编号的邮件
	 */
	public boolean deleteEmail(int emailID, Connection conn) {
		String sql="delete from emailinfo where emailid="+emailID;
		int flag=1;
		try{
			flag=execUpdate(sql, conn);
			if(flag==1){
				return true;
			}else
				return false;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
