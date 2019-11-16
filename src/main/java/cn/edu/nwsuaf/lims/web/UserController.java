package cn.edu.nwsuaf.lims.web;

import cn.edu.nwsuaf.lims.core.Result;
import cn.edu.nwsuaf.lims.core.ResultGenerator;
import cn.edu.nwsuaf.lims.model.User;
import cn.edu.nwsuaf.lims.service.UserService;
import cn.edu.nwsuaf.lims.util.TokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
/**
* Created by liuchao Li on 2019/10/27.
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;




    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody User user) {
        userService.deleteById(user.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @PostMapping(value="login")
    public Result login(@RequestBody User use)

    {
        JSONObject jsonObject=new JSONObject();

        String email=use.getEmail();
        String password=use.getPassword();
        //System.out.println(username);
        User userForBean=userService.login(email,password);


        if(userForBean!=null){
            if(userForBean.getUsername().equals("err")){
                return ResultGenerator.genFailResult("err");
            }

            TokenService tokenService=new TokenService();
            String token = tokenService.getToken(userForBean);
            System.out.println("to");
            System.out.println(token);
            jsonObject.put("token", token);
            jsonObject.put("user", userForBean);

            return ResultGenerator.genSuccessResult(jsonObject);
        }else{
            return ResultGenerator.genFailResult("unregister");
        }
    }

    @GetMapping(value="/findByUsername")
    public Result findByUsername(@RequestParam(defaultValue = "") String username)

    {

        User user=userService.findByUsername(username);

        if(user!=null){


            return ResultGenerator.genFailResult("用户名已被注册");

        }else{
            return ResultGenerator.genSuccessResult();
        }
    }

    @GetMapping(value="/findByEmail")
    public Result findByEmail(@RequestParam(defaultValue = "") String email)

    {

        User user=userService.findByEmail(email);

        if(user!=null){

            return ResultGenerator.genFailResult("邮箱已被注册");


        }else{

            return ResultGenerator.genSuccessResult();
        }
    }




}
