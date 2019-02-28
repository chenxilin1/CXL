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
import com.chen.service.AdminService;
import com.chen.service.LaoshiService;

@Controller
public class Laoshi {
	//¿œ ¶øŒ±Ì
	@RequestMapping("/lskebiaoall")
	public void lskebiaoall(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		LaoshiService stu=context.getBean("lsservice",LaoshiService.class);
		List<KeBiao> kb=stu.lskebiaoall();
		session.setAttribute("lskebiaoall", kb);
		resp.sendRedirect(request.getContextPath()+"/alaoshi/KB.jsp");
		

	  }
	}
}
