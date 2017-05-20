package com.ssh.util;

import java.util.List;

/**
 * 分页模型
 * @author 李小杰
 * @version 1.0
 * @datetiem 2016-9-25 14:50
 */
public class PageModel<T> {
	
	/**
	 * 当前页
	 */
	private Integer pageIndex=1;
	
	/**
	 * 总页数
	 */
	private Integer pageCount;
	
	/**
	 * 页容量
	 */
	private Integer pageNum=6;
	
	/**
	 * 总数据量
	 */
	private Integer numCount;
	
	/**
	 * 集合数据
	 */
	private List<T> list;
	/**
	 * 首页
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
	 * 上一页
	 */
	private Integer shang;
	
	/**
	 * 下一页
	 */
	private Integer xia;
	
	/**
	 * 尾页
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
		//得到总页数
		this.pageCount=this.numCount%this.pageNum==0?this.numCount/this.pageNum:this.numCount/this.pageNum+1;
		//得到上一页
		this.shang=this.pageIndex >1?this.pageIndex-1:1;
		//得到下一页
		this.xia=this.pageIndex<this.pageCount?this.pageIndex+1:this.pageCount;
		//得到最后一页
		this.last=this.pageCount;
		//首页
		this.frist=1;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
