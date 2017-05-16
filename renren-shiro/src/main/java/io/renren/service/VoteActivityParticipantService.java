package io.renren.service;

import io.renren.entity.VoteActivityParticipantEntity;

import java.util.List;
import java.util.Map;

/**
 * 评价活动参与单位
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:16
 */
public interface VoteActivityParticipantService {
	
	VoteActivityParticipantEntity queryObject(Long id);
	
	List<VoteActivityParticipantEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(VoteActivityParticipantEntity voteActivityParticipant);
	
	void update(VoteActivityParticipantEntity voteActivityParticipant);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
