package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 评价活动投票结果
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:17
 */
public class VoteActivityResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//评价活动id
	private Long voteActivityId;
	//单位id
	private Long departId;
	//评价项id
	private Long voteActivityParamId;
	//评价值
	private String voteActivityParamVal;
	//投票人
	private Long userId;
	//投票时间
	private Date voteTime;
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
	 * 设置：评价项id
	 */
	public void setVoteActivityParamId(Long voteActivityParamId) {
		this.voteActivityParamId = voteActivityParamId;
	}
	/**
	 * 获取：评价项id
	 */
	public Long getVoteActivityParamId() {
		return voteActivityParamId;
	}
	/**
	 * 设置：评价值
	 */
	public void setVoteActivityParamVal(String voteActivityParamVal) {
		this.voteActivityParamVal = voteActivityParamVal;
	}
	/**
	 * 获取：评价值
	 */
	public String getVoteActivityParamVal() {
		return voteActivityParamVal;
	}
	/**
	 * 设置：投票人
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：投票人
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：投票时间
	 */
	public void setVoteTime(Date voteTime) {
		this.voteTime = voteTime;
	}
	/**
	 * 获取：投票时间
	 */
	public Date getVoteTime() {
		return voteTime;
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
