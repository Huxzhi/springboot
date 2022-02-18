package com.huxzhi.springboot.Utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * mybatis-plus 代码生成器
 *
 * @Since 2022-02-18
 */
public class CodeGenerator {
    public static void main(String[] args) {
        generate();
    }

    private static void generate() {
        FastAutoGenerator.create("jdbc:mysql://huxzhi.top:3306/floating-population?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
                "hu_remote", "huxinzhi")
                .globalConfig(builder -> {
                    builder.author("huxzhi") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/huxinzhi/Developer/GitHub/Graduation-Design/springboot/src/main/java/"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.huxzhi.springboot") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/huxinzhi/Developer/GitHub/Graduation-Design/springboot/src/main/resources/mapper/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "sys_"); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
