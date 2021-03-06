package com.quan.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.quan.constant.ConfigConsts;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author 全俊
 * @version 1.0
 * @className OSSClientUtils
 * @description OSS对象存储工具类
 * @date 2020/8/2 20:28
 */
@Component
public class OSSClientUtils {
    private String endPoint = "你的endPoint";

    private String accessKeyId = "你的accessKeyId";

    private String accessKeySecret = "你的accessKeySecret";

    private String bucketName = "你的bucketName";

    private OSS ossClient;

    public String upload(MultipartFile file) {
        String uploadUrl = null;

        try {
            //判断oss实例是否存在：如果不存在则创建，如果存在则获取
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
            if (!ossClient.doesBucketExist(bucketName)) {
                //创建bucket
                ossClient.createBucket(bucketName);
                //设置oss实例的访问权限：公共读
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }

            //获取上传文件流
            InputStream inputStream = file.getInputStream();

            //构建日期路径：avatar/2019/02/26/文件名
            String datePath = new DateTime().toString("yyyy/MM/dd");

            //文件名：uuid.扩展名
            String original = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");
            String fileType = original.substring(original.lastIndexOf("."));
            String newName = fileName + fileType;

            fileName = datePath + "/" + newName;


            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setObjectAcl(CannedAccessControlList.PublicRead);
            objectMetadata.setContentLength(inputStream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getContentType(fileName.substring(fileName.lastIndexOf("."))));

            //文件上传至阿里云
            ossClient.putObject(bucketName, fileName, inputStream, objectMetadata);

            // 关闭OSSClient。
            ossClient.shutdown();

            Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
            uploadUrl = ossClient.generatePresignedUrl(bucketName, fileName, expiration).toString();

            //获取url地址
            //uploadUrl = "https://" + bucketName + "." + endPoint + "/" + fileName;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return uploadUrl.substring(0, uploadUrl.indexOf("?"));
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param filenameExtension 文件后缀
     * @return String
     */
    public static String getContentType(String filenameExtension) {
        if (ConfigConsts.BMP.equalsIgnoreCase(filenameExtension)) {
            return "image/bmp";
        }
        if (ConfigConsts.GIF.equalsIgnoreCase(filenameExtension)) {
            return "image/gif";
        }
        if (ConfigConsts.HTML.equalsIgnoreCase(filenameExtension)) {
            return "text/html";
        }
        if (ConfigConsts.TXT.equalsIgnoreCase(filenameExtension)) {
            return "text/plain";
        }
        if (ConfigConsts.VSD.equalsIgnoreCase(filenameExtension)) {
            return "application/vnd.visio";
        }
        if (ConfigConsts.PPTX.equalsIgnoreCase(filenameExtension) ||
                ConfigConsts.PPT.equalsIgnoreCase(filenameExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (ConfigConsts.DOCX.equalsIgnoreCase(filenameExtension) ||
                ConfigConsts.DOC.equalsIgnoreCase(filenameExtension)) {
            return "application/msword";
        }
        if (ConfigConsts.XML.equalsIgnoreCase(filenameExtension)) {
            return "text/xml";
        }
        return "image/jpg";
    }
}
