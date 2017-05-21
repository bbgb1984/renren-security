package io.renren.dao;

import java.util.List;

import io.renren.entity.GovermentDepartmentConfigEntity;

/**
 * 政府部门设置
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:17
 */
public interface GovermentDepartmentConfigDao extends BaseDao<GovermentDepartmentConfigEntity> {
	List<GovermentDepartmentConfigEntity> queryAllList(Object searchName);
}
