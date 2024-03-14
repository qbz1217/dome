package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Position;
import com.service.PositionService;
import com.entity.Business;
import com.entity.Zleibie;
import com.service.BusinessService;
import com.service.ZleibieService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class PositionController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	PositionService positionService;
	@Autowired
	BusinessService businessService;
	@Autowired
	ZleibieService zleibieService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("positionmy")
	public String listPositionmy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("business")) && request.getParameter("business") !=null)
			w=w+ " and business  = "+request.getParameter("business")+"";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("zleibie")) && request.getParameter("zleibie") !=null)
			w=w+ " and zleibie  = '"+request.getParameter("zleibie")+"'";

if (!"".equals(request.getParameter("didian")) && request.getParameter("didian") !=null)
w=w+ " and didian like '%"+request.getParameter("didian")+"%'";

if (!"".equals(request.getParameter("renshu")) && request.getParameter("renshu") !=null)
w=w+ " and renshu like '%"+request.getParameter("renshu")+"%'";

if (!"".equals(request.getParameter("xyaoqiu")) && request.getParameter("xyaoqiu") !=null)
w=w+ " and xyaoqiu like '%"+request.getParameter("xyaoqiu")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Position> cs= positionService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Position position=(Position)cs.get(i);
position.setBusinessfk(businessService.get(position.getBusiness()));
}
	List<Business> business= businessService.list("");
		// 放入转发参数
		model.addAttribute("business", business);
	List<Zleibie> zleibie= zleibieService.list("");
		// 放入转发参数
		model.addAttribute("zleibie", zleibie);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Position> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/position/positionmy";
	}

//招聘职位列表管理页面
	@RequestMapping("positionlist")
	public String listPosition(Model model){
String w="";

if (!"".equals(request.getParameter("business")) && request.getParameter("business") !=null)
			w=w+ " and business  = "+request.getParameter("business")+"";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("zleibie")) && request.getParameter("zleibie") !=null)
			w=w+ " and zleibie  = '"+request.getParameter("zleibie")+"'";

if (!"".equals(request.getParameter("didian")) && request.getParameter("didian") !=null)
w=w+ " and didian like '%"+request.getParameter("didian")+"%'";

if (!"".equals(request.getParameter("renshu")) && request.getParameter("renshu") !=null)
w=w+ " and renshu like '%"+request.getParameter("renshu")+"%'";

if (!"".equals(request.getParameter("xyaoqiu")) && request.getParameter("xyaoqiu") !=null)
w=w+ " and xyaoqiu like '%"+request.getParameter("xyaoqiu")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Position> cs= positionService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Position position=(Position)cs.get(i);
position.setBusinessfk(businessService.get(position.getBusiness()));
}
	List<Business> business= businessService.list("");
		// 放入转发参数
		model.addAttribute("business", business);
	List<Zleibie> zleibie= zleibieService.list("");
		// 放入转发参数
		model.addAttribute("zleibie", zleibie);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Position> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/position/positionlist";
	}

	@RequestMapping("positionadd")
	public String addposition(Model model){
	List<Business> business= businessService.list("");
		// 放入转发参数
		model.addAttribute("business", business);
	List<Zleibie> zleibie= zleibieService.list("");
		// 放入转发参数
		model.addAttribute("zleibie", zleibie);

	return "pages/position/positionadd";
	}
	//添加招聘职位数据
	@RequestMapping("positioninsert")
	public String insertPosition(Position position,Model model){
	String forword=request.getParameter("forword");
		positionService.insert(position);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除招聘职位数据
	@RequestMapping("positiondel")
	public String deletePosition(Position position,Model model){
		String forword=request.getParameter("forword");
		positionService.delete(position);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的招聘职位数据
	@RequestMapping("positionedit")
	public String editPosition(Model model,Position position){
		Position c= positionService.get(position.getId());
List<Business> business= businessService.list("");
		// 放入转发参数
		model.addAttribute("business", business);
List<Zleibie> zleibie= zleibieService.list("");
		// 放入转发参数
		model.addAttribute("zleibie", zleibie);

		model.addAttribute("c", c);
		return "pages/position/positionedit";
	}

	//修改的招聘职位数据
	@RequestMapping("positionupdate")
	public String updatePosition(Position position,Model model){
		String forword=request.getParameter("forword");
		positionService.update(position);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//招聘职位所有列表页
	@RequestMapping("positionAll")
	public String listPositionAll(Model model){
String w=" and zt='已审核'";

if (!"".equals(request.getParameter("business")) && request.getParameter("business") !=null)
			w=w+ " and business  = "+request.getParameter("business")+"";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("zleibie")) && request.getParameter("zleibie") !=null)
			w=w+ " and zleibie  = '"+request.getParameter("zleibie")+"'";

if (!"".equals(request.getParameter("didian")) && request.getParameter("didian") !=null)
w=w+ " and didian like '%"+request.getParameter("didian")+"%'";

if (!"".equals(request.getParameter("renshu")) && request.getParameter("renshu") !=null)
w=w+ " and renshu like '%"+request.getParameter("renshu")+"%'";

if (!"".equals(request.getParameter("xyaoqiu")) && request.getParameter("xyaoqiu") !=null)
w=w+ " and xyaoqiu like '%"+request.getParameter("xyaoqiu")+"%'";



		List<Position> cs= positionService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Position position=(Position)cs.get(i);
position.setBusinessfk(businessService.get(position.getBusiness()));
}
	List<Business> business= businessService.list("");
		// 放入转发参数
		model.addAttribute("business", business);
	List<Zleibie> zleibie= zleibieService.list("");
		// 放入转发参数
		model.addAttribute("zleibie", zleibie);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Position> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/position/positionAll";
	}

@RequestMapping("positionview")
public String viewPosition(Model model,Position position){
Position c= positionService.get(position.getId());
String str="update position set hits=hits+1 where id="+position.getId();
positionService.updatesql(str);c.setBusinessfk(businessService.get(c.getBusiness()));
model.addAttribute("c", c);
return "pages/position/positionview";
}
}