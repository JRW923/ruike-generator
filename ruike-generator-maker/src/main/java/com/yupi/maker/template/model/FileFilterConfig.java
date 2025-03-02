package com.yupi.maker.template.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author: WJR
 * @create: 2025-03-01 11:39
 * @description: 文件过滤配置
 */

@Data
@Builder
public class FileFilterConfig {

    /**
     * 过滤范围
     */
    private String range;

    /**
     * 过滤规则
     */
    private String rule;

    /**
     * 过滤值
     */
    private String value;
}
