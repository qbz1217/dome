package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Member;
import com.service.MemberService;
import com.service.PositionService;
import com.service.ResumeService;
import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class MemberController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	MemberService memberService;
	@Autowired
	ResumeService resumeService;
	@Autowired
	PositionService positionService;
@Autowired
HttpServletRequest request;
//学生列表管理页面
	@RequestMapping("memberlist")
	public String listMember(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

if (!"".equals(request.getParameter("email")) && request.getParameter("email") !=null)
w=w+ " and email like '%"+request.getParameter("email")+"%'";

		List<Member> cs= memberService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Member member=(Member)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Member> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		

		
		return "pages/member/memberlist";
	}
	@RequestMapping("membertongji")
	public String listMembertongji(Model model){
String w="";
int cs1=memberService.total(" where sex='男'");
int cs2=memberService.total(" where sex='女'");
int x1=resumeService.total(" where xueli='专科' and zt='已审核'");
int x2=resumeService.total(" where xueli='本科' and zt='已审核'");
int x3=resumeService.total(" where xueli='研究生' and zt='已审核'");
int x4=resumeService.total(" where xueli='博士' and zt='已审核'");
int q1=positionService.total(" where zleibie='全职' and zt='已审核'");
int q2=positionService.total(" where zleibie='兼职' and zt='已审核'");
		int y1=positionService.total(" where xyaoqiu='专科' and zt='已审核'");
		int y2=positionService.total(" where xyaoqiu='本科' and zt='已审核'");
		int y3=positionService.total(" where xyaoqiu='研究生' and zt='已审核'");
		int y4=positionService.total(" where xyaoqiu='博士' and zt='已审核'");
		model.addAttribute("str1", cs1);	
		model.addAttribute("str2", cs2);	
		model.addAttribute("x1", x1);
		model.addAttribute("x2", x2);
		model.addAttribute("x3", x3);
		model.addAttribute("x4", x4);
		model.addAttribute("q1", q1);
		model.addAttribute("q2", q2);
		model.addAttribute("y1", y1);
		model.addAttribute("y2", y2);
		model.addAttribute("y3", y3);
		model.addAttribute("y4", y4);
		// 放入转发参数
		
		return "pages/member/membertongji";
	}

	@RequestMapping("memberadd")
	public String addmember(Model model){

	return "pages/member/memberadd";
	}
	//添加学生数据
	@RequestMapping("memberinsert")
	public String insertMember(Member member,Model model){
	String forword=request.getParameter("forword");
		memberService.insert(member);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除学生数据
	@RequestMapping("memberdel")
	public String deleteMember(Member member,Model model){
		String forword=request.getParameter("forword");
		memberService.delete(member);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的学生数据
	@RequestMapping("memberedit")
	public String editMember(Model model,Member member){
		Member c= memberService.get(member.getId());

		model.addAttribute("c", c);
		return "pages/member/memberedit";
	}

	//修改的学生数据
	@RequestMapping("memberupdate")
	public String updateMember(Member member,Model model){
		String forword=request.getParameter("forword");
		memberService.update(member);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//学生所有列表页
	@RequestMapping("memberAll")
	public String listMemberAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

if (!"".equals(request.getParameter("email")) && request.getParameter("email") !=null)
w=w+ " and email like '%"+request.getParameter("email")+"%'";

		List<Member> cs= memberService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Member member=(Member)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Member> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/member/memberAll";
	}
//注册
@RequestMapping("memberreg")
	public String insertreg(Member member,Model model){
	String forword=request.getParameter("forword");
	String w=" and username='"+request.getParameter("username")+"'";
	List<Member> cs= memberService.list(w);
	if (cs.size()>0)
	{
		model.addAttribute("msg","用户名重复!请重试");
		model.addAttribute("path",forword);		
	}
	else{
		memberService.insert(member);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
	}
		return "success";
	
	}
//修改个人资料
	@RequestMapping("memberinfo")
	public String editMemberinfo(Model model,Member member){
Member c= memberService.get(member.getId());

		model.addAttribute("c", c);
		return "pages/member/memberinfo";
	}

	//保存修改个人资料数据
	@RequestMapping("memberinfosave")
	public String Memberinfosave(Member member,Model model){
		String forword=request.getParameter("forword");
		memberService.update(member);
model.addAttribute("msg","修改成功");
 model.addAttribute("path",forword);
		return "success";
	}
}