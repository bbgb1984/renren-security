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

import io.renren.entity.VoteActivityEntity;
import io.renren.service.VoteActivityService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 评价活动表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:18
 */
@RestController
@RequestMapping("voteactivity")
public class VoteActivityController  extends AbstractController {
	@Autowired
	private VoteActivityService voteActivityService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("voteactivity:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<VoteActivityEntity> voteActivityList = voteActivityService.queryList(query);
		int total = voteActivityService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(voteActivityList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("voteactivity:info")
	public R info(@PathVariable("id") Long id){
		VoteActivityEntity voteActivity = voteActivityService.queryObject(id);
		
		return R.ok().put("voteActivity", voteActivity);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("voteactivity:save")
	public R save(@RequestBody VoteActivityEntity voteActivity){
		voteActivityService.save(voteActivity);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("voteactivity:update")
	public R update(@RequestBody VoteActivityEntity voteActivity){
		voteActivityService.update(voteActivity);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("voteactivity:delete")
	public R delete(@RequestBody Long[] ids){
		voteActivityService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
