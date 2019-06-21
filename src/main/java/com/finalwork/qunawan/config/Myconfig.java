package com.finalwork.qunawan.config;

import com.finalwork.qunawan.config.intercepors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * author: 钱苏涛
 * created on: 2019/6/17 10:05
 * description:
 */
@Configuration
public class Myconfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("login");

    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        try {
            registry.addResourceHandler("/image_cache/**").addResourceLocations("file:"+ResourceUtils.getURL("classpath:").getPath()+"image_cache/");

            String path=new File("src/main/webapp/img/user_img").getCanonicalPath().replace("\\","/")+"/";
            registry.addResourceHandler("/img/user_img/**").addResourceLocations("file:"+path);
            registry.addResourceHandler("/personal/image_cache/**").addResourceLocations("file:"+ResourceUtils.getURL("classpath:").getPath()+"image_cache/");
            WebMvcConfigurer.super.addResourceHandlers(registry);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/user/**","/","/img/**","/index/**","/css/**","/js/**","/common/**",
                "/image_cache/**","/include/**","/user_img/**","/search/**","/tripDetail/**","");

    }


}
