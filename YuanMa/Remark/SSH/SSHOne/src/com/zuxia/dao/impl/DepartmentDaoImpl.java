package com.zuxia.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.zuxia.dao.IDepartmentDao;
import com.zuxia.model.Depts;

/**
 * ʵ�ֲ���������Ϣ�Ľӿ�
 * @author Administrator lixiaojie
 * @version 1.0
 * @datetime 2016-10-21
 * 
 */
@SuppressWarnings("unchecked")
public class DepartmentDaoImpl implements IDepartmentDao {

	//ӳ�����sessionFactory
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//����id��ѯ������Ϣ�ķ���,����Deptsʵ��
	@Override
	public Depts getDempartmentID(Integer deptid) {
		//���ȵõ�session
		Session session = sessionFactory.getCurrentSession();
		//�õ�����
		Depts depts = (Depts) session.get(Depts.class, deptid);
		
		//��������
		return depts;
		
	}

	//��ѯ����������Ϣ�ķ���������list����
	@Override
	public List<Depts> getDempartmentList() {
		//����Hql
		String hql="From Depts ";
		//�õ�����
		List<Depts> list = sessionFactory.getCurrentSession().createQuery(hql).list();
		//���ؼ���
		return list;
	}

	//����id��ѯ������Ϣ�ķ���,����list����
	@Override
	public List<Depts> getDempartmentList(Integer deptid) {
		
		
		
		return null;
	}
	
	
	
	
	
}
