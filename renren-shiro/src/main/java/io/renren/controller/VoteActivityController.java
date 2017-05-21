package io.renren.controller;

import io.renren.entity.VoteActivityEntity;
import io.renren.enums.StatusEnum;
import io.renren.service.VoteActivityService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;
import io.renren.utils.RRException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
		
		validatetData(voteActivity,1);
		voteActivityService.save(voteActivity);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("voteactivity:update")
	public R update(@RequestBody VoteActivityEntity voteActivity){
		validatetData(voteActivity,2);

		voteActivityService.update(voteActivity);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("voteactivity:delete")
	public R delete(@RequestBody Long[] ids,HttpServletRequest request){
		if(StringUtils.equals("1", request.getParameter("flag"))){
			voteActivityService.startBatch(ids);
		}else{
			voteActivityService.stopBatch(ids);
		}
		
		return R.ok();
	}
	
	/**
	 * @param entity
	 */
	private void validatetData(VoteActivityEntity entity,int flag){
		if (flag == 1) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("1", "1");
			Query query = new Query(params);
			List<VoteActivityEntity> voteActivityList = voteActivityService
					.queryList(query);
			if (voteActivityList != null && voteActivityList.size() > 0) {
				for (VoteActivityEntity e : voteActivityList) {
					if (StringUtils.equals(StatusEnum.ING.getName(),
							e.getStatus())) {
						throw new RRException("评价活动只能创建一个");
					}
				}
			}
		}
		if(StringUtils.isBlank(entity.getVoteName())){
			throw new RRException("评价活动名称不能为空");
		}
		if(StringUtils.length(entity.getVoteName())>50){
			throw new RRException("评价活动名称不能超过50个汉字");
		}
		if(StringUtils.isBlank(entity.getVoteDesc())){
			throw new RRException("评价活动描述不能为空");
		}
		if(StringUtils.length(entity.getVoteDesc())>200){
			throw new RRException("评价活动描述不能超过200个汉字");
		}
		if(StringUtils.isBlank(entity.getBeginTime())){
			throw new RRException("开始时间不能为空");
		}
		if(StringUtils.isBlank(entity.getEndTime())){
			String startTime=entity.getBeginTime();
			entity.setEndTime(startTime.substring(0,4)+"-12-31 23:59:59");
		}else{
			entity.setEndTime(entity.getEndTime()+" 23:59:59");
		}
		int maxNum;
		try{
			maxNum=Integer.parseInt(entity.getMaxNum());
		}catch(Exception e){
			throw new RRException("评价单位个数必须为数字");
		}
		if(StringUtils.isBlank(entity.getMaxNum())){
			throw new RRException("评价单位个数必须大于0");
		}
		if(maxNum<1){
			throw new RRException("评价单位个数必须大于0");
		}
	}
	
	public static void main(String[] args) {
		String startTime="2017-12-01";
		
		System.out.println(startTime.substring(0,4)+"-12-31 23:59:59");
	}
}
