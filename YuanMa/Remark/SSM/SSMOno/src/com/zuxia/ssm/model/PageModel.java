package com.zuxia.ssm.model;

import java.util.List;

/**
 * ��ҳģ��
 * @author Administrator
 * @version 1.0
 * @datetiem 2016-9-25 14:50
 */
public class PageModel<T> {
	
	/**
	 * ��ǰҳ
	 */
	private Integer pageIndex=1;
	
	/**
	 * ��ҳ��
	 */
	private Integer pageCount;
	
	/**
	 * ҳ����
	 */
	private Integer pageNum=10;
	
	/**
	 * ��������
	 */
	private Integer numCount;
	
	/**
	 * ��������
	 */
	private List<T> list;
	/**
	 * ��ҳ
	 */
	private Integer frist=1;
	
	public Integer getFrist() {
		return frist;
	}

	public void setFrist(Integer frist) {
		this.frist = frist;
	}

	public Integer getShang() {
		return shang;
	}

	public void setShang(Integer shang) {
		this.shang = shang;
	}

	public Integer getXia() {
		return xia;
	}

	public void setXia(Integer xia) {
		this.xia = xia;
	}

	public Integer getLast() {
		return last;
	}

	public void setLast(Integer last) {
		this.last = last;
	}

	/**
	 * ��һҳ
	 */
	private Integer shang;
	
	/**
	 * ��һҳ
	 */
	private Integer xia;
	
	/**
	 * βҳ
	 */
	private Integer last;
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getNumCount() {
		return numCount;
	}

	public void setNumCount(Integer numCount) {
		this.numCount = numCount;
		//�õ���ҳ��
		this.pageCount=this.numCount%this.pageNum==0?this.numCount/this.pageNum:this.numCount/this.pageNum+1;
		//�õ���һҳ
		this.shang=this.pageIndex >1?this.pageIndex-1:1;
		//�õ���һҳ
		this.xia=this.pageIndex<this.pageCount?this.pageIndex+1:this.pageCount;
		//�õ����һҳ
		this.last=this.pageCount;
		//��ҳ
		this.frist=1;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
