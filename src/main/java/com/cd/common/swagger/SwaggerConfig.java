package com.cd.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @Param:描述:swagger相关的配置
 * 通过@Configuration注解，让Spring-boot来加载该类配置。
 * 再通过@EnableSwagger2注解来启用SwaggerConfig类
* @return：返回结果描述:
* @Throws：返回异常结果:
* @Author: chenshangxian
* @Date: 2018-9-17 14:01
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(io.swagger.annotations.Api.class))
                .paths(PathSelectors.any())
                .build();

    }

    /**
     * 设置api介绍信息
     *
     * @return
     */
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("SpringBoot")
                .description("积累才能厚积薄发")
                .termsOfServiceUrl("http://localhost:8088/swagger-ui.html")
                .version("1.0")
                .contact(new Contact("陈尚贤", "", "532780035@qq.com"))
                .build();

    }
}
