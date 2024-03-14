package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Tousu;
import com.service.TousuService;
import com.entity.Business;
import com.service.BusinessService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class TousuController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	TousuService tousuService;
	@Autowired
	BusinessService businessService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("tousumy")
	public String listTousumy(Model model){
		HttpSession session=request.getSession();
	String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("business")) && request.getParameter("business") !=null)
			w=w+ " and business  = "+request.getParameter("business")+"";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Tousu> cs= tousuService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Tousu tousu=(Tousu)cs.get(i);
tousu.setBusinessfk(businessService.get(tousu.getBusiness()));
}
	List<Business> business= businessService.list("");
		// 放入转发参数
		model.addAttribute("business", business);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Tousu> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/tousu/tousumy";
	}
//投诉列表管理页面
	@RequestMapping("tousulist")
	public String listTousu(Model model){
	String w="";
	if (!"".equals(request.getParameter("business")) && request.getParameter("business") !=null)
			w=w+ " and business  = "+request.getParameter("business")+"";
	if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
 	w=w+ " and zt like '%"+request.getParameter("zt")+"%'";
		List<Tousu> cs= tousuService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Tousu tousu=(Tousu)cs.get(i);
tousu.setBusinessfk(businessService.get(tousu.getBusiness()));
}
	List<Business> business= businessService.list("");
		// 放入转发参数
		model.addAttribute("business", business);
int index=0;
				if(request.getParameter("index")==null){
					index=1;
				}
				else {
					index=Integer.parseInt(request.getParameter("index"));
				}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Tousu> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
		// 放入转发参数
		
		return "pages/tousu/tousulist";
	}

	@RequestMapping("tousuadd")
	public String addtousu(Model model){
	List<Business> business= businessService.list("");
		// 放入转发参数
		model.addAttribute("business", business);

	return "pages/tousu/tousuadd";
	}
	//添加投诉数据
	@RequestMapping("tousuinsert")
	public String insertTousu(Tousu tousu,Model model){
	String forword=request.getParameter("forword");
		tousuService.insert(tousu);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
	return "success";	}	
	//删除投诉数据
	@RequestMapping("tousudel")
	public String deleteTousu(Tousu tousu,Model model){
		String forword=request.getParameter("forword");
		tousuService.delete(tousu);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的投诉数据
	@RequestMapping("tousuedit")
	public String editTousu(Model model,Tousu tousu){
		Tousu c= tousuService.get(tousu.getId());
List<Business> business= businessService.list("");
		// 放入转发参数
		model.addAttribute("business", business);

		model.addAttribute("c", c);
		return "pages/tousu/tousuedit";
	}

	//修改的投诉数据
	@RequestMapping("tousuupdate")
	public String updateTousu(Tousu tousu,Model model){
		String forword=request.getParameter("forword");
		tousuService.update(tousu);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//投诉所有列表页
	@RequestMapping("tousuAll")
	public String listTousuAll(Model model){
String w="";

if (!"".equals(request.getParameter("business")) && request.getParameter("business") !=null)
			w=w+ " and business  = "+request.getParameter("business")+"";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Tousu> cs= tousuService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Tousu tousu=(Tousu)cs.get(i);
tousu.setBusinessfk(businessService.get(tousu.getBusiness()));
}
	List<Business> business= businessService.list("");
		// 放入转发参数
		model.addAttribute("business", business);
int index=0;
				if(request.getParameter("index")==null)
				{
					index=1;
				}
				else{
					index=Integer.parseInt(request.getParameter("index"));
				}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Tousu> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
		// 放入转发参数
		return "pages/tousu/tousuAll";
	}
}