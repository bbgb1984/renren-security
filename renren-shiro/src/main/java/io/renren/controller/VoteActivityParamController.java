package io.renren.controller;

import io.renren.entity.VoteActivityParamEntity;
import io.renren.service.VoteActivityParamService;
import io.renren.utils.R;
import io.renren.utils.RRException;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
	@RequestMapping("/list/{id}")
	@RequiresAuthentication
	public R list(@PathVariable("id") Long id){
		//查询列表数据

		List<VoteActivityParamEntity> voteActivityParamList = voteActivityParamService.queryList(id);
		
		
		return R.ok().put("list", voteActivityParamList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresAuthentication
	public R info(@PathVariable("id") Long id){
		VoteActivityParamEntity voteActivityParam = voteActivityParamService.queryObject(id);
		
		return R.ok().put("voteActivityParam", voteActivityParam);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresAuthentication
	public R save(@RequestBody VoteActivityParamEntity[] voteActivityParam){
		validateDate(voteActivityParam);
		voteActivityParamService.save(voteActivityParam);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresAuthentication
	public R update(@RequestBody VoteActivityParamEntity voteActivityParam){
		voteActivityParamService.update(voteActivityParam);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete/{id}")
	@RequiresAuthentication
	public R delete(@PathVariable("id") Long id){
		voteActivityParamService.delete(id);
		
		return R.ok();
	}
	
	private void validateDate(VoteActivityParamEntity[] entityLst){
		if(entityLst==null){
			throw new RRException("请添加评级选项");
		}
		for(int i=0,len=entityLst.length;i<len;i++){
			if(StringUtils.isBlank(entityLst[i].getParamName())){
				throw new RRException("评级选项不能为空！");
			}
			if(StringUtils.isBlank(entityLst[i].getVoteActivityId()+"")){
				throw new RRException("数据异常，请刷新页面重试！");
			}
		}
		
	}
}
