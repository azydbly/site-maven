package com.xst.controller;

import com.xst.common.exception.*;
import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础Controller
 * @author CZH
 */
@Controller
public class BaseController {

	/**日志*/
	public static Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * 失败返回
	 * @param retmsg
	 * @return
	 */
	public AjaxResult returnFailed(String retmsg) {
		return new AjaxResult(retmsg);
	}

	/**
	 * 得到request对象
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/** ajax登录异常处理 **/
	@ExceptionHandler({AjaxLoginException.class })
	@ResponseBody
	public AjaxResult ajaxLoginExceptionHandler(AjaxLoginException e) {
		logger.error("登录请求发生异常:", e);
		return new AjaxResult(e.getKey(), e.getMessage());
	}

	/** 普通登录异常处理 **/
	@ExceptionHandler({LoginException.class })
	public String loginExceptionHandler(LoginException e, HttpServletRequest request) {
        System.out.println("============dasddasdsadasd=");
		logger.error("登录请求发生异常:", e);
		request.setAttribute("message", e.getMessage());
		return "forward:/";
	}

	/** 普通权限异常处理 **/
	@ExceptionHandler({PermissionException.class })
	public String permissonExceptionHandler(PermissionException e) {
		return "error/no_permisson";
	}

	/** ajax权限异常处理 **/
	@ExceptionHandler({AjaxPermissionException.class })
	@ResponseBody
	public AjaxResult ajaxPermissionExceptionHandler(AjaxPermissionException e) {
		return new AjaxResult(e.getKey(), e.getMessage());
	}
	
	/** 频繁请求异常处理 **/
	@ExceptionHandler({ MalciousException.class })
	public String malExceptionHandler(MalciousException e) {
	    return "error/mal_request";
	}

	/** 公共异常处理 **/
	@ExceptionHandler({Exception.class })
	public Object exceptionHandler(Exception e, HttpServletRequest request) {
		ParamData params = new ParamData();
		logger.info("");
		StringBuilder sb = new StringBuilder(params.getString("loginIp")).append(request.getRequestURI()).append("请求发生异常:").append(request.getServletPath()).append(":").append(params);
		logger.error(sb.toString(), e);
		return "error/500";
	}

	public void logBefore(String desc) {
		HttpServletRequest request = getRequest();
		logger.error("");
		StringBuilder sb = new StringBuilder(IPUtil.getIpAdd(request)).append(desc).append(":").append(request.getServletPath());
		logger.error(sb.toString());
	}
}
