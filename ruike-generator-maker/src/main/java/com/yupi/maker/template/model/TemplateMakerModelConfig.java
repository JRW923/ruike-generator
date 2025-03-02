package com.yupi.maker.template.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: WJR
 * @create: 2025-03-01 11:53
 * @description: 模型相关配置
 */

@Data
public class TemplateMakerModelConfig {

    private List<ModelInfoConfig> models;

    private ModelGroupConfig modelGroupConfig;

    @Data
    @NoArgsConstructor
    public static class ModelInfoConfig {

        private String fieldName;

        private String type;

        private String description;

        private String defaultValue;

        private String abbr;

        // 用于替换哪些文本
        private String replaceText;

    }

    @Data
    public static class ModelGroupConfig {

        private String condition;

        private String groupKey;

        private String groupName;
    }
}
