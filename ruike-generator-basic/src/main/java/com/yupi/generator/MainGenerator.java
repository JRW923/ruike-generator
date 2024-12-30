package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author: WJR
 * @create: 2024-12-30 20:15
 * @description: 动静结合，生成完整代码
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        // 1.静态文件生成
        // 项目根路径
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = projectPath + File.separator + "ruike-generator-demo-projects" + File.separator + "acm-template";
        // 输出路径
        String outputPath = projectPath;
        // 复制
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        // 2.动态文件生成
        String DynamicInputPath = projectPath + File.separator + "ruike-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String DynamicOutputPath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("laowu");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        DynamicGenerator.doGenerate(DynamicInputPath, DynamicOutputPath, mainTemplateConfig);

    }
}
