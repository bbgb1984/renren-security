package io.renren.dao;

import io.renren.entity.VoteActivityEntity;

/**
 * 评价活动表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:18
 */
public interface VoteActivityDao extends BaseDao<VoteActivityEntity> {
	
	VoteActivityEntity queryActiveObject(Object id);

	public void sumExploreNum(Long id);
}
