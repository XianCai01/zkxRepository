//package com.zkx.item.utils;
//
//import com.jy.hotwheel.dao.UserMapper;
//import com.jy.hotwheel.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 获取用户登录信息
// *
// * @Author zt
// * @Date 2019年12月26日
// */
//@Component
//public class SessionUtil {
//    @Autowired
//    UserMapper userMapper;
//
//    /**
//     * 根据header获取用户
//     *
//     * @param request
//     * @return
//     */
//    public User GetLoginUser(HttpServletRequest request) {
//        String token = request.getHeader("token");
//        if (StringUtils.isEmpty(token)) {
//            return null;
//        }
//        String[] tokenArr = token.split(":|:");
//        String openId = tokenArr[0];
//        return userMapper.getByOpenId(openId);
//    }
//
//    /**
//     * 根据header获取openId
//     *
//     * @param request
//     * @return
//     */
//    public String GetLoginOpenId(HttpServletRequest request) {
//        String token = request.getHeader("token");
//        String[] tokenArr = token.split(":|:");
//        return tokenArr[0];
//    }
//}
