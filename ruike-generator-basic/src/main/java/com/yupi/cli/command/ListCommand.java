package com.yupi.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

/**
 * @author: WJR
 * @create: 2024-12-31 23:54
 * @description: list子命令：查看要生成的原始文件列表信息
 */
@CommandLine.Command(name = "list", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    @Override
    public void run() {
        // 整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = new File(projectPath, "ruike-generator-demo-projects/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
