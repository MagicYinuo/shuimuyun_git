package com.zuxia.dao;

import java.util.List;

import com.zuxia.model.Depts;
/**
 * ������Ϣ�Ĳ����Ľӿ�
 * @author Administrator lixiaojie
 * @version 1.0
 * @datetime 2016-10-21
 */
public interface IDepartmentDao {
	//��ѯ����������Ϣ�ķ���������list����
	public List<Depts> getDempartmentList();
	
	//����id��ѯ������Ϣ�ķ���,����list����
	public List<Depts> getDempartmentList(Integer deptid);
	
	//����id��ѯ������Ϣ�ķ���,����Deptsʵ��
	public Depts getDempartmentID(Integer deptid);
}
