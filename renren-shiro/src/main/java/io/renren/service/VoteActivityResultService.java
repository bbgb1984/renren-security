package io.renren.service;

import io.renren.entity.VoteActivityResultEntity;
import io.renren.entity.VoteRankingVo;

import java.util.List;
import java.util.Map;

/**
 * 评价活动投票结果
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:17
 */
public interface VoteActivityResultService {
	
	VoteActivityResultEntity queryObject(Long id);
	
	List<VoteActivityResultEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	int queryCommentNumById(Object id);
	
	
	List<VoteRankingVo> queryCommentTopTen(Object param);
	
	/**
	 * 获取指定活动 所有单位的好评总数
	 * @param param
	 * @return
	 */
	List<VoteRankingVo> queryHighCommentRateTopTen(Object param);
	
	/**
	 * 获取每项的评价汇总数据 评价总数，好评总数
	 * @param param
	 * @return
	 */
	List<VoteRankingVo> queryCommentResultDetail(Object param);
	
	/**
	 * 获取评价最高的前十个单位
	 * @param param
	 * @return
	 */
	List<VoteRankingVo> queryMaxCommentTopTen(Object param);
	
	void save(VoteActivityResultEntity voteActivityResult);
	
	void saveBatch(List<VoteActivityResultEntity> voteActivityResult);
	
	void update(VoteActivityResultEntity voteActivityResult);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
	
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
	
	
}
