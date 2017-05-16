package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.VoteActivityParamDao;
import io.renren.entity.VoteActivityParamEntity;
import io.renren.service.VoteActivityParamService;



@Service("voteActivityParamService")
public class VoteActivityParamServiceImpl implements VoteActivityParamService {
	@Autowired
	private VoteActivityParamDao voteActivityParamDao;
	
	@Override
	public VoteActivityParamEntity queryObject(Long id){
		return voteActivityParamDao.queryObject(id);
	}
	
	@Override
	public List<VoteActivityParamEntity> queryList(Map<String, Object> map){
		return voteActivityParamDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return voteActivityParamDao.queryTotal(map);
	}
	
	@Override
	public void save(VoteActivityParamEntity voteActivityParam){
		voteActivityParamDao.save(voteActivityParam);
	}
	
	@Override
	public void update(VoteActivityParamEntity voteActivityParam){
		voteActivityParamDao.update(voteActivityParam);
	}
	
	@Override
	public void delete(Long id){
		voteActivityParamDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		voteActivityParamDao.deleteBatch(ids);
	}
	
}
