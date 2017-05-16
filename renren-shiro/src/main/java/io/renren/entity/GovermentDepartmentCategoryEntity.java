package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 政府部门设置
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:18
 */
public class GovermentDepartmentCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//部门类别
	private String categoryName;
	//状态 1：有效；0：无效
	private String status;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：部门类别
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 获取：部门类别
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 设置：状态 1：有效；0：无效
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态 1：有效；0：无效
	 */
	public String getStatus() {
		return status;
	}
}
