package io.renren.controller;

import io.renren.entity.GovermentDepartmentCategoryEntity;
import io.renren.entity.GovermentDepartmentConfigEntity;
import io.renren.entity.VoteActivityEntity;
import io.renren.entity.VoteActivityParamEntity;
import io.renren.entity.VoteRankingVo;
import io.renren.service.GovermentDepartmentCategoryService;
import io.renren.service.GovermentDepartmentConfigService;
import io.renren.service.VoteActivityParamService;
import io.renren.service.VoteActivityParticipantService;
import io.renren.service.VoteActivityResultService;
import io.renren.service.VoteActivityService;
import io.renren.utils.Constant;
import io.renren.utils.GuavaCacheUtils;
import io.renren.utils.R;
import io.renren.utils.RRException;
import io.renren.utils.ShiroUtils;
import io.renren.utils.ZxingHandler;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Controller
public class VoteIndexController extends AbstractController {

	@Autowired
	private GovermentDepartmentCategoryService govermentDepartmentCategoryService;

	@Autowired
	private GovermentDepartmentConfigService govermentDepartmentConfigService;

	@Autowired
	private VoteActivityParticipantService voteActivityParticipantService;

	@Autowired
	private VoteActivityParamService voteActivityParamService;

	@Autowired
	private VoteActivityService voteActivityService;

	@Autowired
	private VoteActivityResultService voteActivityResultService;

	@RequestMapping(value = "/activity_index", method = RequestMethod.GET)
	public String activity_index(HttpServletResponse response,
			HttpServletRequest request, ModelMap map) throws ServletException,
			IOException {
		String id = StringUtils.trimToEmpty(request.getParameter("id"));
		String searchName = StringUtils.trimToEmpty(request
				.getParameter("searchName"));
		String categoryId = StringUtils.trimToEmpty(request
				.getParameter("categoryId"));// 单位分类
		String flag = StringUtils.trimToEmpty(request.getParameter("flag"));// 评价结果
																			// 1成功；0
																			// 失败
		// 查询活动信息-活动名称 活动描述 浏览量 等
		VoteActivityEntity voteActivityEntity = voteActivityService
				.queryActiveObject(id);
		if (voteActivityEntity == null) {
			throw new RRException("当前没有正在进行中评价活动！");
		}
		// 查询活动评价人数
		int totalCommentNum = voteActivityResultService
				.queryCommentNumById(voteActivityEntity.getId());
		// 查看所有的单位信息
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", searchName);
		param.put("type", categoryId);
		List<GovermentDepartmentConfigEntity> queryAllDepartList = govermentDepartmentConfigService
				.queryAllList(param);
		// 查看所有的单位信息
		Map<String, Object> param2 = new HashMap<String, Object>();
		List<GovermentDepartmentConfigEntity> queryAllDepartList2 = govermentDepartmentConfigService
				.queryAllList(param2);
		// 获得所有的单位类别
		List<GovermentDepartmentCategoryEntity> categoryList = govermentDepartmentCategoryService
				.categorylist();

		List<VoteActivityParamEntity> paramList = voteActivityParamService
				.queryObjectByActivityId(voteActivityEntity.getId());

		voteActivityService.sumExploreNum(voteActivityEntity.getId());// 統計瀏覽量

		map.put("voteActivityEntity", voteActivityEntity);
		map.put("totalCommentNum", totalCommentNum);
		map.put("queryAllList", queryAllDepartList);
		map.put("departNum", queryAllDepartList2.size());
		map.put("categoryList", categoryList);
		map.put("paramList", paramList);
		map.put("id", voteActivityEntity.getId());
		map.put("flag", flag);
		map.put("searchName", searchName);

		return "sys/activity_index.jsp";
	}

