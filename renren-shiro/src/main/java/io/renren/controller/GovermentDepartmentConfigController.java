package io.renren.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.GovermentDepartmentCategoryEntity;
import io.renren.entity.GovermentDepartmentConfigEntity;
import io.renren.service.GovermentDepartmentConfigService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;
import io.renren.utils.RRException;


/**
 * 政府部门设置
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:17
 */
@RestController
@RequestMapping("govermentdepartmentconfig")
public class GovermentDepartmentConfigController  extends AbstractController {
	@Autowired
	private GovermentDepartmentConfigService govermentDepartmentConfigService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("govermentdepartmentconfig:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GovermentDepartmentConfigEntity> govermentDepartmentConfigList = govermentDepartmentConfigService.queryList(query);
		int total = govermentDepartmentConfigService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(govermentDepartmentConfigList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("govermentdepartmentconfig:info")
	public R info(@PathVariable("id") Long id){
		GovermentDepartmentConfigEntity govermentDepartmentConfig = govermentDepartmentConfigService.queryObject(id);
		
		return R.ok().put("govermentDepartmentConfig", govermentDepartmentConfig);
	}
	
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("govermentdepartmentconfig:save")
	public R save(@RequestBody GovermentDepartmentConfigEntity govermentDepartmentConfig){
		verifyForm(govermentDepartmentConfig);
		
		govermentDepartmentConfigService.save(govermentDepartmentConfig);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("govermentdepartmentconfig:update")
	public R update(@RequestBody GovermentDepartmentConfigEntity govermentDepartmentConfig){
		
		verifyForm(govermentDepartmentConfig);
		govermentDepartmentConfigService.update(govermentDepartmentConfig);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("govermentdepartmentconfig:delete")
	public R delete(@RequestBody Long[] ids){
		
		govermentDepartmentConfigService.deleteBatch(ids);
		
		return R.ok();
	}
	
	private void verifyForm (GovermentDepartmentConfigEntity govermentDepartmentConfig){
		if(StringUtils.isBlank(govermentDepartmentConfig.getName())){
			throw new RRException("单位名称不能为空");
		}
		GovermentDepartmentConfigEntity _entity=govermentDepartmentConfigService.queryObject(govermentDepartmentConfig);
		if(_entity!=null){
			throw new RRException("单位名称已存在");
		}
	}
	
}
