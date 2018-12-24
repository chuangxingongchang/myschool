package com.school.controller;

import com.school.entity.TUser;
import com.school.entity.TUserExample;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class UserController {
    /**
     * 用户注册
    * */
    @Autowired
   private UserService userService;
    @RequestMapping("/register")
   public void register(HttpServletRequest request, String code,TUser user){
      String codes = (String) request.getSession().getAttribute("code");
        try {
            if(codes.equals(code)){
                if(userService.insertUser(user)){
                    System.out.println("注册成功");
                    request.getSession().removeAttribute("code");
                }else {
                    System.out.println("注册失败");
                }
            }else{
                System.out.println("验证码错误");
            }
        }catch (Exception e){
            System.out.println("验证码过时，请从新发送验证码");
        }
   }
   @RequestMapping("/mycode")
   public void getCode(String code,HttpServletRequest request) throws InterruptedException {
       //session 中存在的验证码，存在60秒
       System.out.println(code);
       request.getSession().setAttribute("code",code);

   }
   /**
    * 用户登录
   * */
   @RequestMapping("/login")
    public void login(TUser user){
       if(user!=null){
           if(userService.login(user)){
               System.out.println("登录成功");
           }else {
               System.out.println("账号或密码错误");
           }
       }else{
           System.out.println("账号和密码不能为空");
       }
   }

   /**
    * 自动登录
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
       String pword   = user.getPword();
       TUser users    = new TUser();
       String userInfo= users.toString();
       if(null!=phoneno&&!"".equals(phoneno)){
           users.setPhoneno(phoneno);
       }
       if (null!=pword&&!"".equals(pword)){
           users.setPword(pword);
       }
       Cookie cookie = new Cookie("users",userInfo);
       cookie.setMaxAge(360*24*60);//设置
       cookie.setPath("/");//可在同一应用服务器内共享方法
       response.addCookie(cookie);//放松到客服端
       //凭这个Cookie就自动登录并不安全，可以在服务器端使用Session来管理用户
       //当第一次登录成功后就创建一个Session,并将用户的某些信息保存在Session
       HttpSession session = request.getSession();
       session.setAttribute("users",userInfo);
       session.setMaxInactiveInterval(3600*2);//2小时
       //但是当cookie关闭后，用于保存SessionID的JSESSIONID会消失
       //此时cookie并没有过期，所以得将JSESESSION持久化
       Cookie sessionId = new Cookie("JSESESSIONID",session.getId());
       sessionId.setMaxAge(2*60);//设置两个小时
       sessionId.setPath("/");
       response.addCookie(sessionId);

       //当用户第二次登录时，检测这个cookie是否存在
       Cookie[] cookies = request.getCookies();
       for (Cookie cookie2:cookies){
           //如果存在这个cookie进行页面跳转
           if(cookie2.equals("users")){
               if (session.getAttribute("users")!=null){
                   request.getRequestDispatcher("直接进入主页面的url").forward(request,response);
                   break;
               }else{
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
   @RequestMapping("/forgetPword")
   public void forgetPword(String phoneno,String pword){
       TUser user = new TUser();
       TUserExample userExample = new TUserExample();
       userExample.or().andPhonenoEqualTo(phoneno);
       user.setPword(pword);
       if(userService.updatePword(user,userExample)){
           System.out.println("修改成功");
       }else {
           System.out.println("修改失败");
       }
   }
}
