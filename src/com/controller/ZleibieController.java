package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Zleibie;
import com.service.ZleibieService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class ZleibieController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	ZleibieService zleibieService;
@Autowired
HttpServletRequest request;
//职位类别列表管理页面
	@RequestMapping("zleibielist")
	public String listZleibie(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Zleibie> cs= zleibieService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Zleibie zleibie=(Zleibie)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{
					index=1;
				}
				else
				{
					index=Integer.parseInt(request.getParameter("index"));
				}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Zleibie> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/zleibie/zleibielist";
	}

	@RequestMapping("zleibieadd")
	public String addzleibie(Model model){

	return "pages/zleibie/zleibieadd";
	}
	//添加职位类别数据
	@RequestMapping("zleibieinsert")
	public String insertZleibie(Zleibie zleibie,Model model){
	String forword=request.getParameter("forword");
		zleibieService.insert(zleibie);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除职位类别数据
	@RequestMapping("zleibiedel")
	public String deleteZleibie(Zleibie zleibie,Model model){
		String forword=request.getParameter("forword");
		zleibieService.delete(zleibie);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的职位类别数据
	@RequestMapping("zleibieedit")
	public String editZleibie(Model model,Zleibie zleibie){
		Zleibie c= zleibieService.get(zleibie.getId());

		model.addAttribute("c", c);
		return "pages/zleibie/zleibieedit";
	}

	//修改的职位类别数据
	@RequestMapping("zleibieupdate")
	public String updateZleibie(Zleibie zleibie,Model model){
		String forword=request.getParameter("forword");
		zleibieService.update(zleibie);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//职位类别所有列表页
	@RequestMapping("zleibieAll")
	public String listZleibieAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Zleibie> cs= zleibieService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Zleibie zleibie=(Zleibie)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Zleibie> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/zleibie/zleibieAll";
	}
}