package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Business;
import com.entity.Notice;
import com.entity.Position;
import com.entity.Resume;
import com.service.BusinessService;
import com.service.NoticeService;
import com.service.PositionService;
import com.service.ResumeService;
import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class indexController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	NoticeService noticeService;
	@Autowired
	PositionService positionService;
	@Autowired
	BusinessService businessService;
	@Autowired
	ResumeService resumeService;
	@Autowired
	HttpServletRequest request;
//首页
	@RequestMapping("index")
	public String indexAll(Model model){
				HttpSession session=request.getSession();
	String w="";
		List<Notice> cs= noticeService.list(w);
	if(cs.size()>5)
		{
			cs=cs.subList(0, 5);
		}
	//model.addAttribute("indexlist", cs);
	List<Resume> rcs= resumeService.list(" and zt='已审核'");
	model.addAttribute("rcs", rcs);
	List<Position> pcs= positionService.list(" and zt='已审核'");
	model.addAttribute("pcs", pcs);
	List<Business> qcs= businessService.list(" and zt='正常'");
	model.addAttribute("qcs", qcs);
		//session.setAttribute("seacs", seacs);
		// 放入转发参数
		return "pages/index";
	}


}