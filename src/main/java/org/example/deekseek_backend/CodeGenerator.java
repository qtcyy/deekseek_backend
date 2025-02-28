package org.example.deekseek_backend;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/**
 * @author chengyiyang
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        FastAutoGenerator.create("jdbc:mysql://120.26.42.17:3306/deepseek", "qtcyy", "002844")
                .globalConfig(builder -> {
                    builder.author("qtcyy") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("/Users/chengyiyang/Desktop/程序设计/Java"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("dao") // 设置父包名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/chengyiyang/Desktop/程序设计/Java/")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude(Collections.emptyList()) // 设置需要生成的表名
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
