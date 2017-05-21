package io.renren.entity;

import java.math.BigDecimal;

public class VoteRankingVo {
	
	// 部门
	private String departId;
	// 部门
	private String departName;
	// 配置项名称
	private String paramName;
	// 评价次数
	private int commentNum;
	// 好评率
	private BigDecimal totalRate;

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public BigDecimal getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(BigDecimal totalRate) {
		this.totalRate = totalRate;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
}
