package com.entity;

public class Position {
		private Integer id;
	private Integer business;
	private Business businessfk;
	private String name;
	private String zleibie;
	private Zleibie zleibiefk;
	private String didian;
	private Integer renshu;
	private String xyaoqiu;
	private String price;
	private Integer hits;
	private String stime;
	private String details;
	private String uname;
	private String zt;

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
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getZleibie()
	{
		return zleibie;
	}
	public void setZleibie(String zleibie)
	{
		this.zleibie = zleibie;
	}
	
	public Zleibie getZleibiefk() {
			return zleibiefk;
	}
	public void setZleibiefk(Zleibie zleibiefk) {
		this.zleibiefk = zleibiefk;
	}
	public String getDidian()
	{
		return didian;
	}
	public void setDidian(String didian)
	{
		this.didian = didian;
	}
	
	public Integer getRenshu()
	{
		return renshu;
	}
	public void setRenshu(Integer renshu)
	{
		this.renshu = renshu;
	}
	
	public String getXyaoqiu()
	{
		return xyaoqiu;
	}
	public void setXyaoqiu(String xyaoqiu)
	{
		this.xyaoqiu = xyaoqiu;
	}
	
	public String getPrice()
	{
		return price;
	}
	public void setPrice(String price)
	{
		this.price = price;
	}
	
	public Integer getHits()
	{
		return hits;
	}
	public void setHits(Integer hits)
	{
		this.hits = hits;
	}
	
	public String getStime()
	{
		return stime;
	}
	public void setStime(String stime)
	{
		this.stime = stime;
	}
	
	public String getDetails()
	{
		return details;
	}
	public void setDetails(String details)
	{
		this.details = details;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
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

		return "Position [id=" + id + ", business=" + business + ", name=" + name + ", zleibie=" + zleibie + ", didian=" + didian + ", renshu=" + renshu + ", xyaoqiu=" + xyaoqiu + ", price=" + price + ", hits=" + hits + ", stime=" + stime + ", details=" + details + ", uname=" + uname + ", zt=" + zt + "]";

	}
}