package pl.mnowicka.autobus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/bus").setViewName("bus");
        registry.addViewController("/activation-send").setViewName("activation-send");
        registry.addViewController("/activation-sent").setViewName("activation-sent");
        registry.addViewController("/register-success").setViewName("register-success");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/searchTest").setViewName("searchTest");
        registry.addViewController("/adminPage").setViewName("adminPage");
        registry.addViewController("/userPage").setViewName("userPage");
        registry.addViewController("/pom").setViewName("pom");
        registry.addViewController("/pom1").setViewName("pom1");
        registry.addViewController("/searchresults").setViewName("searchresults");
        registry.addViewController("/nomatch").setViewName("nomatch");
        registry.addViewController("/success").setViewName("success");
    }
}