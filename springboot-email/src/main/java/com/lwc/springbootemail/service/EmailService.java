package com.lwc.springbootemail.service;

import com.lwc.springbootemail.dto.MailDTO;

import java.util.Map;

/**
 * @Auther: liwencai
 * @Date: 2022/7/24 16:09
 * @Description:
 */
public interface EmailService {
    void sendSimpleMail(Map<String,Object> map);

    void sendHtmlMail(Map<String,Object> map);

    void sendAttachmentsMailByLocalFile(MailDTO mailDTO);

    void sendInlineMail(Map<String,Object> map);

    void sendTemplateMail(Map<String,Object> map);
}
