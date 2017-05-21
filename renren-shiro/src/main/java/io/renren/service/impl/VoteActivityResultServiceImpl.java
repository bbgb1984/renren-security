package io.renren.service.impl;

import io.renren.dao.VoteActivityResultDao;
import io.renren.entity.VoteActivityResultEntity;
import io.renren.entity.VoteRankingVo;
import io.renren.service.VoteActivityResultService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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

	@Override
	public int queryCommentNumById(Object id) {
		return voteActivityResultDao.queryCommentNumById(id);
	}

	@Override
	public void saveBatch(List<VoteActivityResultEntity> voteActivityResult) {
		// TODO Auto-generated method stub
		voteActivityResultDao.saveBatch(voteActivityResult);
	}

	@Override
	public List<VoteRankingVo> queryCommentTopTen(Object param) {
		// TODO Auto-generated method stub
		return voteActivityResultDao.queryCommentTopTen(param);
	}

	@Override
	public List<VoteRankingVo> queryHighCommentRateTopTen(
			Object param) {
		// TODO Auto-generated method stub
		return voteActivityResultDao.queryHighCommentRateTopTen(param);
	}

	@Override
	public int queryCommentDepartsNum(Object param) {
		// TODO Auto-generated method stub
		return voteActivityResultDao.queryCommentDepartsNum(param);
	}

	@Override
	public int queryActivityCommentByUserID(Object param) {
		// TODO Auto-generated method stub
		return voteActivityResultDao.queryActivityCommentByUserID(param);
	}

	@Override
	public List<VoteRankingVo> queryMaxCommentTopTen(Object param) {
		return voteActivityResultDao.queryMaxCommentTopTen(param);
	}

	@Override
	public List<VoteRankingVo> queryCommentResultDetail(Object param) {
		// TODO Auto-generated method stub
		return voteActivityResultDao.queryCommentResultDetail(param);
	}

}
