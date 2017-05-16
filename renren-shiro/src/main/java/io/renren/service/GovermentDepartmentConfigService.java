package io.renren.service;

import io.renren.entity.GovermentDepartmentConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * 政府部门设置
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:17
 */
public interface GovermentDepartmentConfigService {
	
	GovermentDepartmentConfigEntity queryObject(GovermentDepartmentConfigEntity entity);
	
	GovermentDepartmentConfigEntity queryObject(Long id);
	
	List<GovermentDepartmentConfigEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GovermentDepartmentConfigEntity govermentDepartmentConfig);
	
	void update(GovermentDepartmentConfigEntity govermentDepartmentConfig);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
