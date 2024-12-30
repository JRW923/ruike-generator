package com.yupi.model;

import lombok.Data;

/**
 * @author: WJR
 * @create: 2024-12-30 17:17
 * @description: 动态模板配置
 */
@Data
public class MainTemplateConfig {

    /**
     * 动态生成需求：作者，输出信息，是否循环
     */
    private String author = "laowu";

    private String outputText = "输出结果";

    private boolean loop;
}
