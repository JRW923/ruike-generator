package com.yupi.maker.generator;


import java.io.*;

/**
 * @author: WJR
 * @create: 2025-01-01 22:45
 * @description: 利用java代码生成jar包
 */
public class JarGenerator {
    public static void doGenerate(String projectDir) throws InterruptedException, IOException {
        // 调用Process类执行Maven打包命令，Windows系统和其他操作系统命令有些许差异
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String otherMavenCommand = "mvn clean package -DskipTests=true";
        String mavenCommand = winMavenCommand;

        // 使用processBuilder按空格拆分命令
        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        // 设置processBuilder的工作目录，也即打jar包的位置
        processBuilder.directory(new File(projectDir));
        // 获取process对象，真正进行命令的执行
        Process process = processBuilder.start();

        // 利用缓冲流按行读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();

        System.out.println("命令执行结束，退出码：" + exitCode);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerate("D:\\File\\Javaproject\\ruike-generator\\ruike-generator-basic");
    }
}

