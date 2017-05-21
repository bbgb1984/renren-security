package io.renren.service;

import io.renren.entity.GovermentDepartmentCategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 政府部门设置
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:18
 */
public interface GovermentDepartmentCategoryService {
	
	GovermentDepartmentCategoryEntity queryObject(GovermentDepartmentCategoryEntity govermentDepartmentCategory);
	
	GovermentDepartmentCategoryEntity queryObject(Long id);
	
	List<GovermentDepartmentCategoryEntity> queryList(Map<String, Object> map);
	
	List<GovermentDepartmentCategoryEntity> categorylist();
	
	int queryTotal(Map<String, Object> map);
	
	void save(GovermentDepartmentCategoryEntity govermentDepartmentCategory);
	
	void update(GovermentDepartmentCategoryEntity govermentDepartmentCategory);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
