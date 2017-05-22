package io.renren.controller;

import io.renren.entity.VoteActivityEntity;
import io.renren.entity.VoteActivityResultEntity;
import io.renren.service.VoteActivityResultService;
import io.renren.service.VoteActivityService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评价活动投票结果
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-16 20:56:17
 */
@RestController
@RequestMapping("voteactivityresult")
public class VoteActivityResultController extends AbstractController {

	@Autowired
	private VoteActivityResultService voteActivityResultService;

	@Autowired
	private VoteActivityService voteActivityService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresAuthentication
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<VoteActivityResultEntity> voteActivityResultList = voteActivityResultService
				.queryList(query);
		int total = voteActivityResultService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(voteActivityResultList, total,
				query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresAuthentication
	public R info(@PathVariable("id") Long id) {
		VoteActivityResultEntity voteActivityResult = voteActivityResultService
				.queryObject(id);

		return R.ok().put("voteActivityResult", voteActivityResult);
	}

	/**
	 * 保存
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/save")
	public R save(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		List<VoteActivityResultEntity> lst = new ArrayList<VoteActivityResultEntity>();
		Object userId = request.getSession().getAttribute("userId");
		String id = StringUtils.trimToEmpty(request.getParameter("id1"));// 当前活动的id
		if (userId != null) {
			String departId = StringUtils.trimToEmpty(request
					.getParameter("departId"));// 单位id
			String result=validateData(userId.toString(),id,departId);
			if(!StringUtils.equals("ok", result)){
				return R.error(result);
			}
			Enumeration<String> e = request.getParameterNames();
			String suggestion = StringUtils.trimToEmpty(request
					.getParameter("suggestion"));// 单位id
			while (e.hasMoreElements()) {
				String ele = e.nextElement();
				try {
					Long eKey = Long.parseLong(ele);// param
													// key为数字时说明是评论参数（建议除外）
					String eVal = request.getParameter(ele);
					VoteActivityResultEntity voteActivityResult = new VoteActivityResultEntity();
					voteActivityResult.setDepartId(Long.parseLong(departId));
					voteActivityResult.setUserId(0L);
					voteActivityResult.setVoteActivityId(Long.parseLong(id));
					voteActivityResult.setVoteActivityParamId(eKey);
					voteActivityResult.setVoteActivityParamVal(eVal);
					voteActivityResult.setUserId(Long.parseLong(userId
							.toString()));
					;
					voteActivityResult.setCommentDesc(suggestion);
					lst.add(voteActivityResult);
				} catch (NumberFormatException ex) {

				}
			}
			if (lst.size() > 0) {
				try {
					voteActivityResultService.saveBatch(lst);
					return R.ok();
				} catch (Exception exception) {
					return R.error();
				}
			}
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresAuthentication
	public R update(@RequestBody VoteActivityResultEntity voteActivityResult) {
		voteActivityResultService.update(voteActivityResult);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresAuthentication
	public R delete(@RequestBody Long[] ids) {
		voteActivityResultService.deleteBatch(ids);

		return R.ok();
	}

	private String validateData(String userId, String activityId,
			String departId) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("userId", userId);
		param.put("activityId", activityId);
		param.put("departId", departId);
		int isComment = voteActivityResultService
				.queryActivityCommentByUserID(param);
		if (isComment > 0) {
			return "评价失败,该单位您已经评价过，不能重复评价";// 已评价
		}
		int totalCommentDepart = voteActivityResultService
				.queryCommentDepartsNum(param);
		VoteActivityEntity vo = voteActivityService.queryObject(Long
				.parseLong(activityId));
		if (vo != null) {
			String max = vo.getMaxNum();
			if (totalCommentDepart >= Integer.parseInt(max)) {
				return "评价失败，当前活动个人最多可评价"+max+"家单位！";//超出最多评价个数
			}
		}else{
			return "系统数据错误，请联系管理员！";
		}
		return "ok";
	}
}
