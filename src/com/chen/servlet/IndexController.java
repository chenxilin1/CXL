package com.chen.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.service.AdminService;
import com.chen.service.StudentService;
import com.chen.bean.*;
@Controller
public class IndexController {
	
//登录
	@RequestMapping("/login")
	public void  login(HttpServletRequest request,HttpSession session,HttpServletResponse resp ) throws IOException{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		StudentService stu=context.getBean("stServiceImpl",StudentService.class);
		String name=request.getParameter("userName");
		String pw=request.getParameter("userPw");
		String usertypee=request.getParameter("userType");
		int userType=Integer.parseInt(usertypee);
		if(userType==0)
		{
			 
			  Admin a= new Admin();
			  a.setUserName(name);
		      a.setUserPw(pw);
			  Admin ad=us.login(a);
			  if(ad!=null)
			  {
				  session.setAttribute("userType",userType);
				  session.setAttribute("user", a);
				  resp.sendRedirect("loginSuccess.jsp");
			  }else
			  {
				  resp.sendRedirect("login_.jsp");
			  }
		} else if(userType==2){
			Student st=new Student();
			st.setLoginname(name);
			st.setLoginpw(pw);
		    Student s=stu.logins(st);
		    if(s!=null)
		    {
			session.setAttribute("userType", userType);
			session.setAttribute("xuesheng", s);
			resp.sendRedirect("loginSuccess.jsp");
		    }else
			  {
				  resp.sendRedirect("login_.jsp");
			  }
		}else if(userType==1){
			LaoShi l=new LaoShi();
			l.setLoginname(name);
			l.setLoginpw(pw);
			LaoShi ll=new LaoShi();
			ll=us.loginls(l);
			if(ll!=null){
				session.setAttribute("userType", userType);
				session.setAttribute("laoshi", ll);
				resp.sendRedirect("loginSuccess.jsp");
		    }else
			  {
				  resp.sendRedirect("login_.jsp");
			  }
			}
		}
		
		

//管理员更改密码
	@RequestMapping("/adminPwEdit" )
	public String adminPwEdit(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		Admin name1= (Admin) session.getAttribute("user");
		String userPw1=request.getParameter("userPw1");
		name1.setUserPw(userPw1);
		int i=us.adminPwEdit(name1);
	    return "userinfo/userPw";
	}
	}

//管理员遍历
	@RequestMapping("/adminMana" )
	public String adminMana(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		List<Admin> a=new ArrayList<Admin>();
		a=us.All();
		session.setAttribute("adminList", a);
		return "admin/adminMana";
	}
	}
	
//删除管理员	
	@RequestMapping("/adminDel" )
	public void adminDel(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		String id1=request.getParameter("userId");
		int id=Integer.parseInt(id1);
		int i=us.adminDel(id);
		System.out.println(i);
		resp.sendRedirect(request.getContextPath()+"/adminMana");
	}
	}
	
//管理员添加	
	@RequestMapping("/adminAdd" )
	public void adminAdd(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		String name=request.getParameter("userName");
		String userPw=request.getParameter("userPw");
		Admin ad=new Admin(name,userPw);
		int i=us.adminAdd(ad);
	    if(i==1){
	    	resp.sendRedirect(request.getContextPath()+"/adminMana");
	    }else{
	    	resp.sendRedirect("admin/admin/adminAdd.jsp");
	    }	
	}
	}
	
//课程遍历
	@RequestMapping("/kechengall" )
	public String kechengall(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
	    List<Kecheng> kc=us.kechengall();
	    request.setAttribute("kechengList", kc);
	    return "kecheng/kechengMana";
	}
	}
//课程删除
	@RequestMapping("/kechengDel" )
	public void kechengDel(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
	    String id1=request.getParameter("id");
	    int id=Integer.parseInt(id1);
	    int i=us.kechengDel(id);
	    resp.sendRedirect(request.getContextPath()+"/kechengall");
	    		}
	}	
	
