package io.renren.controller;

import io.renren.entity.GovermentDepartmentCategoryEntity;
import io.renren.service.GovermentDepartmentCategoryService;
import io.renren.utils.Constant;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;
import io.renren.utils.RRException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

/**
 * 政府部门设置
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:18
 */
@RestController
@RequestMapping("govermentdepartmentcategory")
public class GovermentDepartmentCategoryController extends AbstractController {
	@Autowired
	private GovermentDepartmentCategoryService govermentDepartmentCategoryService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("govermentdepartmentcategory:list")
	public R list(@RequestParam Map<String, Object> params) {

		// 只有超级管理员，才能查看所有管理员列表
		if (getUserId() != Constant.SUPER_ADMIN) {
			params.put("createUserId", getUserId());
		}
		// 查询列表数据
		Query query = new Query(params);

		List<GovermentDepartmentCategoryEntity> govermentDepartmentCategoryList = govermentDepartmentCategoryService
				.queryList(query);
		int total = govermentDepartmentCategoryService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(govermentDepartmentCategoryList,
				total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 列表
	 */
	@RequestMapping("/categorylist")
	@RequiresAuthentication 
	public R categorylist() {
		
		List<GovermentDepartmentCategoryEntity> govermentDepartmentCategoryList = govermentDepartmentCategoryService
				.categorylist();
		String json=JSON.toJSONString(govermentDepartmentCategoryList);
		System.out.println(json);
		return R.ok().put("list", govermentDepartmentCategoryList);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("govermentdepartmentcategory:info")
	public R info(@PathVariable("id") Long id) {
		GovermentDepartmentCategoryEntity govermentDepartmentCategory = govermentDepartmentCategoryService
				.queryObject(id);

		return R.ok().put("govermentDepartmentCategory",
				govermentDepartmentCategory);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("govermentdepartmentcategory:save")
	public R save(
			@RequestBody GovermentDepartmentCategoryEntity govermentDepartmentCategory) {
		verifyForm(govermentDepartmentCategory);
		govermentDepartmentCategoryService.save(govermentDepartmentCategory);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("govermentdepartmentcategory:update")
	public R update(
			@RequestBody GovermentDepartmentCategoryEntity govermentDepartmentCategory) {
		
		verifyForm(govermentDepartmentCategory);
		
		govermentDepartmentCategoryService.update(govermentDepartmentCategory);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("govermentdepartmentcategory:delete")
	public R delete(@RequestBody Long[] ids) {
		govermentDepartmentCategoryService.deleteBatch(ids);

		return R.ok();
	}

	private void verifyForm (GovermentDepartmentCategoryEntity govermentDepartmentCategory){
		if(StringUtils.isBlank(govermentDepartmentCategory.getCategoryName())){
			throw new RRException("单位类别不能为空");
		}
		GovermentDepartmentCategoryEntity _entity=govermentDepartmentCategoryService.queryObject(govermentDepartmentCategory);
		if(_entity!=null){
			throw new RRException("单位类别已存在");
		}
	}
}
