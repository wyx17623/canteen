package com.gxuwz.bean.entity;
/**
 * 
 * @author 
 * ʱ�䣺2019��6��14������10:55:20
 * Description:ʳ�û��ʵ����
 */
public class sys_accountant {
private String accountantID;
private String accountantName;
private String accountantTel;
public sys_accountant() {
	super();
}
public sys_accountant(String accountantID, String accountantName,
		String accountantTel) {
	super();
	this.accountantID = accountantID;
	this.accountantName = accountantName;
	this.accountantTel = accountantTel;
}
public String getAccountantID() {
	return accountantID;
}
public void setAccountantID(String accountantID) {
	this.accountantID = accountantID;
}
public String getAccountantName() {
	return accountantName;
}
public void setAccountantName(String accountantName) {
	this.accountantName = accountantName;
}
public String getAccountantTel() {
	return accountantTel;
}
public void setAccountantTel(String accountantTel) {
	this.accountantTel = accountantTel;
}

}
