package com.yupi.maker.template.model;

import lombok.Data;

/**
 * @author: WJR
 * @create: 2025-03-03 10:43
 * @description:
 */
@Data
public class TemplateMakerOutputConfig {

    // 从未分组的文件中移除组内的同名文件
    private boolean removeGroupFilesFromRoot = true;
}
