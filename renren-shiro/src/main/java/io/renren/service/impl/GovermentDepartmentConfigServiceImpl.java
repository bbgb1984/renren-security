package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.GovermentDepartmentConfigDao;
import io.renren.entity.GovermentDepartmentConfigEntity;
import io.renren.service.GovermentDepartmentConfigService;



@Service("govermentDepartmentConfigService")
public class GovermentDepartmentConfigServiceImpl implements GovermentDepartmentConfigService {
	@Autowired
	private GovermentDepartmentConfigDao govermentDepartmentConfigDao;
	
	@Override
	public GovermentDepartmentConfigEntity queryObject(Long id){
		return govermentDepartmentConfigDao.queryObject(id);
	}
	
	@Override
	public GovermentDepartmentConfigEntity queryObject(GovermentDepartmentConfigEntity entity){
		return govermentDepartmentConfigDao.queryObjectByName(entity);
	}
	
	@Override
	public List<GovermentDepartmentConfigEntity> queryList(Map<String, Object> map){
		return govermentDepartmentConfigDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return govermentDepartmentConfigDao.queryTotal(map);
	}
	
	@Override
	public void save(GovermentDepartmentConfigEntity govermentDepartmentConfig){
		govermentDepartmentConfigDao.save(govermentDepartmentConfig);
	}
	
	@Override
	public void update(GovermentDepartmentConfigEntity govermentDepartmentConfig){
		govermentDepartmentConfigDao.update(govermentDepartmentConfig);
	}
	
	@Override
	public void delete(Long id){
		govermentDepartmentConfigDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		govermentDepartmentConfigDao.deleteBatch(ids);
	}
	
}
