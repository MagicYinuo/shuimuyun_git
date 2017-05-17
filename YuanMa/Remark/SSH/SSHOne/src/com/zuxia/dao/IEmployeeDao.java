package com.zuxia.dao;

import java.util.List;

import com.zuxia.model.Emps;

/**
 * ��Ա����Ϣ�����Ľӿ�
 * @author Administrator lixiaojie
 * @version 1.0
 * @datetime 2016-10-21 19:35
 */
public interface IEmployeeDao {
	
	//��ѯ��Ա��������Ϣ������list����
	public List<Emps> getEmpsList();
	
	//����Ա����Ų�ѯ������list����
	public List<Emps> getEmpsList(Integer empid);
	
	//����Ա����Ų�ѯ������empsʵ��
	public Emps getEmpsID(Integer empid);
	
	//����Ա����Ϣ
	public void insertEmpsInfo(Emps emps);
	
	//����id�޸�Ա����Ϣ
	public void updateEmps(Emps emps);
	
	//����idɾ��Ա����Ϣ
	public void deleteEmps(Integer empid);
	
	
	
}
