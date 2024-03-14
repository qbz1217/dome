package com.entity;

public class Sq {
		private Integer id;
	private String buname;
	private String uname;
	private Integer position;
	private Position positionfk;
	private String zfile;
	private String shuoming;
	private String yijian;
	private String zt;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getBuname()
	{
		return buname;
	}
	public void setBuname(String buname)
	{
		this.buname = buname;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	
	public Integer getPosition()
	{
		return position;
	}
	public void setPosition(Integer position)
	{
		this.position = position;
	}
	
	public Position getPositionfk() {
			return positionfk;
	}
	public void setPositionfk(Position positionfk) {
		this.positionfk = positionfk;
	}
	public String getZfile()
	{
		return zfile;
	}
	public void setZfile(String zfile)
	{
		this.zfile = zfile;
	}
	
	public String getShuoming()
	{
		return shuoming;
	}
	public void setShuoming(String shuoming)
	{
		this.shuoming = shuoming;
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
	@Override

	public String toString() {

		return "Sq [id=" + id + ", buname=" + buname + ", uname=" + uname + ", position=" + position + ", zfile=" + zfile + ", shuoming=" + shuoming + ", yijian=" + yijian + ", zt=" + zt + "]";

	}
}