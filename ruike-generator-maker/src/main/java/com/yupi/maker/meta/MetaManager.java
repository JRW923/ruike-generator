package com.yupi.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author: WJR
 * @create: 2025-01-01 19:21
 * @description: 读取meta.json，使用双检索单例模式（DCL）
 */
public class MetaManager {

    private static volatile Meta meta;

    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta(){
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        // todo 校验配置文件，处理默认值
        return newMeta;
    }
}
