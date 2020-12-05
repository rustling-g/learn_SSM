package com.controller;

import com.domain.Account;
import com.domain.User;
import com.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author gg
 * @create 2020-11-27 上午9:36
 */
@Controller
@RequestMapping("/param")     //RequestMapping可以加在类上，表示请求的一级目录
/*
RequestMapping的参数：
    value:                          同path
    method = RequestMethod.POST     指定请求的方式
    params = {"money ! 100"}        指定限制请求参数的条件(必须含有某参数key/参数value限制)
 */
public class ControllerDemo {

    @RequestMapping(path = "/test")
    public String testParam(String username,String password){
        System.out.println("hello");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    @RequestMapping(path = "/saveAccount",method = RequestMethod.POST)
    //把数据封装到javaBean类中,提交表单的数据会被自动封装到account类中
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/testPathVariable/{id}")
    //占位符(Restful风格)
    public String testPathVariable(@PathVariable(name = "id") String id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了");
        //模拟从数据库中查询出User对象
        User user = new User("小明", 18);
        //model对象用于把数据保存到request域中
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testVoid")
    //void，默认返回WEB-INF目录下的请求路径同名同路径的jsp文件
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid 方法执行了");
//        //请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
//        //重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        //直接响应（前两行设置中文乱码问题）
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");

    }

    @RequestMapping("/testForwardAndRedirect")
    //使用关键字进行转发和重定向时，无法再使用视图解析器，所以前面的 return "success" 不能再生效
    public String testForwardAndRedirect(){
        //请求转发
//        return "forward:/WEB-INF/pages/success.jsp";
        //请求重定向
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testModelAndView")
    //使用ModelAndView可以把javabean存入request域中，也可以跳转页面。该方法演示的效果同上面的testString
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView方法执行了");
        ModelAndView mv = new ModelAndView();
        User user = new User("小红", 31);
        //把javabean存入request域中
        mv.addObject("user",user);
        //跳转页面(使用视图解析器)
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testAjax")
    //@ResponseBody把对象转成json串，@RequestBody把请求体内容封装为bean对象
    public @ResponseBody Account testAjax(@RequestBody Account account){
        System.out.println("testAjax方法执行了");
        System.out.println(account);
        account.setPassword("aaaaa");
        return account;
    }

    @RequestMapping("/testFileUpload")
    public String testFileUpload(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("文件上传");
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists())
            file.mkdirs();

        //获取上传文件名
        String filename = upload.getOriginalFilename();
        //把文件的名称设置为唯一值uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" +filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));

        return "success";
    }

    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("testException执行了");
        try {
            //模拟异常
            int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("不知道哪里出错了！");
        }
        return "success";
    }

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor执行了");
        return "success";
    }
}
