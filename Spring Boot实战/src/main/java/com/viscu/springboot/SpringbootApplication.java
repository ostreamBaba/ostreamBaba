package com.viscu.springboot;

import com.viscu.springboot.config.IdeaSettings;
import com.viscu.springboot.springboot_starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication //spring boot的核心注解
public class SpringbootApplication { //入口类
	@RequestMapping("/")
	public String index(){
		return "hello spring boot";
	}

	@Value("${idea.author}")
	private String ideaAuthor;

	@Value("${idea.word}")
	private String ideaWord;

	@RequestMapping("idea")
	public String testIdea(){
		return "idea author: "+ideaAuthor+" idea word: "+ideaWord;
	}
	//自定义配置文件
	@Autowired
	private IdeaSettings ideaSettings;
	@RequestMapping("ideaSettings")
	public String testIdeaSettings(){
		return "idea author is: "+ideaSettings.getAuthor()+" idea word is:"+ideaSettings.getWord();
	}


	@Autowired
	HelloService helloService;

	@RequestMapping("/testC")
	public String testConfiguration(){
		return helloService.sayHello();
	}


	public static void main(String[] args) { //作为项目启动的入口
		SpringApplication app=new SpringApplication(SpringbootApplication.class);
		app.setBannerMode(Banner.Mode.OFF);//关闭banner
		app.run(args);
	}
}
