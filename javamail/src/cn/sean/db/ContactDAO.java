package cn.sean.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO extends DBDataAccessObject {
	/*
	 * 取得联系人列表
	 */
	public List<ContactDTO> getContactList(ContactDTO contact,Connection conn){
		List<ContactDTO> contactList=new ArrayList<ContactDTO>();
		String sql="select * from contactinfo where userid= "+contact.getUserid();
		
		ResultSet rs=null;
		try{
			rs=execSelect(sql, conn);
			while(rs.next()){
				ContactDTO c=new ContactDTO();
				c.setContactID(rs.getString("contactID"));
				c.setContactName(rs.getString("contactName"));
				c.setEmail(rs.getString("email"));
				c.setMobile(rs.getString("mobile"));
				c.setUserid(rs.getString("userid"));
				contactList.add(c);
			}
			return contactList;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(null, rs);
		}
		return null;
	}
	/*
	 * 取得指定联系人信息
	 */
	public ContactDTO getContact(int contactID,Connection conn){
		String sql="select * from contactinfo where contactID="+contactID;
		ResultSet rs=null;
		try{
			rs=execSelect(sql, conn);
			ContactDTO contact=new ContactDTO();
			while(rs.next()){			
				contact.setContactID(rs.getString("contactID"));
				contact.setContactName(rs.getString("contactName"));
				contact.setEmail(rs.getString("email"));
				contact.setMobile(rs.getString("mobile"));
				contact.setUserid(rs.getString("userid"));
			}
			return contact;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(null, rs);
		}
		return null;
	}
	/*
	 * 保存联系人信息
	 */
	public boolean saveContact(ContactDTO contact,Connection conn){
		String sql="insert into contactinfo values(?,?,?,?,?)";
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, contact.getContactID());
			pst.setString(2, contact.getContactName());
			pst.setString(3, contact.getEmail());
			if(contact.getMobile()!=null){
				pst.setString(4, contact.getMobile());
			}else{
				pst.setString(4, null);
			}		
			pst.setString(5, contact.getUserid());
			int flag=pst.executeUpdate();
			if(flag==1){return true;}else{return false;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pst, null);
		}
		return false;
	}
	/*
	 *删除指定联系人信息
	 */
	public boolean deleteContact(int contactID,Connection conn){
		String sql="delete from contactinfo where contactID=	"+contactID;
		Statement stm=null;
		try {
			stm=conn.createStatement();
			return stm.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
