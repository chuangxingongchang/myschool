package com.school.controller;

import com.school.entity.TUser;
import com.school.service.SchoolService;
import com.school.service.UserService;
import com.school.util.JuheSend;
import com.school.util.Message;
import com.school.util.Randoms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/touser")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SchoolService schoolService;
    /**
     * 用户注册
     */
    @RequestMapping("/registers")
    public ModelAndView register(HttpServletRequest request, String code, TUser user) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        Message ms = new Message();
        String codes = (String) request.getSession().getAttribute("code");
        try {
            if (codes.equals(code)) {
                if (userService.insertUser(user)) {
                    request.getSession().removeAttribute("code");
                    ms.setStatus(true);
                    ms.setData(user);
                } else {
                    ms.setStatus(false);
                    ms.setMsg("注册失败");
                }
            } else {
                ms.setStatus(false);
                ms.setMsg("验证码错误");
            }
        } catch (Exception e) {
            ms.setStatus(false);
            ms.setMsg("验证码过时，请从新发送验证码");
        } finally {
            mav.addObject(ms);
            return mav;
        }
    }

    /**
     * @param request
     * @param phoneno
     * @return 描述：通过前台请求，发送验证码到手机，并存储在Session中
     */
    @RequestMapping("/mycode")
    public ModelAndView getCode(HttpServletRequest request, String phoneno) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        Message ms = new Message();
        //获取验证码（调用工具类Randoms，随机获取六位验证码）
        String code = String.valueOf(Randoms.getIntRan());
        //发送验证码到手机（调用工具类JuheSend,使用聚合短信接口实现短信发送
        boolean flag = JuheSend.mobileQuery(phoneno, code);
        if (flag) {
            System.out.println("验证码发送:" + code);
            request.getSession().setAttribute("code", code);
            //session 中存在的验证码，存在5分钟
            request.getSession().setMaxInactiveInterval(300);
            ms.setStatus(true);
        } else {
            ms.setStatus(false);
            ms.setMsg("验证码发送失败");
        }
        mav.addObject(ms);
        return mav;
    }

    /**
     * 用户登录
     */
    @RequestMapping("/logins")
    public ModelAndView login(TUser user) {
        System.out.println("进入登录");
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        Message ms = new Message();
        try {
            if (userService.login(user)) {
                ms.setMsg("登录成功");
                ms.setStatus(true);
                ms.setData(user);
            } else {
                ms.setMsg("账号或密码错误");
                ms.setStatus(false);
            }
        } catch (Exception e) {
            ms.setStatus(false);
            ms.setMsg("发生错误，请重新登录");
        } finally {
            mav.addObject("ms",ms);
            return mav;
        }
    }

    /**
     * 自动登录
     *
     * @param user
     * @param response
     * @param request
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/autoLogin")
    public void autoLogin(TUser user, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        //如果是第一次登录，将用户名和密码作为cookie写到本地
        String phoneno = user.getPhoneno();
        String pword = user.getPword();
        TUser users = new TUser();
        String userInfo = users.toString();
        if (null != phoneno && !"".equals(phoneno)) {
            users.setPhoneno(phoneno);
        }
        if (null != pword && !"".equals(pword)) {
            users.setPword(pword);
        }
        Cookie cookie = new Cookie("users", userInfo);
        cookie.setMaxAge(360 * 24 * 60);//设置
        cookie.setPath("/");//可在同一应用服务器内共享方法
        response.addCookie(cookie);//放松到客服端
        //凭这个Cookie就自动登录并不安全，可以在服务器端使用Session来管理用户
        //当第一次登录成功后就创建一个Session,并将用户的某些信息保存在Session
        HttpSession session = request.getSession();
        session.setAttribute("users", userInfo);
        session.setMaxInactiveInterval(3600 * 2);//2小时
        //但是当cookie关闭后，用于保存SessionID的JSESSIONID会消失
        //此时cookie并没有过期，所以得将JSESESSION持久化
        Cookie sessionId = new Cookie("JSESESSIONID", session.getId());
        sessionId.setMaxAge(2 * 60);//设置两个小时
        sessionId.setPath("/");
        response.addCookie(sessionId);

        //当用户第二次登录时，检测这个cookie是否存在
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie2 : cookies) {
            //如果存在这个cookie进行页面跳转
            if (cookie2.equals("users")) {
                if (session.getAttribute("users") != null) {
                    request.getRequestDispatcher("直接进入主页面的url").forward(request, response);
                    break;
                } else {
                    //跳转到登录页面
                }
                //如果使用上面的代码，即使浏览器关闭，在两小时之内，Web程序仍然可以自动登录。
                //如果我们自已加一个JSESSIONID Cookie，在第一次访问Web程序时，
                //HTTP响应头有两个JSESSIONID，但由于这两个JSESSIONID的值完全一样，没有任何影响
                //如果在响应头的Set-Cookie字段中有多个相同的Cookie，则按着path和name进行比较，如果这两个值相同，
                //则认为是同一个Cookie，最后一个出现的Cookie将覆盖前面相同的Cookie
            }
        }
    }

    @RequestMapping("/forgetpword")
    public ModelAndView forgetPword(String phoneno, String pword, String code, HttpServletRequest request) {
        System.out.println("进入密码修改");
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        Message ms = new Message();
        String codes = (String) request.getSession().getAttribute("code");
        if (code.equals(codes)) {
            if (userService.forgetPword(phoneno, pword)) {
                ms.setMsg("修改成功，跳转登录");
                ms.setStatus(true);
            } else {
                ms.setStatus(false);
                ms.setMsg("修改失败，没有该用户");
            }
        } else {
            ms.setStatus(false);
            ms.setMsg("验证码错误");
        }
        mav.addObject(ms);
        return mav;
    }

    /**
     * @param user 描述：个人中心，用户充值
     */
    @RequestMapping("/addMoney")
    public void addMoney(TUser user) {
        if (userService.addMoney(user)) {
            System.out.println("充值成功");
        } else {
            System.out.println("充值失败");
        }
    }

    /**
     * @param user 描述：个人中心，用户资料修改
     */
    @RequestMapping("/updateUser")
    public ModelAndView updateMyUser(TUser user) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        Message ms = new Message();
        try {
            boolean flag = userService.updateUser(user);
            if(flag){
                ms.setStatus(true);
            }else{
                ms.setStatus(false);
                ms.setMsg("修改失败");
            }
        }catch (Exception e){
            ms.setStatus(false);
            ms.setMsg("系统出错，解决中...");
        }finally {
            mav.addObject("ms",ms);
            return mav;
        }
    }

    @RequestMapping("/getUser")
    public ModelAndView getMyUser(String phoneno) {
        System.out.println("获取用户中。。。。。。。。。。。。");
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        Message ms = new Message();
        TUser users = userService.selectByPhoneno(phoneno);
            if(users.getFkSchoolId()!=null){
                String schoolname = schoolService.selectByFkSchoolId(users.getFkSchoolId());
                ms.setMsg(schoolname);
            }else{
                ms.setMsg("您没有设置学校");
            }
            if (users == null) {
                ms.setStatus(false);
            } else {
                ms.setStatus(true);
            }
            mav.addObject("tuser",users);
            mav.addObject("scms",ms);
        return mav;
    }

    @RequestMapping("/ss")
    public ModelAndView vv(TUser user) {
        ModelAndView m = new ModelAndView(new MappingJackson2JsonView());
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        String value = "aaaa1111"; // 数字字母组合
        System.out.println(value.matches(regex));
        System.out.println("dfjsdlfjsdlfjsdlkfjsdlkfjsdlkfjs");
        return m;
    }
}
