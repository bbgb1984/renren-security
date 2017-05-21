package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 评价活动表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:18
 */
public class VoteActivityEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//评价活动名称
	private String voteName;
	//评价活动描述
	private String voteDesc;
	//开始时间
	private String beginTime;
	//开始时间
	private String endTime;
	//状态 1：生效；0：无效
	private String status;
	//个人最多可评价单位个数
	private String maxNum;
	//创建者
	private Long createUser;
	//创建者
	private Long exploreNum;

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
	 * 设置：评价活动名称
	 */
	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}
	/**
	 * 获取：评价活动名称
	 */
	public String getVoteName() {
		return voteName;
	}
	/**
	 * 设置：评价活动描述
	 */
	public void setVoteDesc(String voteDesc) {
		this.voteDesc = voteDesc;
	}
	/**
	 * 获取：评价活动描述
	 */
	public String getVoteDesc() {
		return voteDesc;
	}
	/**
	 * 设置：开始时间
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	/**
	 * 获取：开始时间
	 */
	public String getBeginTime() {
		return beginTime;
	}
	/**
	 * 设置：开始时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：开始时间
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：状态 1：生效；0：无效
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态 1：生效；0：无效
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：个人最多可评价单位个数
	 */
	public void setMaxNum(String maxNum) {
		this.maxNum = maxNum;
	}
	/**
	 * 获取：个人最多可评价单位个数
	 */
	public String getMaxNum() {
		return maxNum;
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
	public Long getExploreNum() {
		return exploreNum;
	}
	public void setExploreNum(Long exploreNum) {
		this.exploreNum = exploreNum;
	}
}
