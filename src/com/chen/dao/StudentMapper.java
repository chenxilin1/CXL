package com.chen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chen.bean.KeBiao;
import com.chen.bean.Student;

public interface StudentMapper {
	
//ѧ����¼
public Student logins(Student s);

//ѧ���α�
public List<KeBiao> xskebiaoAll1(int id);

//ѧ��ѡ��
public int xsaddkc(@Param("xs_id")int xs_id,@Param("kebiao_id")int kebiao_id);
}
