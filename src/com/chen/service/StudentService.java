package com.chen.service;

import java.util.List;


import com.chen.bean.KeBiao;
import com.chen.bean.Student;
public interface StudentService {
	//学生登录
public Student logins(Student s);

//学生课表
public List<KeBiao> xskebiaoAll1(int id);


//学生选课
public int xsaddkc(int kebiao_id,int xs_id);
}
