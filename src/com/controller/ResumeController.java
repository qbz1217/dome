package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Resume;
import com.service.ResumeService;
import com.entity.Member;
import com.entity.Zleibie;
import com.service.MemberService;
import com.service.ZleibieService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class ResumeController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	ResumeService resumeService;
	@Autowired
	MemberService memberService;
	@Autowired
	ZleibieService zleibieService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("resumemy")
	public String listResumemy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("jiguan")) && request.getParameter("jiguan") !=null)
w=w+ " and jiguan like '%"+request.getParameter("jiguan")+"%'";

if (!"".equals(request.getParameter("shengao")) && request.getParameter("shengao") !=null)
w=w+ " and shengao like '%"+request.getParameter("shengao")+"%'";

if (!"".equals(request.getParameter("tizhong")) && request.getParameter("tizhong") !=null)
w=w+ " and tizhong like '%"+request.getParameter("tizhong")+"%'";

if (!"".equals(request.getParameter("school")) && request.getParameter("school") !=null)
w=w+ " and school like '%"+request.getParameter("school")+"%'";

if (!"".equals(request.getParameter("zleibie")) && request.getParameter("zleibie") !=null)
			w=w+ " and zleibie  = '"+request.getParameter("zleibie")+"'";

if (!"".equals(request.getParameter("xueli")) && request.getParameter("xueli") !=null)
w=w+ " and xueli like '%"+request.getParameter("xueli")+"%'";

if (!"".equals(request.getParameter("mianmao")) && request.getParameter("mianmao") !=null)
w=w+ " and mianmao like '%"+request.getParameter("mianmao")+"%'";

if (!"".equals(request.getParameter("yuexin")) && request.getParameter("yuexin") !=null)
w=w+ " and yuexin like '%"+request.getParameter("yuexin")+"%'";

if (!"".equals(request.getParameter("zhuanye")) && request.getParameter("zhuanye") !=null)
w=w+ " and zhuanye like '%"+request.getParameter("zhuanye")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Resume> cs= resumeService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Resume resume=(Resume)cs.get(i);
resume.setMemberfk(memberService.get(resume.getMember()));
}
	List<Member> member= memberService.list("");
		// 放入转发参数
		model.addAttribute("member", member);
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
		         List<Resume> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/resume/resumemy";
	}
//简历列表管理页面
	@RequestMapping("resumelist")
	public String listResume(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("jiguan")) && request.getParameter("jiguan") !=null)
w=w+ " and jiguan like '%"+request.getParameter("jiguan")+"%'";

if (!"".equals(request.getParameter("shengao")) && request.getParameter("shengao") !=null)
w=w+ " and shengao like '%"+request.getParameter("shengao")+"%'";

if (!"".equals(request.getParameter("tizhong")) && request.getParameter("tizhong") !=null)
w=w+ " and tizhong like '%"+request.getParameter("tizhong")+"%'";

if (!"".equals(request.getParameter("school")) && request.getParameter("school") !=null)
w=w+ " and school like '%"+request.getParameter("school")+"%'";

if (!"".equals(request.getParameter("zleibie")) && request.getParameter("zleibie") !=null)
			w=w+ " and zleibie  = '"+request.getParameter("zleibie")+"'";

if (!"".equals(request.getParameter("xueli")) && request.getParameter("xueli") !=null)
w=w+ " and xueli like '%"+request.getParameter("xueli")+"%'";

if (!"".equals(request.getParameter("mianmao")) && request.getParameter("mianmao") !=null)
w=w+ " and mianmao like '%"+request.getParameter("mianmao")+"%'";

if (!"".equals(request.getParameter("yuexin")) && request.getParameter("yuexin") !=null)
w=w+ " and yuexin like '%"+request.getParameter("yuexin")+"%'";

