package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 评价活动选项表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:18
 */
public class VoteActivityParamEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//评价活动id
	private Long voteActivityId;
	//活动参数
	private String paramName;
	//创建者
	private Long createUser;

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
	 * 设置：评价活动id
	 */
	public void setVoteActivityId(Long voteActivityId) {
		this.voteActivityId = voteActivityId;
	}
	/**
	 * 获取：评价活动id
	 */
	public Long getVoteActivityId() {
		return voteActivityId;
	}
	/**
	 * 设置：活动参数
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	/**
	 * 获取：活动参数
	 */
	public String getParamName() {
		return paramName;
	}
	/**
	 * 设置：创建者
	 */
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建者
	 */
	public Long getCreateUser() {
		return createUser;
	}
}
