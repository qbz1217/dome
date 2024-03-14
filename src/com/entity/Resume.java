package com.entity;

public class Resume {
		private Integer id;
	private Integer member;
	private Member memberfk;
	private String name;
	private String jiguan;
	private String shengao;
	private String tizhong;
	private String school;
	private String zleibie;
	private Zleibie zleibiefk;
	private String xueli;
	private String mianmao;
	private String zfile;
	private String yuexin;
	private String zhuanye;
	private String gangwei;
	private String techang;
	private String jingli;
	private String jieshao;
	private Integer hits;
	private String zt;
	private String uname;
	private String stime;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getMember()
	{
		return member;
	}
	public void setMember(Integer member)
	{
		this.member = member;
	}
	
	public Member getMemberfk() {
			return memberfk;
	}
	public void setMemberfk(Member memberfk) {
		this.memberfk = memberfk;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getJiguan()
	{
		return jiguan;
	}
	public void setJiguan(String jiguan)
	{
		this.jiguan = jiguan;
	}
	
	public String getShengao()
	{
		return shengao;
	}
	public void setShengao(String shengao)
	{
		this.shengao = shengao;
	}
	
	public String getTizhong()
	{
		return tizhong;
	}
	public void setTizhong(String tizhong)
	{
		this.tizhong = tizhong;
	}
	
	public String getSchool()
	{
		return school;
	}
	public void setSchool(String school)
	{
		this.school = school;
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
	public String getXueli()
	{
		return xueli;
	}
	public void setXueli(String xueli)
	{
		this.xueli = xueli;
	}
	
	public String getMianmao()
	{
		return mianmao;
	}
	public void setMianmao(String mianmao)
	{
		this.mianmao = mianmao;
	}
	
	public String getZfile()
	{
		return zfile;
	}
	public void setZfile(String zfile)
	{
		this.zfile = zfile;
	}
	
	public String getYuexin()
	{
		return yuexin;
	}
	public void setYuexin(String yuexin)
	{
		this.yuexin = yuexin;
	}
	
	public String getZhuanye()
	{
		return zhuanye;
	}
	public void setZhuanye(String zhuanye)
	{
		this.zhuanye = zhuanye;
	}
	
	public String getGangwei()
	{
		return gangwei;
	}
	public void setGangwei(String gangwei)
	{
		this.gangwei = gangwei;
	}
	
	public String getTechang()
	{
		return techang;
	}
	public void setTechang(String techang)
	{
		this.techang = techang;
	}
	
	public String getJingli()
	{
		return jingli;
	}
	public void setJingli(String jingli)
	{
		this.jingli = jingli;
	}
	
	public String getJieshao()
	{
		return jieshao;
	}
	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}
	
	public Integer getHits()
	{
		return hits;
	}
	public void setHits(Integer hits)
	{
		this.hits = hits;
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
	
	public String getStime()
	{
		return stime;
	}
	public void setStime(String stime)
	{
		this.stime = stime;
	}
	@Override

	public String toString() {

		return "Resume [id=" + id + ", member=" + member + ", name=" + name + ", jiguan=" + jiguan + ", shengao=" + shengao + ", tizhong=" + tizhong + ", school=" + school + ", zleibie=" + zleibie + ", xueli=" + xueli + ", mianmao=" + mianmao + ", zfile=" + zfile + ", yuexin=" + yuexin + ", zhuanye=" + zhuanye + ", gangwei=" + gangwei + ", techang=" + techang + ", jingli=" + jingli + ", jieshao=" + jieshao + ", hits=" + hits + ", zt=" + zt + ", uname=" + uname + ", stime=" + stime + "]";

	}
}