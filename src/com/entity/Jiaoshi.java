package com.entity;

public class Jiaoshi {
		private Integer id;
	private String name;
	private String sex;
	private String xueyuan;
	private String tel;
	private String email;
	private String username;
	private String pwd;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public String getXueyuan()
	{
		return xueyuan;
	}
	public void setXueyuan(String xueyuan)
	{
		this.xueyuan = xueyuan;
	}
	
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	@Override

	public String toString() {

		return "Jiaoshi [id=" + id + ", name=" + name + ", sex=" + sex + ", xueyuan=" + xueyuan + ", tel=" + tel + ", email=" + email + ", username=" + username + ", pwd=" + pwd + "]";

	}
}