	@RequestMapping(value = "/activity_ranking", method = RequestMethod.GET)
	public String activity_ranking(HttpServletResponse response,
			HttpServletRequest request, ModelMap map) throws ServletException,
			IOException {
		String id = StringUtils.trimToEmpty(request.getParameter("id"));
		if (StringUtils.isBlank(id)) {
			throw new RRException("数据异常！");
		}
		// 单位评价次数排行
		List<VoteRankingVo> commentTopTen = voteActivityResultService
				.queryCommentTopTen(id);
		map.put("commentTopTen", commentTopTen);

		// 单位好评排行
		List<VoteRankingVo> highRateTopTen = voteActivityResultService
				.queryHighCommentRateTopTen(id);
		map.put("highRateTopTen", highRateTopTen);

		List<VoteActivityParamEntity> paramList = voteActivityParamService
				.queryObjectByActivityId(id);
		List<VoteRankingVo> maxCommentTopTen = voteActivityResultService
				.queryMaxCommentTopTen(id);

		Map<String, String> maxCommentTopTenMap = new HashMap<String, String>();// 单位总评价数
		Map<String, List<VoteRankingVo>> departResultLst = new HashMap<String, List<VoteRankingVo>>();
		Map<String, String> param = new HashMap<String, String>();
		param.put("activityId", id);

		List<String[]> resultLst = new ArrayList<String[]>();
		// 汇总单位每项评价个数和好评率
		if (maxCommentTopTen != null) {
			for (int i = 0, len = maxCommentTopTen.size(); i < len; i++) {
				String[] details = new String[paramList.size() + 2];
				VoteRankingVo vo = maxCommentTopTen.get(i);
				details[0] = vo.getDepartName();
				details[1] = vo.getCommentNum() + "";
				maxCommentTopTenMap.put(vo.getDepartId() + "",
						vo.getCommentNum() + "");
				param.put("departId", vo.getDepartId());
				List<VoteRankingVo> resultList = voteActivityResultService
						.queryCommentResultDetail(param);
				Map<String, String> _map = listToMap(resultList);
				int count = 2;
				for (VoteActivityParamEntity v : paramList) {
					if (_map.containsKey(v.getParamName())) {
						details[count++] = _map.get(v.getParamName());
					} else {
						details[count++] = "";
					}
				}
				resultLst.add(details);
			}
		}
		map.put("resultList", resultLst);
		System.out.println(JSON.toJSON(departResultLst));
		//
		// Iterator<String> iter=departResultLst.keySet().iterator();
		// while(iter.hasNext()){
		// String[] details=new String[paramList.size()];
		// String key=iter.next();
		// List<VoteRankingVo> lst=departResultLst.get(key);
		// for()
		// }

		map.put("id", id);
		map.put("paramList", paramList);
		return "sys/activity_ranking.jsp";
	}

