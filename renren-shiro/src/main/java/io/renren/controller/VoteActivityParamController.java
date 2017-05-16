package io.renren.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.VoteActivityParamEntity;
import io.renren.service.VoteActivityParamService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 评价活动选项表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:18
 */
@RestController
@RequestMapping("voteactivityparam")
public class VoteActivityParamController  extends AbstractController {
	@Autowired
	private VoteActivityParamService voteActivityParamService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("voteactivityparam:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<VoteActivityParamEntity> voteActivityParamList = voteActivityParamService.queryList(query);
		int total = voteActivityParamService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(voteActivityParamList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("voteactivityparam:info")
	public R info(@PathVariable("id") Long id){
		VoteActivityParamEntity voteActivityParam = voteActivityParamService.queryObject(id);
		
		return R.ok().put("voteActivityParam", voteActivityParam);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("voteactivityparam:save")
	public R save(@RequestBody VoteActivityParamEntity voteActivityParam){
		voteActivityParamService.save(voteActivityParam);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("voteactivityparam:update")
	public R update(@RequestBody VoteActivityParamEntity voteActivityParam){
		voteActivityParamService.update(voteActivityParam);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("voteactivityparam:delete")
	public R delete(@RequestBody Long[] ids){
		voteActivityParamService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
