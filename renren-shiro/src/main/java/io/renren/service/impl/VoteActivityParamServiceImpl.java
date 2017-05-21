package io.renren.service.impl;

import io.renren.dao.VoteActivityParamDao;
import io.renren.entity.VoteActivityParamEntity;
import io.renren.service.VoteActivityParamService;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("voteActivityParamService")
public class VoteActivityParamServiceImpl implements VoteActivityParamService {
	@Autowired
	private VoteActivityParamDao voteActivityParamDao;
	
	@Override
	public VoteActivityParamEntity queryObject(Long id){
		return voteActivityParamDao.queryObject(id);
	}
	
	@Override
	public List<VoteActivityParamEntity> queryList(Long id){
		VoteActivityParamEntity vo=new VoteActivityParamEntity();
		vo.setId(id);
		return voteActivityParamDao.queryList(vo);
	}
	
	@Override
	public List<VoteActivityParamEntity> queryObjectByActivityId(Object id){
		return voteActivityParamDao.queryObjectByActivityId(id);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return voteActivityParamDao.queryTotal(map);
	}
	
	@Override
	@Transactional
	public void save(VoteActivityParamEntity[] voteActivityParam){
		for(int i=0,len=voteActivityParam.length;i<len;i++){
			if(StringUtils.isBlank(voteActivityParam[i].getId()+"")||StringUtils.equals("null", voteActivityParam[i].getId()+"")){//新增
				voteActivityParamDao.save(voteActivityParam[i]);
			}else{
				voteActivityParamDao.update(voteActivityParam[i]);
			}
		}
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
