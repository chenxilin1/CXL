package com.chen.service;

import java.util.List;


import com.chen.bean.KeBiao;
import com.chen.bean.Student;
public interface StudentService {
	//ѧ����¼
public Student logins(Student s);

//ѧ���α�
public List<KeBiao> xskebiaoAll1(int id);


//ѧ��ѡ��
public int xsaddkc(int kebiao_id,int xs_id);
}
