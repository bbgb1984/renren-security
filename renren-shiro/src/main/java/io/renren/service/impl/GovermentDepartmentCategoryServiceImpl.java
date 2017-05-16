package io.renren.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.GovermentDepartmentCategoryDao;
import io.renren.entity.GovermentDepartmentCategoryEntity;
import io.renren.service.GovermentDepartmentCategoryService;
import io.renren.utils.RRException;



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
	public int queryTotal(Map<String, Object> map){
		return govermentDepartmentCategoryDao.queryTotal(map);
	}
	
	@Override
	public void save(GovermentDepartmentCategoryEntity govermentDepartmentCategory){
		govermentDepartmentCategoryDao.save(govermentDepartmentCategory);
	}
	
	@Override
	public void update(GovermentDepartmentCategoryEntity govermentDepartmentCategory){
		govermentDepartmentCategoryDao.update(govermentDepartmentCategory);
	}
	
	@Override
	public void delete(Long id){
		govermentDepartmentCategoryDao.delete(id);
	}
	
	@Override
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
