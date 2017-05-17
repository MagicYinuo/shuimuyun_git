package com.zuxia.service;

import java.util.List;

import com.zuxia.model.Depts;
import com.zuxia.model.Emps;


/**
 * �ϲ�����emps��dept�����ݵĽӿ�
 * @author Administrator lixiaojie
 * @version 1.0
 * @datetime 2016-10-21 20:27
 *
 */
public interface IEmployeeService {
	
	//start emps
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
	//end emps
	
	//---------------------------------------------------
	
	//start dept
	//��ѯ����������Ϣ�ķ���������list����
	public List<Depts> getDempartmentList();
	
	//����id��ѯ������Ϣ�ķ���,����list����
	public List<Depts> getDempartmentList(Integer deptid);
	
	//����id��ѯ������Ϣ�ķ���,����Deptsʵ��
	public Depts getDempartmentID(Integer deptid);
	//end dept

	
}
