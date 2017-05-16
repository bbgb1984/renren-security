package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.VoteActivityDao;
import io.renren.entity.VoteActivityEntity;
import io.renren.service.VoteActivityService;



@Service("voteActivityService")
public class VoteActivityServiceImpl implements VoteActivityService {
	@Autowired
	private VoteActivityDao voteActivityDao;
	
	@Override
	public VoteActivityEntity queryObject(Long id){
		return voteActivityDao.queryObject(id);
	}
	
	@Override
	public List<VoteActivityEntity> queryList(Map<String, Object> map){
		return voteActivityDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return voteActivityDao.queryTotal(map);
	}
	
	@Override
	public void save(VoteActivityEntity voteActivity){
		voteActivityDao.save(voteActivity);
	}
	
	@Override
	public void update(VoteActivityEntity voteActivity){
		voteActivityDao.update(voteActivity);
	}
	
	@Override
	public void delete(Long id){
		voteActivityDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		voteActivityDao.deleteBatch(ids);
	}
	
}
