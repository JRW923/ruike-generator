package com.yupi.maker.meta;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.yupi.maker.meta.Meta.ModelConfig;
import com.yupi.maker.meta.Meta.FileConfig;
import com.yupi.maker.meta.enums.FileGenerateTypeEnum;
import com.yupi.maker.meta.enums.FileTypeEnum;
import com.yupi.maker.meta.enums.ModelTypeEnum;

import java.nio.file.Paths;
import java.util.List;

/**
 * @author: WJR
 * @create: 2025-01-02 20:11
 * @description: 元信息校验和默认值
 */
public class MetaValidator {

    public static void doValidAndFill(Meta meta){
        validAndFillMetaRoot(meta);
        validAndFillFileConfig(meta);
        validAndFillModelConfig(meta);
    }

    private static void validAndFillModelConfig(Meta meta) {
        // modelConfig校验和默认值
        ModelConfig modelConfig = meta.getModelConfig();
        if (modelConfig == null) {
            return;
        }
        List<ModelConfig.ModelInfo> modelInfoList = modelConfig.getModels();
        if (CollectionUtil.isEmpty(modelInfoList)) {
            return;
        }
        for (ModelConfig.ModelInfo modelInfo : modelInfoList) {
            // 输出路径默认值
            String fieldName = modelInfo.getFieldName();
            if (StrUtil.isBlank(fieldName)){
                throw new MetaException("未填写fieldName");
            }
            String modelInfoType = modelInfo.getType();
            if (StrUtil.isEmpty(modelInfoType)){
                modelInfo.setType(ModelTypeEnum.STRING.getValue());
            }
        }
    }

    private static void validAndFillFileConfig(Meta meta) {
        // fileConfig校验和默认值
        FileConfig fileConfig = meta.getFileConfig();
        if (fileConfig == null) {
            return;
        }
        // sourceRootPath：必填
        String sourceRootPath = fileConfig.getSourceRootPath();
        if (StrUtil.isBlank(sourceRootPath)){
            throw new MetaException("未填写sourceRootPath");
        }
        // inputRootPath：.source + sourceRootPath的最后一个层级路径
        String inputRootPath = fileConfig.getInputRootPath();
        String defaultInputPath = ".source/" + FileUtil.getLastPathEle(Paths.get(sourceRootPath)).getFileName().toString();
        if (StrUtil.isEmpty(inputRootPath)){
            fileConfig.setInputRootPath(defaultInputPath);
        }
        // outputRootPath：默认为当前路径下的generated
        String outputRootPath = fileConfig.getOutputRootPath();
        String defaultOutputRootPath = "generated";
        if (StrUtil.isEmpty(outputRootPath)){
            fileConfig.setOutputRootPath(defaultOutputRootPath);
        }
        String fileConfigType = fileConfig.getType();
        String defaultFileConfigType = FileTypeEnum.DIR.getValue();
        if (StrUtil.isEmpty(fileConfigType)){
            fileConfig.setType(defaultFileConfigType);
        }
        // fileInfo默认值
        List<FileConfig.FileInfo> fileInfoList = fileConfig.getFiles();
        if (CollectionUtil.isEmpty(fileInfoList)) {
            return;
        }
        for (FileConfig.FileInfo fileInfo : fileInfoList) {
            // inputPath：必填
            String inputPath = fileInfo.getInputPath();
            if (StrUtil.isBlank(inputPath)){
                throw new MetaException("未填写inputPath");
            }
            // outputPath：默认等于inputPath
            String outputPath = fileInfo.getOutputPath();
            if (StrUtil.isEmpty(outputPath)){
                fileInfo.setOutputPath(inputPath);
            }
            // type：默认inputPath有文件后缀（如.java）为file，否则为dir
            String type = fileInfo.getType();
            if (StrUtil.isBlank(type)){
                // 无文件后缀
                if (StrUtil.isBlank(FileUtil.getSuffix(inputPath))){
                    fileInfo.setType(FileTypeEnum.DIR.getValue());
                }else{
                    fileInfo.setType(FileTypeEnum.FILE.getValue());
                }
            }
            // generateType：如果文件结尾不为.ftl，generateType默认为static，否则为dynamic
            String generateType = fileInfo.getGenerateType();
            if (StrUtil.isBlank(generateType)){
                // 为动态模板
                if (inputPath.endsWith(".ftl")){
                    fileInfo.setGenerateType(FileGenerateTypeEnum.DYNAMIC.getValue());
                }else{
                    fileInfo.setGenerateType(FileGenerateTypeEnum.STATIC.getValue());
                }
            }
        }
    }

    private static void validAndFillMetaRoot(Meta meta) {
        // 基础信息校验和默认值
        String name = StrUtil.blankToDefault(meta.getName(), "my-generator");
        String description = StrUtil.emptyToDefault(meta.getDescription(), "我的模板代码生成器");
        String author = StrUtil.emptyToDefault(meta.getAuthor(), "laowu");
        String basePackage = StrUtil.blankToDefault(meta.getBasePackage(), "com.laowu");
        String version = StrUtil.emptyToDefault(meta.getVersion(), "1.0");
        String createTime = StrUtil.emptyToDefault(meta.getCreateTime(), DateUtil.now());
        meta.setName(name);
        meta.setDescription(description);
        meta.setAuthor(author);
        meta.setBasePackage(basePackage);
        meta.setVersion(version);
        meta.setCreateTime(createTime);
    }
}
