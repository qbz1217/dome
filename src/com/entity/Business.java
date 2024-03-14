package com.entity;

public class Business {
		private Integer id;
	private String name;
	private String username;
	private String pwd;
	private String zijin;
	private String addr;
	private String tel;
	private String jieshao;
	private String zt;

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
	
	public String getZijin()
	{
		return zijin;
	}
	public void setZijin(String zijin)
	{
		this.zijin = zijin;
	}
	
	public String getAddr()
	{
		return addr;
	}
	public void setAddr(String addr)
	{
		this.addr = addr;
	}
	
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
	public String getJieshao()
	{
		return jieshao;
	}
	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}
	
	public String getZt()
	{
		return zt;
	}
	public void setZt(String zt)
	{
		this.zt = zt;
	}
	@Override

	public String toString() {

		return "Business [id=" + id + ", name=" + name + ", username=" + username + ", pwd=" + pwd + ", zijin=" + zijin + ", addr=" + addr + ", tel=" + tel + ", jieshao=" + jieshao + ", zt=" + zt + "]";

	}
}