package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 政府部门设置
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:17
 */
public class GovermentDepartmentConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//部门名称
	private String name;
	//状态 1：有效；0：无效
	private String status;
	//govement_department_category表id
	private Long type;

	private String categoryName;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
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
	 * 设置：部门名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：部门名称
	 */
	public String getName() {
		return name;
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
	/**
	 * 设置：govement_department_category表id
	 */
	public void setType(Long type) {
		this.type = type;
	}
	/**
	 * 获取：govement_department_category表id
	 */
	public Long getType() {
		return type;
	}
}
