package com.example.luckymoney.controller;

import com.example.luckymoney.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Controller 处理http请求
 * @RestController Spring4后新加的注解，原来返回json需要@ResponseBody与@Controller配合
 * @RequestMapping 配置url映射
 *
 * @RestController注解是@Controller和@ResponseBody的合集,表示这是个控制器bean,并且是将函数的返回值
 *  直接填入HTTP响应体中,是REST风格的控制器。
 *  在使用@RequestMapping后，返回值通常解析为跳转路径
 *
 *
 * @RestController = @Controller + @ResponseBody
 *
 * 遇到/hello/say、 /hello/say2 /hello/say3 这样同类的处理方式
 * 在controller类上添加 @RequestMapping("/hello")即可。
 *
 * 接口打印： http://localhost:8081/luckymoney/hello/say
 *
 * //    @PostMapping({"/say"})
 *     @RequestMapping({"/say"})  // 要么用get 要么用post方式不要都支持
 *
 * get接口方式：
 * http://localhost:8081/luckymoney/hello/say/100
 *     @GetMapping({"/say/{id}"})
 *     public String getMinMoney(@PathVariable("id") Integer id){
 *         return "id: " + id;
 *     }
 *
 * http://localhost:8081/luckymoney/hello/say?id=100
 *   @GetMapping({"/say"})
 * //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
 *     public String getMinMoney(@RequestParam("id") Integer id){
 *         return "id: " + id;
 *     }
 *
 * 设置请求参数非必传, 默认值为"0"
 *  http://localhost:8081/luckymoney/hello/say
 *   @GetMapping({"/say"})
 *   public String getMinMoney(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
 *     return "id: " + id;
 *  }
 *
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    // 新版写法
//    @GetMapping("/hello")
    // spring1.xx版本
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String hello(){
//        return "spring boot study";  //
//    }

    // 单个配置
   /* @Value("${minMoney}")
    private BigDecimal minMoney;

    @Value("${description}")
    private String description;*/

   @Autowired
   private LimitConfig limitConfig;

   /*@GetMapping("/hello")
   @ResponseBody
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getMinMoney(){
        return "description: " + limitConfig.getDescription();  // minMoney: 1
//        return "index";  // 使用模板
    }*/

    // ctrl+提示
    @PostMapping({"/say"})
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getMinMoney(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
//        return "description: " + limitConfig.getDescription();  // minMoney: 1
//        return "index";  // 使用模板
        return "id: " + id;
    }


    @GetMapping("/hello2")
    public String getMinMoney2(){
        return "index";  // 使用模板
    }
}
