package com.lwc.springbootemail.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: liwencai
 * @Date: 2022/7/24 18:42
 * @Description:
 */
@Data
public class MailDTO implements Serializable {
    private String from; // 邮件发送方
    private List<String> to; // 邮件接收方
    private List<String> carbonCopy; // 抄送人
    private List<String> blindCarbonCopy; // 密件抄送
    private String subject; // 邮件主题
    private String text; // 邮件内容
    private List<Attachment> attachments; // 附件信息
}
