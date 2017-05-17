package com.zuxia.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.zuxia.dao.IEmployeeDao;
import com.zuxia.model.Emps;

/**
 * ʵ�ֲ���Ա����Ϣ�Ľӿ�
 * @author Administrator lixiaojie
 * @version 1.0
 * @datetime 2016-10-21 20:12
 * 
 */
@SuppressWarnings("unchecked")
public class EmployeeDaoImpl implements IEmployeeDao {

	//ӳ�����sessionFactory
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void deleteEmps(Integer empid) {
		//�õ�session
		Session session = sessionFactory.getCurrentSession();
		//ʵ����ʵ����
		Emps emps=new Emps();
		emps.setEmpId(empid);
		//ɾ��
		session.delete(emps);
	}

	@Override
	public Emps getEmpsID(Integer empid) {
		//�õ�session
		Session session = sessionFactory.getCurrentSession();
		//�õ�����
		Emps emps = (Emps) session.get(Emps.class, empid);
		
		return emps;
	}

	
	@Override
	public List<Emps> getEmpsList() {
		//����hql
		String hql="From Emps ";
		//�õ����ݼ���
		List<Emps> list = sessionFactory.getCurrentSession().createQuery(hql).list();
		//���ؼ���	
		return list;
	}

	@Override
	public List<Emps> getEmpsList(Integer empid) {
		return null;
	}

	@Override
	public void insertEmpsInfo(Emps emps) {
		//�õ�session
		Session session = sessionFactory.getCurrentSession();
		//����
		session.save(emps);
	}

	@Override
	public void updateEmps(Emps emps) {
		//�õ�session
		Session session = sessionFactory.getCurrentSession();
		//�޸�
		session.update(emps);
	}
	
}
