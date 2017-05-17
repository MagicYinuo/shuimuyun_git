package com.zuxia.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zuxia.model.Depts;
import com.zuxia.model.Emps;
import com.zuxia.service.IEmployeeService;
import com.zuxia.service.impl.EmployeeServiceImpl;

/**
 * �����û������󣬱�ʾ��
 * @author Administrator lixiaojie
 * @version 1.0
 * @datetime 2016-10-21 20:32
 * 
 */
@SuppressWarnings("serial")
public class EmployeeAction extends ActionSupport {
	
	//ӳ��EmployeeServiceImpl
	private IEmployeeService employeeServiceImpl;

	public IEmployeeService getEmployeeServiceImpl() {
		return employeeServiceImpl;
	}

	public void setEmployeeServiceImpl(IEmployeeService employeeServiceImpl) {
		this.employeeServiceImpl = employeeServiceImpl;
	}
	

	private Emps emps;

	public Emps getEmps() {
		return emps;
	}

	public void setEmps(Emps emps) {
		this.emps = emps;
	}
	
	/**
	 * �޸�Ա����Ϣ
	 */
	public String update(){
		employeeServiceImpl.updateEmps(emps);
		return query();
	}
	
	/**
	 * ���Ա��
	 */
	public String insert(){
		employeeServiceImpl.insertEmpsInfo(emps);
		return query();
	}
	

	/**
	 * ��ѯ����Ա����Ϣ
	 * @return
	 */
	public String query() {
		System.out.println("123456");
		//�õ�����
		List<Emps> empsList = employeeServiceImpl.getEmpsList();
		//����request������
		ServletActionContext.getRequest().setAttribute("employeeList", empsList);
		
		return "query";
	}
	
	/**
	 * �޸�Ա����Ϣ֮ǰ���õķ���
	 */
	public String updateSelect(){
		//�õ�����
		Emps empsID = employeeServiceImpl.getEmpsID(emps.getEmpId());
		//���õ�request
		ServletActionContext.getRequest().setAttribute("emp", empsID);
		
		//�õ�����list
		List<Depts> dempartmentList = employeeServiceImpl.getDempartmentList();
		//���õ�request
		ServletActionContext.getRequest().setAttribute("departmentList", dempartmentList);
		
		return "update";
		
	}
	
	/**
	 * ɾ��
	 */
	public String delete(){
		employeeServiceImpl.deleteEmps(emps.getEmpId());
		return query();
	}
	
	
}
