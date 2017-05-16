package io.renren.service;

import io.renren.entity.VoteActivityEntity;

import java.util.List;
import java.util.Map;

/**
 * 评价活动表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:18
 */
public interface VoteActivityService {
	
	VoteActivityEntity queryObject(Long id);
	
	List<VoteActivityEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(VoteActivityEntity voteActivity);
	
	void update(VoteActivityEntity voteActivity);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
