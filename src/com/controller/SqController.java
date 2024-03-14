package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Sq;
import com.service.SqService;
import com.entity.Position;
import com.service.PositionService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class SqController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	SqService sqService;
	@Autowired
	PositionService positionService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("sqmy")
	public String listSqmy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("buname")) && request.getParameter("buname") !=null)
w=w+ " and buname like '%"+request.getParameter("buname")+"%'";

if (!"".equals(request.getParameter("position")) && request.getParameter("position") !=null)
			w=w+ " and position  = "+request.getParameter("position")+"";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Sq> cs= sqService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Sq sq=(Sq)cs.get(i);
sq.setPositionfk(positionService.get(sq.getPosition()));
}
	List<Position> position= positionService.list("");
		// 放入转发参数
		model.addAttribute("position", position);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Sq> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/sq/sqmy";
	}
//投递简历列表管理页面
	@RequestMapping("sqlist")
	public String listSq(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and buname='"+uname+"'";

if (!"".equals(request.getParameter("buname")) && request.getParameter("buname") !=null)
w=w+ " and buname like '%"+request.getParameter("buname")+"%'";

if (!"".equals(request.getParameter("position")) && request.getParameter("position") !=null)
			w=w+ " and position  = "+request.getParameter("position")+"";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Sq> cs= sqService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Sq sq=(Sq)cs.get(i);
sq.setPositionfk(positionService.get(sq.getPosition()));
}
	List<Position> position= positionService.list("");
		// 放入转发参数
		model.addAttribute("position", position);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Sq> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/sq/sqlist";
	}

	@RequestMapping("sqadd")
	public String addsq(Model model){
	List<Position> position= positionService.list("");
		// 放入转发参数
		model.addAttribute("position", position);

	return "pages/sq/sqadd";
	}
	//添加投递简历数据
	@RequestMapping("sqinsert")
	public String insertSq(Sq sq,Model model){
	String forword=request.getParameter("forword");
		sqService.insert(sq);
		model.addAttribute("msg","成功,等待回复");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除投递简历数据
	@RequestMapping("sqdel")
	public String deleteSq(Sq sq,Model model){
		String forword=request.getParameter("forword");
		sqService.delete(sq);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的投递简历数据
	@RequestMapping("sqedit")
	public String editSq(Model model,Sq sq){
		Sq c= sqService.get(sq.getId());
List<Position> position= positionService.list("");
		// 放入转发参数
		model.addAttribute("position", position);

		model.addAttribute("c", c);
		return "pages/sq/sqedit";
	}

	//修改的投递简历数据
	@RequestMapping("squpdate")
	public String updateSq(Sq sq,Model model){
		String forword=request.getParameter("forword");
		sqService.update(sq);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//投递简历所有列表页
	@RequestMapping("sqAll")
	public String listSqAll(Model model){
String w="";

if (!"".equals(request.getParameter("buname")) && request.getParameter("buname") !=null)
w=w+ " and buname like '%"+request.getParameter("buname")+"%'";

if (!"".equals(request.getParameter("position")) && request.getParameter("position") !=null)
			w=w+ " and position  = "+request.getParameter("position")+"";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Sq> cs= sqService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Sq sq=(Sq)cs.get(i);
sq.setPositionfk(positionService.get(sq.getPosition()));
}
	List<Position> position= positionService.list("");
		// 放入转发参数
		model.addAttribute("position", position);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Sq> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/sq/sqAll";
	}
}