//课程添加
	@RequestMapping("/kechengAdd" )
	public void kechengAdd(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
	    String bianhao=request.getParameter("bianhao");
	    String mingcheng=request.getParameter("mingcheng");
	    String keshi=request.getParameter("keshi");
	    Kecheng k=new Kecheng(bianhao,mingcheng,keshi);
	    int i=us.kechengadd(k);
	    resp.sendRedirect(request.getContextPath()+"/kechengall");
	    
	  }
	}
	
	//老师遍历
		@RequestMapping("/laoshiall" )
		public String laoshiall(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
		{{
			ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
			AdminService us=context.getBean("userServiceImpl",AdminService.class);
		    List<LaoShi> ls=us.laoshiall();
		    request.setAttribute("laoshiList", ls);
		    return "laoshi/laoshiMana";
		    
		    
		  }
		}
		//老师删除
		@RequestMapping("/laoshiDel" )
		public void laoshiDel(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
		{{
			ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
			AdminService us=context.getBean("userServiceImpl",AdminService.class);
		    String id1=request.getParameter("id");
		    int id=Integer.parseInt(id1);
		    us.laoshiDel(id);
		    resp.sendRedirect(request.getContextPath()+"/laoshiall");
		    
		  }
		}
		
		//老师添加
		@RequestMapping("/laoshiAdd" )
		public void laoshiAdd(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
		{{
			ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
			AdminService us=context.getBean("userServiceImpl",AdminService.class);
		    String bianhao=request.getParameter("bianhao");
		    String xingming=request.getParameter("xingming");
		    String xingbie=request.getParameter("xingbie");
		    String nianling=request.getParameter("nianling");
		    String zhicheng=request.getParameter("zhicheng");
		    String loginname=request.getParameter("loginname");
		    String loginpw=request.getParameter("loginpw");
		    LaoShi ls=new LaoShi(bianhao,xingming,xingbie,nianling,zhicheng,loginname,loginpw);
		    System.out.println(ls.getXingbie());
		    int i=us.laoshiAdd(ls);
		    resp.sendRedirect(request.getContextPath()+"/laoshiall");	    
		  }
		}
		//课表遍历
				@RequestMapping("/kebiaoall" )
				public String kebiaoall(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
				{{
					ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
					AdminService us=context.getBean("userServiceImpl",AdminService.class);
					List<KeBiao> a=new ArrayList<KeBiao>();
					a=us.kebiaoall();
					request.setAttribute("kebiaoList", a);
					session.setAttribute("kebiaoList", a);
					return "kebiao/kebiaoMana";
					
				  }
				}
		//删除课表
				@RequestMapping("/kebiaoDel" )
				public void kebiaoDel(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
				{{
					ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
					AdminService us=context.getBean("userServiceImpl",AdminService.class);
					String id1=request.getParameter("id");
					int id=Integer.parseInt(id1);
       				int i=us.kebiaoDel(id);
					resp.sendRedirect(request.getContextPath()+"/kebiaoall"); 
					
				  }
				}
				
				
				//课表添加
				@RequestMapping("/kebiaoAdd" )
				public void kebiaoAdd(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
				{{
					ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
					AdminService us=context.getBean("userServiceImpl",AdminService.class);
					String kecheng_id1=request.getParameter("kecheng_id");
					int kecheng_id=Integer.parseInt(kecheng_id1);
					Kecheng k=new Kecheng();
					k.setId(kecheng_id);
					String shijian=request.getParameter("shijian");
					String jieci=request.getParameter("jieci");
					String jiaoshi=request.getParameter("jiaoshi");
					String laoshi_id1=request.getParameter("laoshi_id");
					int laoshi_id=Integer.parseInt(laoshi_id1);
					LaoShi l=new LaoShi();
					l.setId(laoshi_id);
					KeBiao a=new KeBiao(k,shijian,jieci,jiaoshi,l);
				    int i=us.kebiaoAdd(a);
				    resp.sendRedirect(request.getContextPath()+"/kebiaoall"); 
					
				  }
				}
				
		//学生遍历
				@RequestMapping("/xueshengall" )
				public String xueshengall(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
				{{
					ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
					AdminService us=context.getBean("userServiceImpl",AdminService.class);
					List<Student> ls=new ArrayList<Student>();
					ls=us.xueshengall();
					request.setAttribute("xueshengList", ls);
					return "xuesheng/xueshengMana";
				  }
				}
		//学生删除
				@RequestMapping("/xueshengDel" )
				public void xueshengDel(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
				{{
					ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
					AdminService us=context.getBean("userServiceImpl",AdminService.class);
					String id1=request.getParameter("id");
					int id=Integer.parseInt(id1);
					int i=us.xueshengDel(id);
					resp.sendRedirect(request.getContextPath()+"/xueshengall");
				  }
				}
		//学生添加
				@RequestMapping("/xueshengAdd" )
				public void xueshengAdd(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
				{{
					ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
					AdminService us=context.getBean("userServiceImpl",AdminService.class);
					String xuehao=request.getParameter("xuehao");
					String xingming=request.getParameter("xingming");
					String xingbie=request.getParameter("xingbie");
					String nianling=request.getParameter("nianling");
					String banji=request.getParameter("banji");
					String loginname=request.getParameter("loginname");
					String loginpw=request.getParameter("loginpw");
					Student s=new Student(xuehao,xingming,xingbie,nianling,banji,loginname,loginpw);
					int i=us.xueshengAdd(s);
					resp.sendRedirect(request.getContextPath()+"/xueshengall");
				
				  }
				}
				//选择课程
				@RequestMapping("/kechengxiala" )
				public void kechengxiala(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
				{{
					ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
					AdminService us=context.getBean("userServiceImpl",AdminService.class);
                    List<Kecheng> kc=us.kechengall();
            	    session.setAttribute("kechengList", kc);
					resp.sendRedirect(request.getContextPath()+"/admin/kecheng/kechengAll.jsp");

					
				    
				  }
				}
				
				//选择老师
				@RequestMapping("/laoshixiala" )
				public void laoshixiala(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
				{{
					ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
					AdminService us=context.getBean("userServiceImpl",AdminService.class);
                    List<LaoShi> ls=us.laoshiall();
            	    session.setAttribute("laoshiList", ls);
					resp.sendRedirect(request.getContextPath()+"/admin/laoshi/laoshiAll.jsp");
				  }
				}
}
