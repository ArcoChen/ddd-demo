package org.ddd.demo.start.configurator;

import io.swagger.annotations.Contact;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.time.ZoneId;


/**
 * @author huangjiachang
 * @date 2023/8/9
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfigurator implements WebMvcConfigurer {
    @Value("${spring.application.name}")
    String applicationName;

    @Bean
    public Docket webDocket(ApiInfo swaggerApiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(applicationName + "-web")
                .apiInfo(swaggerApiInfo)
                .select()
                .paths((path) -> StringUtils.startsWith(path, "/web"))
                .build();
    }

    @Bean
    public Docket rpcDocket(ApiInfo swaggerApiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(applicationName + "-rpc")
                .apiInfo(swaggerApiInfo)
                .select()
                .paths((path) -> StringUtils.startsWith(path, "/rpc"))
                .build();
    }

    @Bean
    public ApiInfo swaggerApiInfo(@Autowired(required = false) BuildProperties buildProperties) {
        return new ApiInfoBuilder()
                .title("ddd")
                .description("ddd demo")
                .version(buildProperties == null ? "UNKNOWN" :
                        StringUtils.join(buildProperties.getArtifact(), ":", buildProperties.getVersion(),
                                "@",
                                LocalDateTime.ofInstant(buildProperties.getTime(), ZoneId.systemDefault())))
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
    }
}
