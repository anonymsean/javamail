package cn.sean.db;

import java.io.File;
import java.io.Serializable;

public class EmailDTO implements Serializable {
	//�ʼ����
	private  String emailID;
	//�ռ��˵�ַ�б�
	private String toList;
	//���͵�ַ�б�
	private String ccList;
	//���͵�ַ�б�
	private String bccList;
	//�����˵�ַ�б�
	private String from;
	//�ʼ� ����
	private String title;
	//�ʼ�����
	private String content;
	//����
	private File attFile;
	//�ʼ�����ʱ�� 
	private String mailDate;
	//����������
	private String personName;
	//����·��
	private String attFilePath;
	//�����û� ID
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
