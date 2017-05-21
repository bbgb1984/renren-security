package io.renren.service;

import io.renren.entity.VoteActivityParamEntity;

import java.util.List;
import java.util.Map;

/**
 * 评价活动选项表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:18
 */
public interface VoteActivityParamService {
	
	VoteActivityParamEntity queryObject(Long id);
	
	List<VoteActivityParamEntity> queryList(Long id);
	
	List<VoteActivityParamEntity> queryObjectByActivityId(Object id);
	
	int queryTotal(Map<String, Object> map);
	
	void save(VoteActivityParamEntity[] voteActivityParam);
	
	void update(VoteActivityParamEntity voteActivityParam);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
