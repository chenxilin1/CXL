package com.chen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.bean.KeBiao;
import com.chen.bean.Student;
import com.chen.dao.StudentMapper;
@Service("stServiceImpl")
public class StudentServiceImpl implements StudentService{

@Autowired StudentMapper st;
	//ѧ����¼
	public Student logins(Student s) {
		Student a=st.logins(s);
		return a;
	}
	//ѧ���α�(����ID����)
	public List<KeBiao> xskebiaoAll1(int id) {
		List<KeBiao> kb=st.xskebiaoAll1(id);
		return kb;
	}
	//ѧ��ѡ��
	public int xsaddkc( int xs_id,int kebiao_id) {
	int i=st.xsaddkc(xs_id, kebiao_id);
		return i;
	}

}
