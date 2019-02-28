package com.chen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.bean.Admin;
import com.chen.bean.KeBiao;
import com.chen.bean.Kecheng;
import com.chen.bean.LaoShi;
import com.chen.bean.Student;
import com.chen.dao.AdminMapper;
import com.chen.dao.LaoShiMapper;
@Service("userServiceImpl")
public class AdminServiceImpl implements AdminService{

	@Autowired 
	private AdminMapper u;
	
	@Autowired 
	private LaoShiMapper l;

    //管理员登录
	public Admin login(Admin a) {
		Admin ad=u.login(a);
		return ad;
	}

	//管理员修改密码
	public int adminPwEdit(Admin a) {
		int i=u.adminPwEdit(a);
		return i;
	}

	//遍历管理员
	public List<Admin> All() {
		List<Admin> a=new ArrayList<Admin>();
		a=u.All();
		return a;
	}
	
	//根据ID删除管理员
	public int adminDel(int id) {
		int i=u.adminDel(id);
	    return i;
	}

	//添加管理员
	public int adminAdd(Admin a) {
		String name=a.getUserName();
		Admin ad=u.selectname(name);
		int i=0;
		if(ad==null)
		{
			i=u.adminAdd(a);
		}else{
			i=0;
		}
		return i;
	}


    //遍历课程表
	public List<Kecheng> kechengall() {
		List<Kecheng> kc=new ArrayList<Kecheng>();
		kc=u.kechengall();
		return kc;
	}

    //根据ID删除课程
	public int kechengDel(int id) {
		int i=u.kechengDel(id);
		return i;
	}

	//添加课程
	public int kechengadd(Kecheng k) {
		int i=u.kechengadd(k);
		return i;
	}

    //遍历老师
	public List<LaoShi> laoshiall() {
		List<LaoShi> ls=new ArrayList<LaoShi>();
		ls=u.laoshiall();
		return ls;
	}

    //根据ID删除老师
	public int laoshiDel(int id) {
		int i=u.laoshiDel(id);
		return i;
	}

    //添加老师
	public int laoshiAdd(LaoShi a) {
	    int i=u.laoshiAdd(a);
		return i;
	}

	//遍历课表
	public List<KeBiao> kebiaoall() {
		List<KeBiao> a=new ArrayList<KeBiao>();
		a=u.kebiaoall();
		return a;
	}
	  //根据ID删除课表
	public int kebiaoDel(int id) {
		int i=u.kebiaoDel(id);
		return i;
	}

	//学生遍历
	public List<Student> xueshengall() {
		List<Student> ls=new ArrayList<Student>();
		ls=u.xueshengall();
		return ls;
	}

	//学生删除
	public int xueshengDel(int id) {
		int i=u.xueshengDel(id);
		return i;
	}

	//学生添加
	public int xueshengAdd(Student s) {
		int i=u.xueshengAdd(s);
		return i;
	}

	//老师登陆
	public LaoShi loginls(LaoShi a) {
		LaoShi ls=l.loginls(a);
		return ls;
	}

	//课表添加
	public int kebiaoAdd(KeBiao a) {
		int i=u.kebiaoAdd(a);
		return i;
	}

	
	
	


}
