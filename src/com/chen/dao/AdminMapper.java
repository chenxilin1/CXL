package com.chen.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chen.bean.Admin;
import com.chen.bean.KeBiao;
import com.chen.bean.Kecheng;
import com.chen.bean.LaoShi;
import com.chen.bean.Student;

public interface AdminMapper {
  //管理员登录
  public Admin login(Admin a);  
  
  //管理员密码修改
  public int adminPwEdit(Admin a);
  
  //获取所有管理员
  public List<Admin> All();
  
  //删除指定管理员
  public int adminDel(@Param("id")int id);
  
  //添加管理员
  public int adminAdd(Admin a);
  
  //根据名字查找管理员
  public Admin selectname(@Param("name")String name);
  
  //查询所有课程
  public List<Kecheng> kechengall();
  
  //根据ID删除课程
  public int kechengDel(int id);
  
  //添加课程
  public int kechengadd(Kecheng k);
  
  //遍历老师
  public List<LaoShi> laoshiall();
  
  //根据Id删除老师
  public int laoshiDel(int id);
  
  //添加老师
  public int laoshiAdd(LaoShi a);
  
  //遍历课表
  public List<KeBiao> kebiaoall();
  
  //根据ID删除课表
  public int kebiaoDel(int id);
  
  //添加课表
  
  public int kebiaoAdd(KeBiao a);
  
  //学生遍历
  public List<Student> xueshengall();
  
  //学生删除
  public int xueshengDel(int id);
  
  //学生添加
  public int xueshengAdd(Student s);


}
