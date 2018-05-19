## Spring MVC的常见注解

***<font color="blue">@Controller***
* 声明普通的Bean的时候，使用 **<font color="red">@Service** **<font color="red">@Repository** **<font color="red">@Controller** 是等同的，因为@Service@Repository@Controller都组合了**<font color="red">@Compoment**源注解，但在Spring MVC中声明控制器Bean时候只能用@Controller

***<font color="blue">@RequestMapping***
* 用来请求映射web的请求(访问路径参数和参数)，处理类和方法的，**<font color="red">@RequestMapping** 可注解在类上和方法上。注解在方法上的@RequestMapping的路径会继承在类上的路径，@RequestMapping支持Servlet的request和response作为参数，也支持对request和response的媒体类型进行配置

***<font color="blue">@ResponseBody***
* **<font color="red">@Response** 支持 将返回值放在response体内，而不是返回一个页面，我们在很多基于Ajax的程序的时候，可以以此注解返回数据而不是页面；此注解可以放置在返回值前或者方法上。

***<font color="blue">@RequestBody***
* **<font color="red">@RequestBody** 允许request的参数在request体内，而不是直接在链接在地址后面，此注解放在参数前

***<font color="blue">@PathVariable***
* **<font color="red">@PathVariable** 用来接受路径，如/news/001，可接受001作为参数，此注解放在参数前

***<font color="blue">@RestController***
* **<font color="red">@RestController** 是一个组合注解，组合了@Controller和@ResponseBody两个注解，功能参考组合注解
