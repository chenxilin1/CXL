package com.chen.service;

import java.util.List;

import com.chen.bean.Admin;
import com.chen.bean.KeBiao;
import com.chen.bean.Kecheng;
import com.chen.bean.LaoShi;
import com.chen.bean.Student;
public interface AdminService {
	  //��¼
	  public Admin login(Admin a);  
	  
	  //�޸�
	  public int adminPwEdit(Admin a);
	  
	  //��ȡ���й���Ա
	  public List<Admin> All();
	  
	  //ɾ��ָ������Ա
	  public int adminDel(int id);
	  
	  //��ӹ���Ա
	  public int adminAdd(Admin a);
	  
	  //�γ̱���
	  public List<Kecheng> kechengall();
	  
	  //����IDɾ���γ�
	  public int kechengDel(int id);
	  
	  //��ӿγ�
	  public int kechengadd(Kecheng k);
	  
	  //������ʦ
	  public List<LaoShi> laoshiall();
	  
	  //����Idɾ����ʦ
	  public int laoshiDel(int id);
	  
	  //�����ʦ
	  public int laoshiAdd(LaoShi a);
	  
	  //�����α�
	  public List<KeBiao> kebiaoall();
	  
	  //����IDɾ���α�
	  public int kebiaoDel(int id);
	  
	  //��ӿα�
	  public int kebiaoAdd(KeBiao a);
	  
	  //ѧ������
	  public List<Student> xueshengall();
	  
	  //ѧ��ɾ��
	  public int xueshengDel(int id);
	  
	  //ѧ�����
	  public int xueshengAdd(Student s);
	  
	  //��ʦ��½
	  public LaoShi loginls(LaoShi a);
}
