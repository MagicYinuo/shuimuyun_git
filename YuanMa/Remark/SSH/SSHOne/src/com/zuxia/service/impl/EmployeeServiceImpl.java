package com.zuxia.service.impl;

import java.util.List;

import com.zuxia.dao.impl.DepartmentDaoImpl;
import com.zuxia.dao.impl.EmployeeDaoImpl;
import com.zuxia.model.Depts;
import com.zuxia.model.Emps;
import com.zuxia.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService{
	//ӳ�䴦��Ա�����ݵ�ҵ���߼���
	private EmployeeDaoImpl employeeDaoImpl;
	
	//��ɫ���������ݵ�ҵ���߼���
	private DepartmentDaoImpl departmentDaoImpl;

	public EmployeeDaoImpl getEmployeeDaoImpl() {
		return employeeDaoImpl;
	}

	public void setEmployeeDaoImpl(EmployeeDaoImpl employeeDaoImpl) {
		this.employeeDaoImpl = employeeDaoImpl;
	}

	public DepartmentDaoImpl getDepartmentDaoImpl() {
		return departmentDaoImpl;
	}

	public void setDepartmentDaoImpl(DepartmentDaoImpl departmentDaoImpl) {
		this.departmentDaoImpl = departmentDaoImpl;
	}
	//����idɾ��Ա����Ϣ
	@Override
	public void deleteEmps(Integer empid) {
		employeeDaoImpl.deleteEmps(empid);
	}

	//����id��ѯ������Ϣ�ķ���,����Deptsʵ��
	@Override
	public Depts getDempartmentID(Integer deptid) {
		return departmentDaoImpl.getDempartmentID(deptid);
	}
	//��ѯ����������Ϣ�ķ���������list����
	@Override
	public List<Depts> getDempartmentList() {
		return departmentDaoImpl.getDempartmentList();
	}

	@Override
	public List<Depts> getDempartmentList(Integer deptid) {
		return departmentDaoImpl.getDempartmentList(deptid);
	}

	@Override
	public Emps getEmpsID(Integer empid) {
		return employeeDaoImpl.getEmpsID(empid);
	}
	//��ѯ��Ա��������Ϣ������list����
	@Override
	public List<Emps> getEmpsList() {
		return employeeDaoImpl.getEmpsList();
	}
	//����Ա����Ų�ѯ������list����
	@Override
	public List<Emps> getEmpsList(Integer empid) {
		return employeeDaoImpl.getEmpsList(empid);
	}
	//���Ա����Ϣ
	@Override
	public void insertEmpsInfo(Emps emps) {
		employeeDaoImpl.insertEmpsInfo(emps);
	}
	//����id�޸�Ա����Ϣ
	@Override
	public void updateEmps(Emps emps) {
		employeeDaoImpl.updateEmps(emps);
	}
	
	
	
}
