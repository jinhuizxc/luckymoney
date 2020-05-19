# luckymoney
1. 新建程序，编写controller类，运行程序， 在浏览器打开：http://localhost:8080/
即可打印显示：hello spring boot
```
@RestController
public class HelloController {

    //  @RequestMapping("/")或者@RequestMapping(value = "/hello")  http://localhost:8080/
    //  @RequestMapping("/hello")  http://localhost:8080/hello
    @RequestMapping("/")
    public String hello(){
        return "hello spring boot";
    }
}
```
2. 需要扩展类`SpringBootServletInitializer`以支持WAR文件部署

3. 打包应用程序，使用Maven和Gradle命令创建一个WAR文件以部署到Tomcat服务器中，以打包应用程序，如下所示。
   对于Maven，使用命令`mvn package`打包应用程序
   
4. 在Spring Boot中，可以使用Spring Framework来定义bean及其依赖注入。 
@ComponentScan注释用于查找bean以及使用@Autowired注释注入的相应内容。
5. 应用程序运行器应用程序运行器(Runner)是一个用于在Spring Boot应用程序启动后执行代码的接口。 下面给出的示例显示了如何在主类文件上实现Application Runner接口。
```
@SpringBootApplication
public class SpringdemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello World from Application Runner");
    }
}
```
运行程序显示： Hello World from Application Runner

命令行运行器控制台窗口Runner是一个接口。 它用于在Spring Boot应用程序启动后执行代码。下面给出的示例显示了如何在主类文件上实现控制台窗口Runner接口。
//更多请阅读：https://www.yiibai.com/spring-boot/spring_boot_runners.html#article-start
```
@SpringBootApplication
public class SpringdemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world from Command Line Runner");
    }
}
```
打印： Hello world from Command Line Runner

## 6. Rest控制器
1. @RestController注释用于定义RESTful Web服务。它提供JSON，XML和自定义响应。其语法如下所示 
```
@RestController
public class ProductServiceController {
}
```
2. 请求映射
@RequestMapping注释用于定义访问REST端点的Request URI。可以定义Request方法来使用和生成对象。默认请求方法是:GET。
```
@RequestMapping(value = "/products")
public ResponseEntity<Object> getProducts() { }
```
3. 请求主体@RequestBody注释用于定义请求正文内容类型。
```
public ResponseEntity<Object> createProduct(@RequestBody Product product) {
}
```
4. 路径变量@PathVariable批注用于定义自定义或动态请求URI。 请求URI中的Path变量定义为花括号{}，如下所示 -
```
public ResponseEntity<Object> updateProduct(@PathVariable("id") String id) {
}
```
5. 请求参数@RequestParam注释用于从请求URL读取请求参数。默认情况下，它是必需参数。还可以为请求参数设置默认值，如下所示 -
```
public ResponseEntity<Object> getProduct(
   @RequestParam(value = "name", required = false, defaultValue = "honey") String name) {
}
```
6. Restful api使用示例（访问地址： , postman可测试接口）
```
@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }


    // 默认的HTTP请求方法是GET。此方法不需要任何请求主体。可以发送请求参数和路径变量来自定义或动态URL。
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    // HTTP POST请求用于创建资源。 此方法包含请求正文。可以发送请求参数和路径变量来定义自定义或动态URL。
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    // HTTP PUT请求用于更新现有资源，此方法包含请求正文。可以发送请求参数和路径变量来自定义或动态URL。
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    // HTTP删除请求用于删除现有资源。此方法不包含任何请求正文。可以发送请求参数和路径变量来自定义或动态URL。
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }
   
}
```
### 异常处理
- @ControllerAdvice是一个注解，用于全局处理异常。
- @ExceptionHandler是一个注释，用于处理特定异常并将自定义响应发送到客户端。



### 参考学习站点
- [SpringBoot学习](https://www.jianshu.com/p/8b82bc6b4fe8)



   

  
   


