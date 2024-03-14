package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.entity.Admin;
import com.entity.Business;
import com.entity.Jiaoshi;
import com.entity.Member;
import com.util.Result;

//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class loginController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	com.service.AdminService adminService;
	@Autowired
	com.service.BusinessService businessService;
	@Autowired
	com.service.MemberService memberService;
	@Autowired
	com.service.JiaoshiService jiaoshiService;
@Autowired
HttpServletRequest request;

	@RequestMapping("check")
	@ResponseBody
	public Result   login(String username,String pwd,String userType) { Result rs=null;
		String w="";
	   //System.out.println("userType"+userType);
	Map<String,Object> data=new HashMap<String, Object>();
		if(userType.equals("0"))
		{System.out.println(username);
	        if (!"".equals(username) && username!=null) 
			{
	        	w= " and adminname ='"+username+"'";
			
	        List<Admin> cs1= adminService.sealist(w);
			if(cs1.size()<=0)
			{
				rs=new Result("0", "账号不存在", data);
				System.out.println(rs.toString());
				 return rs;
			}
			}
	       if (!"".equals(pwd) && pwd!=null) 
			{System.out.println(w+"-----------2");
			   w=w+ " and pwd ='"+pwd+"'";
				List<Admin> cs2= adminService.sealist(w);

			   if(cs2.size()<=0)
				{
					rs=new Result("0", "密码不匹配", data);
					System.out.println(rs.toString());
					 return rs;
				}
			}
	        
	      
			List<Admin> cs= adminService.sealist(w);
			if(cs.size()>0)
			{ 		
			 HttpSession session=request.getSession(); 
				 session.setAttribute("userType", userType);
				Admin s=(Admin)cs.get(0);
	             session.setAttribute("admin", s);
				 session.setAttribute("loginname", username);

						rs=new Result("1", "登陆成功", data);//将json数据返回
						
				System.out.println(rs.toString());
				 return rs;
			}

			
		}
		 if(userType.equals("1"))//企业用户
			{
				 if (!"".equals(username) && username!=null) 
				 {
						w=w+ " and username ='"+username+"'";
						   List<Business> cs1= businessService.sealist(w);
						   if(cs1.size()<=0)
							{
								rs=new Result("0", "账号不存在", data);
								System.out.println(rs.toString());
								 return rs;
							}
				 }
				 if (!"".equals(pwd) && pwd!=null) 
					   {
						w=w+ " and pwd ='"+pwd+"'";
						   List<Business> cs2= businessService.sealist(w);

							if(cs2.size()<=0)
							{
								rs=new Result("0", "密码不匹配", data);
								System.out.println(rs.toString());
								 return rs;
							}
					   }
					   w+=" and zt='正常'";
					   List<Business> cs= businessService.sealist(w);
						if(cs.size()>0)
						{ 		
						 HttpSession session=request.getSession(); 
							 session.setAttribute("userType", userType);
							 Business s=(Business)cs.get(0);
				             session.setAttribute("business", s);
							 session.setAttribute("loginid", s.getId());
							 session.setAttribute("loginname", username);
							rs=new Result("1", "登陆成功", data);//将信息返回给ajax
							System.out.println(rs.toString());
							 return rs;
						}
						/*else
						{
						rs=new Result("0", "登陆失败,账号已封禁", data);
						System.out.println(rs.toString());

						}*/
			}
if(userType.equals("2"))//学生
			{
				 if (!"".equals(username) && username!=null) 
				 {
						w=w+ " and username ='"+username+"'";
				   List<Member> cs1= memberService.sealist(w);

				    if(cs1.size()<=0)
					{
						rs=new Result("0", "账号不存在", data);
						System.out.println(rs.toString());
						 return rs;
					}
				 }
				if (!"".equals(pwd) && pwd!=null) 
					{
						w=w+ " and pwd ='"+pwd+"'";
					   List<Member> cs2= memberService.sealist(w);

						if(cs2.size()<=0)
						{
							rs=new Result("0", "密码不匹配", data);
							System.out.println(rs.toString());
							 return rs;
						}
					}
					  // w=w+" and zt='正常'";
					   List<Member> cs= memberService.sealist(w);
					   if(cs.size()>0)
						{ 		
						 HttpSession session=request.getSession(); 
							 session.setAttribute("userType", userType);
							 Member s=(Member)cs.get(0);
				             session.setAttribute("member", s);
							 session.setAttribute("loginid", s.getId());
							 session.setAttribute("loginname", username);
							rs=new Result("1", "登陆成功", data);//将信息返回给ajax
							System.out.println(rs.toString());
							 return rs;
						}
						/*else
						{
						rs=new Result("0", "登陆失败", data);
						System.out.println(rs.toString());

						}*/
			}
if(userType.equals("3"))//教师
{
	 if (!"".equals(username) && username!=null) 
			w=w+ " and username ='"+username+"'";
		   if (!"".equals(pwd) && pwd!=null) 
			w=w+ " and pwd ='"+pwd+"'";
		   
		   List<Jiaoshi> cs= jiaoshiService.sealist(w);
			if(cs.size()>0)
			{ 		
			HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
				 Jiaoshi s=(Jiaoshi)cs.get(0);
	            session.setAttribute("jiaoshi", s);
				session.setAttribute("loginid", s.getId());
				session.setAttribute("loginname", username);
		session.setAttribute("userType", userType);

				rs=new Result("1", "登陆成功", data);//将信息返回给ajax
				System.out.println(rs.toString());
		
			}
			else
			{
			rs=new Result("0", "登陆失败", data);
			System.out.println(rs.toString());

			}
}
return rs;
	}

	@RequestMapping("userLogout")
    public String userLogout(Model model)
    {		String forword=request.getParameter("forword");

		 HttpSession session=request.getSession(); 

		session.setAttribute("userType", null);
		session.setAttribute("user", null);
		session.setAttribute("business", null);
		session.setAttribute("loginid", null);

		session.setAttribute("loginname", null);
		model.addAttribute("msg","退出成功");
		 model.addAttribute("path",forword);
				return "success";
    }
}