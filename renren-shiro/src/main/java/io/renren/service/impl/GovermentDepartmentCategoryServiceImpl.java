package io.renren.service.impl;

import io.renren.dao.GovermentDepartmentCategoryDao;
import io.renren.entity.GovermentDepartmentCategoryEntity;
import io.renren.service.GovermentDepartmentCategoryService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;



@Service("govermentDepartmentCategoryService")
public class GovermentDepartmentCategoryServiceImpl implements GovermentDepartmentCategoryService {
	@Autowired
	private GovermentDepartmentCategoryDao govermentDepartmentCategoryDao;
	
	@Override
	public GovermentDepartmentCategoryEntity queryObject(Long id){
		return govermentDepartmentCategoryDao.queryObject(id);
	}
	
	@Override
	public List<GovermentDepartmentCategoryEntity> queryList(Map<String, Object> map){
		return govermentDepartmentCategoryDao.queryList(map);
	}
	
	@Override
	@Cacheable(value="mycache",key="1")
	public List<GovermentDepartmentCategoryEntity> categorylist(){
		return govermentDepartmentCategoryDao.categorylist();
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return govermentDepartmentCategoryDao.queryTotal(map);
	}
	
	@Override
	@CacheEvict(value="mycache",key="1")
	public void save(GovermentDepartmentCategoryEntity govermentDepartmentCategory){
		govermentDepartmentCategoryDao.save(govermentDepartmentCategory);
	}
	
	@Override
	@CacheEvict(value="mycache",key="1")
	public void update(GovermentDepartmentCategoryEntity govermentDepartmentCategory){
		govermentDepartmentCategoryDao.update(govermentDepartmentCategory);
	}
	
	@Override
	@CacheEvict(value="mycache",key="1")
	public void delete(Long id){
		govermentDepartmentCategoryDao.delete(id);
	}
	
	@Override
	@CacheEvict(value="mycache",key="1")
	public void deleteBatch(Long[] ids){
		govermentDepartmentCategoryDao.deleteBatch(ids);
	}

	@Override
	public GovermentDepartmentCategoryEntity queryObject(
			GovermentDepartmentCategoryEntity govermentDepartmentCategory) {
		// TODO Auto-generated method stub
		return govermentDepartmentCategoryDao.queryObjectByName(govermentDepartmentCategory);
	}
	
}
