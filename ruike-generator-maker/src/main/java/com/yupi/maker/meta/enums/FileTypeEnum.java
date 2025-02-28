package com.yupi.maker.meta.enums;

/**
 * @author: WJR
 * @create: 2025-01-02 21:50
 * @description: 文件类型枚举
 */
public enum FileTypeEnum {

    DIR("目录", "dir"),
    FILE("文件", "file"),
    GROUP("文件组", "group");

    private final String text;

    private final String value;

    FileTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
