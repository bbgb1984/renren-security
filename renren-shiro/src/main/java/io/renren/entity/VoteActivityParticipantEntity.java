package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 评价活动参与单位
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:16
 */
public class VoteActivityParticipantEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//评价活动id
	private Long voteActivityId;
	//单位id
	private Long departId;
	//创建者
	private Long createUser;
	//创建时间
	private Date createTime;
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
	 * 设置：单位id
	 */
	public void setDepartId(Long departId) {
		this.departId = departId;
	}
	/**
	 * 获取：单位id
	 */
	public Long getDepartId() {
		return departId;
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
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
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
