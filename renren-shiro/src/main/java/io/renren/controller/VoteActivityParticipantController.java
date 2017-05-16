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

import io.renren.entity.VoteActivityParticipantEntity;
import io.renren.service.VoteActivityParticipantService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 评价活动参与单位
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:16
 */
@RestController
@RequestMapping("voteactivityparticipant")
public class VoteActivityParticipantController  extends AbstractController {
	@Autowired
	private VoteActivityParticipantService voteActivityParticipantService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("voteactivityparticipant:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<VoteActivityParticipantEntity> voteActivityParticipantList = voteActivityParticipantService.queryList(query);
		int total = voteActivityParticipantService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(voteActivityParticipantList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("voteactivityparticipant:info")
	public R info(@PathVariable("id") Long id){
		VoteActivityParticipantEntity voteActivityParticipant = voteActivityParticipantService.queryObject(id);
		
		return R.ok().put("voteActivityParticipant", voteActivityParticipant);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("voteactivityparticipant:save")
	public R save(@RequestBody VoteActivityParticipantEntity voteActivityParticipant){
		voteActivityParticipantService.save(voteActivityParticipant);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("voteactivityparticipant:update")
	public R update(@RequestBody VoteActivityParticipantEntity voteActivityParticipant){
		voteActivityParticipantService.update(voteActivityParticipant);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("voteactivityparticipant:delete")
	public R delete(@RequestBody Long[] ids){
		voteActivityParticipantService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
