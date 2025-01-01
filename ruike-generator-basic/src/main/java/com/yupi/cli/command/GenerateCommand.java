package com.yupi.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yupi.generator.MainGenerator;
import com.yupi.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

/**
 * @author: WJR
 * @create: 2024-12-31 23:54
 * @description: generate子命令：生成文件
 */
@Data
@Command(name = "generate", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {

    /**
     * 动态生成需求：作者，输出信息，是否循环
     */
    @Option(names = {"-a", "--author"}, description = "作者名称", arity = "0..1", interactive = true, echo = true)
    private String author = "laowu";

    @Option(names = {"-o", "--outputText"}, description = "输出文本", arity = "0..1", interactive = true, echo = true)
    private String outputText = "输出结果";

    @Option(names = {"-l", "--loop"}, description = "是否循环", arity = "0..1", interactive = true, echo = true)
    private boolean loop;

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
