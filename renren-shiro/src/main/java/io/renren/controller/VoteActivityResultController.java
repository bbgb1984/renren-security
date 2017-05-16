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

import io.renren.entity.VoteActivityResultEntity;
import io.renren.service.VoteActivityResultService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 评价活动投票结果
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:17
 */
@RestController
@RequestMapping("voteactivityresult")
public class VoteActivityResultController  extends AbstractController {
	@Autowired
	private VoteActivityResultService voteActivityResultService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("voteactivityresult:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<VoteActivityResultEntity> voteActivityResultList = voteActivityResultService.queryList(query);
		int total = voteActivityResultService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(voteActivityResultList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("voteactivityresult:info")
	public R info(@PathVariable("id") Long id){
		VoteActivityResultEntity voteActivityResult = voteActivityResultService.queryObject(id);
		
		return R.ok().put("voteActivityResult", voteActivityResult);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("voteactivityresult:save")
	public R save(@RequestBody VoteActivityResultEntity voteActivityResult){
		voteActivityResultService.save(voteActivityResult);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("voteactivityresult:update")
	public R update(@RequestBody VoteActivityResultEntity voteActivityResult){
		voteActivityResultService.update(voteActivityResult);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("voteactivityresult:delete")
	public R delete(@RequestBody Long[] ids){
		voteActivityResultService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