	@RequestMapping(value = "/highRateTopTen", method = RequestMethod.GET)
	public @ResponseBody String highRateTopTen(HttpServletResponse response,
			HttpServletRequest request, ModelMap map) throws ServletException,
			IOException {
		String id = StringUtils.trimToEmpty(request.getParameter("id"));
		if (StringUtils.isBlank(id)) {
			throw new RRException("数据异常！");
		}
		// 单位好评排行
		List<VoteRankingVo> highRateTopTen = voteActivityResultService
				.queryHighCommentRateTopTen(id);
		List<String> highRateTopTen_title = new ArrayList<String>();
		List<String> highRateTopTen_data = new ArrayList<String>();
		if (highRateTopTen != null) {
			for (int i = 0, len = highRateTopTen.size(); i < len; i++) {
				VoteRankingVo vo = highRateTopTen.get(i);
				highRateTopTen_title.add(vo.getDepartName());
				highRateTopTen_data.add(vo.getTotalRate() + "");
			}
		}

		map.put("highRateTopTen_title", highRateTopTen_title);
		map.put("highRateTopTen_data", highRateTopTen_data);

		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/commentTopTen", method = RequestMethod.GET)
	public @ResponseBody String commentTopTen(HttpServletResponse response,
			HttpServletRequest request, ModelMap map) throws ServletException,
			IOException {
		String id = StringUtils.trimToEmpty(request.getParameter("id"));
		if (StringUtils.isBlank(id)) {
			throw new RRException("数据异常！");
		}
		// 单位评价次数排行
		List<VoteRankingVo> commentTopTen = voteActivityResultService
				.queryCommentTopTen(id);
		List<String> title = new ArrayList<String>();
		List<Integer> data = new ArrayList<Integer>();
		if (commentTopTen != null) {
			for (int i = 0, len = commentTopTen.size(); i < len; i++) {
				VoteRankingVo vo = commentTopTen.get(i);
				title.add(vo.getDepartName());
				data.add(vo.getCommentNum());
			}
		}
		map.put("commentTopTen_title", title);
		map.put("commentTopTen_data", data);

		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/queryCommentResultDetail", method = RequestMethod.GET)
	public @ResponseBody String queryCommentResultDetail(
			HttpServletResponse response, HttpServletRequest request,
			ModelMap map) throws ServletException, IOException {
		String id = StringUtils.trimToEmpty(request.getParameter("id"));
		if (StringUtils.isBlank(id)) {
			throw new RRException("数据异常！");
		}
		Map<String, String> param = new HashMap<String, String>();
		param.put("activityId", id);

		// 单位好评排行
		// 获取评价总数前十
		List<VoteRankingVo> maxCommentTopTen = voteActivityResultService
				.queryMaxCommentTopTen(id);
		Map<String, String> maxCommentTopTenMap = new HashMap<String, String>();// 单位总评价数
		Map<String, List<VoteRankingVo>> departResultLst = new HashMap<String, List<VoteRankingVo>>();
		Map<String, List<VoteRankingVo>> departNameResultLst = new HashMap<String, List<VoteRankingVo>>();
		// 汇总单位每项评价个数和好评率
		if (maxCommentTopTen != null) {
			for (int i = 0, len = maxCommentTopTen.size(); i < len; i++) {
				VoteRankingVo vo = maxCommentTopTen.get(i);
				maxCommentTopTenMap.put(vo.getDepartId() + "",
						vo.getCommentNum() + "");
				param.put("departId", vo.getDepartId());
				List<VoteRankingVo> paramList = voteActivityResultService
						.queryCommentResultDetail(param);
				departResultLst.put(vo.getDepartId() + "", paramList);
				departNameResultLst.put(vo.getDepartName() + "", paramList);
			}
		}
		// 活动参数
		List<String> legend = new ArrayList<String>();// 活动所有的参数
		Set<String> departLst = new HashSet<String>();// 部门名称
		Map<String, List<String>> paramMap = new HashMap<String, List<String>>();
		List<VoteActivityParamEntity> paramList = voteActivityParamService
				.queryObjectByActivityId(id);
		for (int i = 0, len = paramList.size(); i < len; i++) {// 组装每项，每个单位的好评率
			VoteActivityParamEntity vo = paramList.get(i);
			String paramName = vo.getParamName();
			legend.add(vo.getParamName());
			List<String> paramVal = new ArrayList<String>();
			for (int j = 0, jlen = maxCommentTopTen.size(); j < jlen; j++) {// 统计每个单位每个项的值
				VoteRankingVo _vo = maxCommentTopTen.get(j);
				List<VoteRankingVo> l = departResultLst.get(_vo.getDepartId());
				for (int x = 0, xlen = l.size(); x < xlen; x++) {
					if (paramName.equals(l.get(x).getParamName())) {
						departLst.add(_vo.getDepartName());
						paramVal.add(l.get(x).getTotalRate() + "");
						break;
					}
				}
			}
			paramMap.put(vo.getParamName() + "", paramVal);
		}

		map.put("legend", legend);
		map.put("departLst", departLst);
		map.put("result", paramMap);
		map.put("departNameResultLst", departNameResultLst);

		System.out.println(JSON.toJSONString(map));
		// Map<String,List<String>> mm=new HashMap<String, List<String>>();
		// for(VoteRankingVo s:maxCommentTopTen){
		// List<String> bb=new ArrayList<String>();
		// List<VoteRankingVo> l=departNameResultLst.get(s.getDepartId());
		// for(VoteRankingVo v:l){
		// bb.add(v.getTotalRate()+"");
		// }
		// bb.add(s.getCommentNum()+"");
		// mm.put(s.getDepartName(), bb);
		// }

		// map.put("detaiData", mm);
		// Set<String> keys=departNameResultLst.keySet();
		// Iterator<String> ite=keys.iterator();
		// List<String> maxList=new ArrayList<String>();
		// while (ite.hasNext()){
		// List<String> _maxList=new ArrayList<String>();
		// String key=ite.next();
		// List<VoteRankingVo> ls=departNameResultLst.get(key);
		// for(VoteRankingVo v:ls){
		// _maxList.add(v.getTotalRate()+"");
		// _maxList.add(maxCommentTopTenMap.get(key));
		// }
		// maxList.addAll(_maxList);
		// }
		//
		return JSON.toJSONString(map);
	}

	private Map<String, String> listToMap(List<VoteRankingVo> lst) {
		Map<String, String> map = new HashMap<String, String>();
		if (lst != null && lst.size() > 0) {
			for (VoteRankingVo v : lst) {
				map.put(v.getParamName(), v.getTotalRate() + "");
			}
		}
		return map;
	}

	@RequestMapping(value = "/appLoginCallBack", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String appLogin(HttpServletResponse response,
			HttpServletRequest request, ModelMap map) throws ExecutionException {
		String accessToken = StringUtils.trimToEmpty(request.getParameter("accessToken"));
		String accessTokenCache = GuavaCacheUtils.accessTokenCache.get(
				accessToken).toString();
		if (StringUtils.isBlank(accessToken)
				|| StringUtils.isBlank(accessTokenCache)) {
			String msg = "二维码已失效，请刷新页面重新扫码登陆！";
			map.put("msg", msg);
			return "tips/app_login_fail.jsp";
		}

		Cookie[] cookies = request.getCookies();
		String appVersion = "";
		String cusNo = "";
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				String cookieValue = cookie.getValue();
				if (StringUtils.equals(cookieName, "appVersion")) {// app版本号
					appVersion = cookieValue;
					if (cookieValue.compareTo("3.0.0") < 0) {
						String msg = "app版本过低，不能评价，请升级到最新版！";
						map.put("msg", msg);
						return "sys/app_login_fail.jsp";
					}
				}
				if (StringUtils.equals(cookieName, "cusno")) {// app用户唯一标示
					cusNo = cookieValue;
					if (StringUtils.isBlank(cookieValue)) {
						String msg = "用户信息异常！";
						map.put("msg", msg);
						return "tips/app_login_fail.jsp";
					}
				}

			}
			if (StringUtils.isBlank(appVersion) || StringUtils.isBlank(cusNo)) {
				String msg = "用户信息异常！";
				map.put("msg", msg);
				return "tips/app_login_fail.jsp";
			}
			map.put("cusNo", cusNo);
			map.put("accessToken", accessToken);
//			GuavaCacheUtils.userInfoCache.put(accessToken, cusNo);// 把用户唯一标示放到缓存里，用于判断用户是否登陆成功
		} else {
			String msg = "用户信息异常！";
			map.put("msg", msg);
			return "tips/app_login_fail.jsp";
		}
		return "tips/app_login.jsp";
	}

	@RequestMapping(value = "/appLogin", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String appConfirmLogin(HttpServletResponse response,
			HttpServletRequest request, ModelMap map) throws ExecutionException {
		String accessToken = request.getParameter("accessToken");
		String cusNo = request.getParameter("cusNo");
		String accessTokenCache = GuavaCacheUtils.accessTokenCache.get(
				accessToken).toString();
		if (StringUtils.isBlank(accessToken)
				|| StringUtils.isBlank(accessTokenCache)) {
			String msg = "二维码已失效，请刷新页面重新扫码登陆！";
			map.put("msg", msg);
			return "tips/app_login_fail.jsp";
		}

		if (StringUtils.isBlank(cusNo)) {
			String msg = "用户信息异常！";
			map.put("msg", msg);
			return "tips/app_login_fail.jsp";
		}
		GuavaCacheUtils.userInfoCache.put(accessToken, cusNo+"");// 把用户唯一标示放到缓存里，用于判断用户是否登陆成功
		return "tips/app_login_success.jsp";
	}
	@ResponseBody
	@RequestMapping(value = "/getAppLoginStatus", method = { RequestMethod.GET,
			RequestMethod.POST })
	public R getAppLoginStatus(HttpServletResponse response,
			HttpServletRequest request, ModelMap map) throws ExecutionException {
		String accessToken = request.getSession().getAttribute("accessToken")+"";
		String cusNo=GuavaCacheUtils.userInfoCache.get(accessToken)+"";
		if (StringUtils.isBlank(accessToken)
				|| StringUtils.isBlank(cusNo)) {
			return R.error();
		}
		
		if (StringUtils.isNotBlank(cusNo)) {
			ShiroUtils.setSessionAttribute("userId", cusNo);//将用户id放到session里
//			GuavaCacheUtils.accessTokenCache.put(accessToken, "");// 登陆成功之后将session里的key移出
//			GuavaCacheUtils.accessTokenCache.put("u-"+accessToken, "");// 登陆成功之后将session里的key移出
			return R.ok();
		}
		return R.error();
	}

	@RequestMapping("barcode.jpg")
	public void captcha(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException, WriterException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		String accessToken = "";
		accessToken = UUID.randomUUID().toString();
		System.out.println("aaaaaaaaaaa="+accessToken);
		request.getSession().setAttribute("accessToken", accessToken);
		GuavaCacheUtils.accessTokenCache.put(accessToken, accessToken);
		String accessUrl = Constant.WEB_SITE + accessToken;
		// 生成图片验证码
		BufferedImage image = ZxingHandler.toBufferedImage(ZxingHandler
				.GetBitMatrix(accessUrl, 200, ErrorCorrectionLevel.H));
		// 保存到shiro session
		ShiroUtils.setSessionAttribute("BARCODE_SESSION_KEY", accessUrl);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
	}

	public static void main(String[] args) {
		String version = "3.0.0";
		System.out.println(version.compareTo("3.0.0"));
	}
}
