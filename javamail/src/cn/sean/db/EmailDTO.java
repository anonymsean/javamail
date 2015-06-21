package cn.sean.db;

import java.io.File;
import java.io.Serializable;

public class EmailDTO implements Serializable {
	//邮件编号
	private  String emailID;
	//收件人地址列表‘
	private String toList;
	//抄送地址列表
	private String ccList;
	//密送地址列表
	private String bccList;
	//发件人地址列表
	private String from;
	//邮件 主题
	private String title;
	//邮件正文
	private String content;
	//附件
	private File attFile;
	//邮件发送时间 
	private String mailDate;
	//发送者姓名
	private String personName;
	//附件路径
	private String attFilePath;
	//所属用户 ID
	private String userID;
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getToList() {
		return toList;
	}
	public void setToList(String toList) {
		this.toList = toList;
	}
	public String getCcList() {
		return ccList;
	}
	public void setCcList(String ccList) {
		this.ccList = ccList;
	}
	public String getBccList() {
		return bccList;
	}
	public void setBccList(String bccList) {
		this.bccList = bccList;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public File getAttFile() {
		return attFile;
	}
	public void setAttFile(File attFile) {
		this.attFile = attFile;
	}
	public String getMailDate() {
		return mailDate;
	}
	public void setMailDate(String mailDate) {
		this.mailDate = mailDate;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getAttFilePath() {
		return attFilePath;
	}
	public void setAttFilePath(String attFilePath) {
		this.attFilePath = attFilePath;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
