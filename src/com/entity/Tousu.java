package com.entity;

public class Tousu {
		private Integer id;
	private Integer business;
	private Business businessfk;
	private String title;
	private String stime;
	private String yijian;
	private String zt;
	private String uname;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getBusiness()
	{
		return business;
	}
	public void setBusiness(Integer business)
	{
		this.business = business;
	}
	
	public Business getBusinessfk() {
			return businessfk;
	}
	public void setBusinessfk(Business businessfk) {
		this.businessfk = businessfk;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getStime()
	{
		return stime;
	}
	public void setStime(String stime)
	{
		this.stime = stime;
	}
	
	public String getYijian()
	{
		return yijian;
	}
	public void setYijian(String yijian)
	{
		this.yijian = yijian;
	}
	
	public String getZt()
	{
		return zt;
	}
	public void setZt(String zt)
	{
		this.zt = zt;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	@Override

	public String toString() {

		return "Tousu [id=" + id + ", business=" + business + ", title=" + title + ", stime=" + stime + ", yijian=" + yijian + ", zt=" + zt + ", uname=" + uname + "]";

	}
}