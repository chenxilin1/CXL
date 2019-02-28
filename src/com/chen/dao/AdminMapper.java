package com.chen.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chen.bean.Admin;
import com.chen.bean.KeBiao;
import com.chen.bean.Kecheng;
import com.chen.bean.LaoShi;
import com.chen.bean.Student;

public interface AdminMapper {
  //����Ա��¼
  public Admin login(Admin a);  
  
  //����Ա�����޸�
  public int adminPwEdit(Admin a);
  
  //��ȡ���й���Ա
  public List<Admin> All();
  
  //ɾ��ָ������Ա
  public int adminDel(@Param("id")int id);
  
  //��ӹ���Ա
  public int adminAdd(Admin a);
  
  //�������ֲ��ҹ���Ա
  public Admin selectname(@Param("name")String name);
  
  //��ѯ���пγ�
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


}
