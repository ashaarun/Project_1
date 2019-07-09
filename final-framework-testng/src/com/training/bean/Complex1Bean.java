package com.training.bean;

public class Complex1Bean {

	private String userName;
	private String password;
	private String productname;
	private String prodmetatag;
	private String modelnum;

	public Complex1Bean() {
	}

	public Complex1Bean(String userName, String password ,String productname, String prodmetatag,String modelnum ) {
		super();
		this.userName = userName;
		this.password = password;
		this.productname=productname;
		this.prodmetatag=prodmetatag;
		this.modelnum=modelnum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	


	public void setProductName(String productname) {
		this.productname = productname;
	}
	
	public String getProductName() {
		return productname;
	}

	public void setProdMetatag(String prodmetatag) {
		this.prodmetatag = prodmetatag;
	}
	
	public String getProdMetatag() {
		return prodmetatag;
	}

	public void setModelNum(String modelnum) {
		this.modelnum = modelnum;
	}
	
	public String getModelNum() {
		return modelnum;
	}

	@Override
	public String toString() {
		return "ComplexBean1 [userName=" + userName + ", password=" + password + "productname="+productname +"prodmetatag="+prodmetatag+"modelnum="+modelnum+"]";
	}

}
