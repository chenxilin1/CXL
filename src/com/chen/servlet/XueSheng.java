package com.chen.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.bean.KeBiao;
import com.chen.bean.Kecheng;
import com.chen.bean.Student;
import com.chen.bean.Student_kb;
import com.chen.service.AdminService;
import com.chen.service.StudentService;

@Controller
public class XueSheng {
@RequestMapping("/xskebiaoAll")
public void xskebiaoAll(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
{{
	ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
	StudentService stu=context.getBean("stServiceImpl",StudentService.class);
	Student st=(Student) session.getAttribute("xuesheng");
	int id=st.getId();
	List<KeBiao> kb=stu.xskebiaoAll1(id);
	System.out.println(kb);
	session.setAttribute("xuesheng_kebiao_list", kb);
	resp.sendRedirect(request.getContextPath()+"/axuesheng/kebiao/kebiao_mana_stu.jsp");

  }
}


//¿Î±í±éÀú
@RequestMapping("/xskechengall")
public void xskechengall(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
{{
	ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
	AdminService stu=context.getBean("userServiceImpl",AdminService.class);
	List<KeBiao> kb=stu.kebiaoall();
	session.setAttribute("xskebiaoll", kb);
	resp.sendRedirect(request.getContextPath()+"/axuesheng/kebiao/kkkk.jsp");
	

  }
}

//Ñ¡¿Î
@RequestMapping("/xsaddkc")
public void xsaddkc(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
{{
	ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
	StudentService stu=context.getBean("stServiceImpl",StudentService.class);
	String kebiao_id1=request.getParameter("id");
	int kebiao_id=Integer.parseInt(kebiao_id1);
	Student s=(Student) session.getAttribute("xuesheng");
	int xsid=s.getId();
	System.out.println(xsid);
	int i=stu.xsaddkc(xsid, kebiao_id);
	resp.sendRedirect(request.getContextPath()+"/xskebiaoAll");
	
	

}
}
}
