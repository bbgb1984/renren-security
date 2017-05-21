package io.renren.dao;

import io.renren.entity.VoteActivityResultEntity;
import io.renren.entity.VoteRankingVo;

import java.util.List;

/**
 * 评价活动投票结果
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:17
 */
public interface VoteActivityResultDao extends BaseDao<VoteActivityResultEntity> {
	
	int queryCommentNumById(Object id);
	
	public List<VoteRankingVo> queryHighCommentRateTopTen(
			Object param);
	
	public List<VoteRankingVo> queryCommentTopTen(Object param);
	
	/**
	 * 统计当前活动当前用户已评价过的单位总数
	 * @param param
	 * @return
	 */
	public int queryCommentDepartsNum(Object param);
	
	/**
	 * 查询指定部门当前用户是否已评论！
	 * @param param
	 * @return
	 */
	public int queryActivityCommentByUserID(Object param);
	
	/**
	 * 获取评价最高的前十个单位
	 * @param param
	 * @return
	 */
	public List<VoteRankingVo> queryMaxCommentTopTen(Object param);
	
	/**
	 * 获取每项的评价汇总数据 评价总数，好评总数
	 * @param param
	 * @return
	 */
	public List<VoteRankingVo> queryCommentResultDetail(Object param);
}
