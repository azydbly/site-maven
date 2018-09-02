package com.xst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: UtilController
 * @类描述: UtilController   通用工具类
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/2 13:09
 */

@Controller
public class UtilController {


    @ResponseBody
    public void validateReturn(HttpServletRequest request, HttpServletResponse response,Object o) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if(o == null){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }

}
