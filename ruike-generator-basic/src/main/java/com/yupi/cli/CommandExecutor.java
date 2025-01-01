package com.yupi.cli;

import com.yupi.cli.command.ConfigCommand;
import com.yupi.cli.command.GenerateCommand;
import com.yupi.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

/**
 * @author: WJR
 * @create: 2024-12-31 23:56
 * @description: 命令模式中的调用者，负责绑定所有子命令，并且提供执行命令的方法
 */
@Command(name = "ruike", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }

    @Override
    public void run() {
        // 本身没有任何实际作用，仅在当用户不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    /**
     * 接受外层传参来执行命令
     * @param args
     * @return
     */
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
