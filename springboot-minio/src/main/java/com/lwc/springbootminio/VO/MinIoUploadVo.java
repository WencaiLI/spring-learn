package com.lwc.springbootminio.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: liwencai
 * @Date: 2022/9/25 21:14
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinIoUploadVo implements Serializable {

    //对象桶名
    private String bucketName;

    //文件真实名称
    private String fileRealName;

    //文件名称
    private String minFileName;

    //文件路径
    private String minFileUrl;
}