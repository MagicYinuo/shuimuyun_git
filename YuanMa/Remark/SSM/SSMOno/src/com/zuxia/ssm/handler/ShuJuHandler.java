package com.zuxia.ssm.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zuxia.ssm.model.Depts;
import com.zuxia.ssm.model.Emps;
import com.zuxia.ssm.model.PageModel;
import com.zuxia.ssm.services.DataServices;



@Controller
public class ShuJuHandler {

	@Autowired
	private DataServices dataServices;
	
	@RequestMapping(value="/empsAll",method=RequestMethod.GET)
	public String getAll(Map<String, Object> map){
		
		List<Emps> all = dataServices.getAll();
		map.put("list", all);
		
		return "EmpsManger";
	}
	
	//��ҳ��ѯpageAll
	@RequestMapping(value="/empsAll/{indexNum}/{pageNum}",method=RequestMethod.GET)
	public String pageAll(@PathVariable(value="indexNum")Integer index,@PathVariable(value="pageNum")Integer pageNum,Map<String,Object> map){
		
		System.out.println(index+"//"+pageNum);
		PageModel<Emps> page=new PageModel<Emps>();
		
		//���÷�ҳ��ֵ
		page.setPageIndex(index);
		page.setPageNum(pageNum);
		page.setNumCount(dataServices.getNum());
		
		//���õ�ǰҳ��ҳ����
		map.put("indexNum",((index-1)*pageNum));
		map.put("pageNum", pageNum);
		
		
		//���÷����ĵ�����
		page.setList(dataServices.pageAll(map));
		
		map.put("page", page);
		
		System.out.println("getNum="+dataServices.getNum());
		System.out.println("page.index="+page.getPageIndex());
		System.out.println("page.pageNum="+page.getPageNum());
		System.out.println("page.CountNum="+page.getPageCount());
		
		//�ض���
		return "pageEmpsManger";
	}
	
	
	//���֮ǰ���õķ���
	@RequestMapping("/updateEmps")
	public String insertEmps(Map<String, Object> map){
		List<Depts> deptsAll = dataServices.getDeptsAll();
		map.put("deptsAll", deptsAll);
		map.put("employee", new Emps());
		System.out.println(deptsAll);
		return "UpdateInset";
		
	}
	
	/*//����֮���ת��,��ʽһ
	@InitBinder
	public void init(ServletRequestDataBinder binder){
		//��ʽ�����ڸ�ʽ
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(format, true);
		//ת����Date��ʽ
		binder.registerCustomEditor(Date.class, dateEditor);
		
		//binder.setDisallowedFields("birthday");
	}
	
	//���
	@RequestMapping(value="/employee",method=RequestMethod.POST)
	public String insertEmpsInfo(Emps emps){
		
		employeeService.saveEmployee(emps);
		//redirect:/showAllEmployee
		return "redirect:/showAllEmployee";
	}*/
	
	
	//����֮���ת��,��ʽ��
	@InitBinder
	public void init(WebDataBinder binder){
		////��ʽ�����ڸ�ʽ
		binder.setDisallowedFields("birthday");
	}
	
	//submit���
	@RequestMapping(value="/updateEmps",method=RequestMethod.POST)
	public String insertEmpsInfo(@RequestParam("birthday")String birthday,Emps emps) throws ParseException{
		System.out.println(birthday);
		//ʵ������ʽ������
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(birthday);
		System.out.println(date);
		emps.setBirthday(date);
		
		dataServices.insertEmpInfo(emps);
		//�ض���
		return "redirect:/empsAll";
		
	}
	
	
	//�޸�֮ǰ���õķ���
	@RequestMapping(value="/updateEmps/{id}")
	public String updateEmps(@PathVariable("id")Integer id,Map<String, Object> map){
		List<Depts> deptsAll = dataServices.getDeptsAll();
		
		//�õ�������Ϣ
		map.put("deptsAll", deptsAll);
		System.out.println(id);
		//�õ�Ҫ�޸ĵ�����
		Emps empsId = dataServices.getEmpsId(id);
		map.put("employee", empsId);
		System.out.println("�޸�֮ǰ");
		
		return "UpdateInset";
	}	
	//�޸�֮ǰ��������
	@ModelAttribute
	public void saveBirthday(@RequestParam(value="empId",required=false)Integer empid,Map<String, Object> map){
		if(empid!=null){
			System.out.println("�޸�֮ǰ��������");
			Emps empsId = dataServices.getEmpsId(empid);
			map.put("empId", empsId);
			System.out.println("�������ճɹ�");
			
		}
		
	}
	//submit�ύ�޸�
	@RequestMapping(value="/updateEmps",method=RequestMethod.PUT)
	public String updateEmps(@ModelAttribute("empId")Emps emps){
		System.out.println(emps.getBirthday());
		dataServices.updateEmps(emps);
		System.out.println(emps.getBirthday());
		
		//�ض���
		return "redirect:/empsAll";
	}
	
	
	
	
	//ɾ��
	@RequestMapping(value="/deleteEmps/{id}")
	public String deleteEmps(@PathVariable("id")Integer id,Map<String, Object> map){
		dataServices.deleteEmps(id);
		map.put("list", dataServices.getAll());
		return "EmpsManger";
	}
	
	
}
