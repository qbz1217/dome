package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Business;
import com.service.BusinessService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class BusinessController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	BusinessService businessService;
@Autowired
HttpServletRequest request;
//企业用户列表管理页面
	@RequestMapping("businesslist")
	public String listBusiness(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("zijin")) && request.getParameter("zijin") !=null)
w=w+ " and zijin like '%"+request.getParameter("zijin")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

		List<Business> cs= businessService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Business business=(Business)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Business> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/business/businesslist";
	}

	@RequestMapping("businessadd")
	public String addbusiness(Model model){

	return "pages/business/businessadd";
	}
	//添加企业用户数据
	@RequestMapping("businessinsert")
	public String insertBusiness(Business business,Model model){
	String forword=request.getParameter("forword");
		businessService.insert(business);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除企业用户数据
	@RequestMapping("businessdel")
	public String deleteBusiness(Business business,Model model){
		String forword=request.getParameter("forword");
		businessService.delete(business);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的企业用户数据
	@RequestMapping("businessedit")
	public String editBusiness(Model model,Business business){
		Business c= businessService.get(business.getId());

		model.addAttribute("c", c);
		return "pages/business/businessedit";
	}

	//修改的企业用户数据
	@RequestMapping("businessupdate")
	public String updateBusiness(Business business,Model model){
		String forword=request.getParameter("forword");
		businessService.update(business);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//企业用户所有列表页
	@RequestMapping("businessAll")
	public String listBusinessAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("zijin")) && request.getParameter("zijin") !=null)
w=w+ " and zijin like '%"+request.getParameter("zijin")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";
if (!"".equals(request.getParameter("business")) && request.getParameter("business") !=null)
w=w+ " and business ="+request.getParameter("business");



		List<Business> cs= businessService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Business business=(Business)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Business> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/business/businessAll";
	}

@RequestMapping("businessview")
public String viewBusiness(Model model,Business business){
Business c= businessService.get(business.getId());
model.addAttribute("c", c);
return "pages/business/businessview";
}
//注册
@RequestMapping("businessreg")
	public String insertreg(Business business,Model model){
	String forword=request.getParameter("forword");
	String w=" and username='"+request.getParameter("username")+"'";
	List<Business> cs= businessService.list(w);
	if (cs.size()>0)
	{
		model.addAttribute("msg","用户名重复!请重试");
		model.addAttribute("path",forword);		
	}
	else{
		businessService.insert(business);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
	}
		return "success";
	
	}
//修改个人资料
	@RequestMapping("businessinfo")
	public String editBusinessinfo(Model model,Business business){
Business c= businessService.get(business.getId());

		model.addAttribute("c", c);
		return "pages/business/businessinfo";
	}

	//保存修改个人资料数据
	@RequestMapping("businessinfosave")
	public String Businessinfosave(Business business,Model model){
		String forword=request.getParameter("forword");
		businessService.update(business);
model.addAttribute("msg","修改成功");
 model.addAttribute("path",forword);
		return "success";
	}
}