package com.zuxia.ssm.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuxia.ssm.model.Depts;
import com.zuxia.ssm.model.Emps;
import com.zuxia.ssm.mybatis.CustomerData;

@Service
public class DataServices {
	
	@Autowired
	private CustomerData customerData;
	//�õ�������
	public Integer getNum(){
		return customerData.getNum();
	}
	
	//��ҳ��ѯpageAll
	public List<Emps> pageAll(Map<String,Object> map){
		return customerData.pageAll(map);
	}
	
	//�õ���������
	@Transactional //����
	public List<Emps> getAll(){
		return customerData.getAll();
	}
	
	//submit���
	public void insertEmpInfo(Emps emps){
		customerData.insertEmpInfo(emps);
	}
	
	
	//�޸�֮ǰ���õķ���
	@Transactional
	public List<Depts> getDeptsAll(){
		return customerData.getDepts();
	}
	
	//submit�޸�
	public void updateEmps(Emps emps){
		customerData.updateEmps(emps);
	}
	
	//ɾ��
	public void deleteEmps(Integer id){
		customerData.deleteEmps(id);
	}
	
	//����id��ѯemps
	public Emps getEmpsId(Integer id){
		
		return customerData.getEmpsId(id);
	}
	
}
