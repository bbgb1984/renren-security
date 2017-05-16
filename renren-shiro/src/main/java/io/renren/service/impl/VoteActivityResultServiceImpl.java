package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.VoteActivityResultDao;
import io.renren.entity.VoteActivityResultEntity;
import io.renren.service.VoteActivityResultService;



@Service("voteActivityResultService")
public class VoteActivityResultServiceImpl implements VoteActivityResultService {
	@Autowired
	private VoteActivityResultDao voteActivityResultDao;
	
	@Override
	public VoteActivityResultEntity queryObject(Long id){
		return voteActivityResultDao.queryObject(id);
	}
	
	@Override
	public List<VoteActivityResultEntity> queryList(Map<String, Object> map){
		return voteActivityResultDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return voteActivityResultDao.queryTotal(map);
	}
	
	@Override
	public void save(VoteActivityResultEntity voteActivityResult){
		voteActivityResultDao.save(voteActivityResult);
	}
	
	@Override
	public void update(VoteActivityResultEntity voteActivityResult){
		voteActivityResultDao.update(voteActivityResult);
	}
	
	@Override
	public void delete(Long id){
		voteActivityResultDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		voteActivityResultDao.deleteBatch(ids);
	}
	
}
