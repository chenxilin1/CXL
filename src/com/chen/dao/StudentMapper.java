package com.chen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chen.bean.KeBiao;
import com.chen.bean.Student;

public interface StudentMapper {
	
//学生登录
public Student logins(Student s);

//学生课表
public List<KeBiao> xskebiaoAll1(int id);

//学生选课
public int xsaddkc(@Param("xs_id")int xs_id,@Param("kebiao_id")int kebiao_id);
}