if (!"".equals(request.getParameter("zhuanye")) && request.getParameter("zhuanye") !=null)
w=w+ " and zhuanye like '%"+request.getParameter("zhuanye")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Resume> cs= resumeService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Resume resume=(Resume)cs.get(i);
resume.setMemberfk(memberService.get(resume.getMember()));
}
	List<Member> member= memberService.list("");
		// 放入转发参数
		model.addAttribute("member", member);
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
		         List<Resume> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/resume/resumelist";
	}

	@RequestMapping("resumeadd")
	public String addresume(Model model){
	List<Member> member= memberService.list("");
		// 放入转发参数
		model.addAttribute("member", member);
	List<Zleibie> zleibie= zleibieService.list("");
		// 放入转发参数
		model.addAttribute("zleibie", zleibie);

	return "pages/resume/resumeadd";
	}
	//添加简历数据
	@RequestMapping("resumeinsert")
	public String insertResume(Resume resume,Model model){
	String forword=request.getParameter("forword");
		resumeService.insert(resume);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除简历数据
	@RequestMapping("resumedel")
	public String deleteResume(Resume resume,Model model){
		String forword=request.getParameter("forword");
		resumeService.delete(resume);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的简历数据
	@RequestMapping("resumeedit")
	public String editResume(Model model,Resume resume){
		Resume c= resumeService.get(resume.getId());
List<Member> member= memberService.list("");
		// 放入转发参数
		model.addAttribute("member", member);
List<Zleibie> zleibie= zleibieService.list("");
		// 放入转发参数
		model.addAttribute("zleibie", zleibie);

		model.addAttribute("c", c);
		return "pages/resume/resumeedit";
	}

	//修改的简历数据
	@RequestMapping("resumeupdate")
	public String updateResume(Resume resume,Model model){
		String forword=request.getParameter("forword");
		resumeService.update(resume);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//简历所有列表页
	@RequestMapping("resumeAll")
	public String listResumeAll(Model model){
		String w=" and zt='已审核'";


if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("jiguan")) && request.getParameter("jiguan") !=null)
w=w+ " and jiguan like '%"+request.getParameter("jiguan")+"%'";

if (!"".equals(request.getParameter("shengao")) && request.getParameter("shengao") !=null)
w=w+ " and shengao like '%"+request.getParameter("shengao")+"%'";

if (!"".equals(request.getParameter("tizhong")) && request.getParameter("tizhong") !=null)
w=w+ " and tizhong like '%"+request.getParameter("tizhong")+"%'";

if (!"".equals(request.getParameter("school")) && request.getParameter("school") !=null)
w=w+ " and school like '%"+request.getParameter("school")+"%'";

if (!"".equals(request.getParameter("zleibie")) && request.getParameter("zleibie") !=null)
			w=w+ " and zleibie  = '"+request.getParameter("zleibie")+"'";

if (!"".equals(request.getParameter("xueli")) && request.getParameter("xueli") !=null)
w=w+ " and xueli like '%"+request.getParameter("xueli")+"%'";

if (!"".equals(request.getParameter("mianmao")) && request.getParameter("mianmao") !=null)
w=w+ " and mianmao like '%"+request.getParameter("mianmao")+"%'";

if (!"".equals(request.getParameter("yuexin")) && request.getParameter("yuexin") !=null)
w=w+ " and yuexin like '%"+request.getParameter("yuexin")+"%'";

if (!"".equals(request.getParameter("zhuanye")) && request.getParameter("zhuanye") !=null)
w=w+ " and zhuanye like '%"+request.getParameter("zhuanye")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Resume> cs= resumeService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Resume resume=(Resume)cs.get(i);
resume.setMemberfk(memberService.get(resume.getMember()));
}
	List<Member> member= memberService.list("");
		// 放入转发参数
		model.addAttribute("member", member);
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
		         List<Resume> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/resume/resumeAll";
	}

@RequestMapping("resumeview")
public String viewResume(Model model,Resume resume){
Resume c= resumeService.get(resume.getId());
String str="update resume set hits=hits+1 where id="+resume.getId();
resumeService.updatesql(str);
c.setMemberfk(memberService.get(c.getMember()));
model.addAttribute("c", c);
List<Member> member= memberService.list(" and id="+c.getMember());

model.addAttribute("member", member);

return "pages/resume/resumeview";
}
}