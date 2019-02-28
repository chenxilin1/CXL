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

    //����Ա��¼
	public Admin login(Admin a) {
		Admin ad=u.login(a);
		return ad;
	}

	//����Ա�޸�����
	public int adminPwEdit(Admin a) {
		int i=u.adminPwEdit(a);
		return i;
	}

	//��������Ա
	public List<Admin> All() {
		List<Admin> a=new ArrayList<Admin>();
		a=u.All();
		return a;
	}
	
	//����IDɾ������Ա
	public int adminDel(int id) {
		int i=u.adminDel(id);
	    return i;
	}

	//��ӹ���Ա
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


    //�����γ̱�
	public List<Kecheng> kechengall() {
		List<Kecheng> kc=new ArrayList<Kecheng>();
		kc=u.kechengall();
		return kc;
	}

    //����IDɾ���γ�
	public int kechengDel(int id) {
		int i=u.kechengDel(id);
		return i;
	}

	//��ӿγ�
	public int kechengadd(Kecheng k) {
		int i=u.kechengadd(k);
		return i;
	}

    //������ʦ
	public List<LaoShi> laoshiall() {
		List<LaoShi> ls=new ArrayList<LaoShi>();
		ls=u.laoshiall();
		return ls;
	}

    //����IDɾ����ʦ
	public int laoshiDel(int id) {
		int i=u.laoshiDel(id);
		return i;
	}

    //�����ʦ
	public int laoshiAdd(LaoShi a) {
	    int i=u.laoshiAdd(a);
		return i;
	}

	//�����α�
	public List<KeBiao> kebiaoall() {
		List<KeBiao> a=new ArrayList<KeBiao>();
		a=u.kebiaoall();
		return a;
	}
	  //����IDɾ���α�
	public int kebiaoDel(int id) {
		int i=u.kebiaoDel(id);
		return i;
	}

	//ѧ������
	public List<Student> xueshengall() {
		List<Student> ls=new ArrayList<Student>();
		ls=u.xueshengall();
		return ls;
	}

	//ѧ��ɾ��
	public int xueshengDel(int id) {
		int i=u.xueshengDel(id);
		return i;
	}

	//ѧ�����
	public int xueshengAdd(Student s) {
		int i=u.xueshengAdd(s);
		return i;
	}

	//��ʦ��½
	public LaoShi loginls(LaoShi a) {
		LaoShi ls=l.loginls(a);
		return ls;
	}

	//�α����
	public int kebiaoAdd(KeBiao a) {
		int i=u.kebiaoAdd(a);
		return i;
	}

	
	
	


}
