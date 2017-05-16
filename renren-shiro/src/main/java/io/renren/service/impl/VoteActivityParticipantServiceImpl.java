package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.VoteActivityParticipantDao;
import io.renren.entity.VoteActivityParticipantEntity;
import io.renren.service.VoteActivityParticipantService;



@Service("voteActivityParticipantService")
public class VoteActivityParticipantServiceImpl implements VoteActivityParticipantService {
	@Autowired
	private VoteActivityParticipantDao voteActivityParticipantDao;
	
	@Override
	public VoteActivityParticipantEntity queryObject(Long id){
		return voteActivityParticipantDao.queryObject(id);
	}
	
	@Override
	public List<VoteActivityParticipantEntity> queryList(Map<String, Object> map){
		return voteActivityParticipantDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return voteActivityParticipantDao.queryTotal(map);
	}
	
	@Override
	public void save(VoteActivityParticipantEntity voteActivityParticipant){
		voteActivityParticipantDao.save(voteActivityParticipant);
	}
	
	@Override
	public void update(VoteActivityParticipantEntity voteActivityParticipant){
		voteActivityParticipantDao.update(voteActivityParticipant);
	}
	
	@Override
	public void delete(Long id){
		voteActivityParticipantDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		voteActivityParticipantDao.deleteBatch(ids);
	}
	
}
