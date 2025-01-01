package com.yupi.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author: WJR
 * @create: 2024-12-30 15:07
 * @description: 静态文件生成器
 */
public class StaticGenerator {
    public static void main(String[] args) {
        // 项目根路径：D:\File\Javaproject\ruike-generator
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = projectPath + File.separator + "ruike-generator-demo-projects" + File.separator + "acm-template";
        // 输出路径
        String outputPath = projectPath;
        // 复制
//        copyFilesByHutool(inputPath, outputPath);
        copyFilesByRecursive(inputPath, outputPath);
    }

    /**
     * 拷贝文件：Hutool 实现，将输入目录完整拷贝到输出目录下
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

    /**
     * 拷贝文件：递归实现，调用copyFilesByRecursive
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFilesByRecursive(inputFile,outputFile);
        } catch (IOException e) {
            System.err.println("文件复制失败");
            e.printStackTrace();
        }
    }

    /**
     * 先创建目录，然后遍历目录内的文件，依次复制
     * @param inputFile
     * @param outputFile
     */
    private static void copyFilesByRecursive(File inputFile, File outputFile) throws IOException {
        // 区分是文件还是目录
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 如果是目录，先创建目录
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            // 获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            // 没有子文件，结束
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                // 递归拷贝下一层文件
                copyFilesByRecursive(file, destOutputFile);
            }
        }else {
            // 如果是文件，直接拷贝到目标目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(),destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
