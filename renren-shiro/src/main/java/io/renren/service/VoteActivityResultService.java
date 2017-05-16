package io.renren.service;

import io.renren.entity.VoteActivityResultEntity;

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
	
	void save(VoteActivityResultEntity voteActivityResult);
	
	void update(VoteActivityResultEntity voteActivityResult);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
