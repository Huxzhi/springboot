package com.huxzhi.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现,
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("标准接口")
                .apiInfo(apiInfo("Spring Boot中使用Swagger2构建REST_ful APIs", "1.0"))
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
//                .host("localhost:8080")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.huxzhi.springboot.controller"))//controller路径
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息(这些基本信息会展现在文档页面中)
     * 访问地址: http://ip:port/swagger-ui.html
     *
     * @param title
     * @param version
     * @return
     */
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title("RestAPI Docs")
                .termsOfServiceUrl("http://www.github.com/kongchen/swagger-maven-plugin")
                .version(version)
                .build();

    }
}
