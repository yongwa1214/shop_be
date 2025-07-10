package kr.co.wikibook.gallery.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration //빈등록
public class WebMvcConfiguration implements WebMvcConfigurer{

    private final  String uploadPath;

    public WebMvcConfiguration(@Value("${constants.file.directory}") String uploadPath){
        this.uploadPath = uploadPath;
        log.info("upload Path:{}", uploadPath);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/pic/**")
                .addResourceLocations("file:" + uploadPath); // 외부경로와 연동시키겠다
    }

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}