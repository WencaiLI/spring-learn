package com.lwc.springbootemail.service.impl;

import com.lwc.springbootemail.dto.Attachment;
import com.lwc.springbootemail.dto.MailDTO;
import com.lwc.springbootemail.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: liwencai
 * @Date: 2022/7/24 16:09
 * @Description:
 */
@Service("simpleUse")
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    /**
     * @Author: liwencai
     * @Description: 发送普通邮件
     * @Date: 2022/7/24
     * @Param map:
     * @return: void
     */
    @Override
    public void sendSimpleMail(Map<String,Object> map) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        /* 邮件发送方 */
        mailMessage.setFrom(Sender);

        /* 邮件接收方 */
        // to 可为可变长参数，String类型，可使用String数组传值。示例：
        // String[] to = {"1491269442@qq.com","6933036626@qq.com"};
        mailMessage.setTo(map.get("to").toString());

        /* 邮件抄送方*/
        // Carbon Copy,carbonCopy可为可变长参数，String类型，可使用String数组传值。示例 ：
        // String[] carbonCopy = {"1491269442@qq.com","6933036626@qq.com"};
        mailMessage.setCc(map.get("carbonCopy").toString());

        /* 密件抄送 如果将收件人姓名添加到电子邮件的“Bcc”（密件抄送）框中，
        则会将邮件的副本发送给指定的收件人。
        添加到密件抄送框的任何收件人都不会显示给接收该邮件的任何其他收件人。 */
        // Blind Carbon Copy,blindCarbonCopy可为可变长参数，String类型，可使用String数组传值。示例 ：
        // String[] blindCarbonCopy = {"1491269442@qq.com","6933036626@qq.com"};
        mailMessage.setBcc(map.get("blindCarbonCopy").toString());

        /* 回复 如果为回复邮件而不是发送的简单邮件不需要此属性 */
        mailMessage.setReplyTo(map.get("to").toString());

        /* 发送日期 */
        mailMessage.setSentDate(new Date());

        /* 邮件主题 */
        mailMessage.setSubject(map.get("subject").toString());

        /* 邮件正文 */
        mailMessage.setText(map.get("text").toString());

        mailSender.send(mailMessage);
    }

    /**
     * @Author: liwencai
     * @Description: 发送Html邮件
     * @Date: 2022/7/24
     * @Param map:
     * @return: void
     */
    @Override
    public void sendHtmlMail(Map<String,Object> map) {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo(map.get("to").toString());
            helper.setSubject(map.get("subject").toString());
            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题-h1</h1>")
                    .append("<p style='color:#F00'>红色字</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(sb.toString(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }


    /**
     * @Author: liwencai
     * @Description: 发送带附件的邮件（从本机文件中）
     * @Date: 2022/7/24
     * @Param map:
     * @return: void
     */
    @Override
    public void sendAttachmentsMailByLocalFile(MailDTO mailDTO) {
        MimeMessage message;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo(mailDTO.getTo().toArray(new String[0]));
            helper.setSubject(mailDTO.getSubject());
            helper.setText(mailDTO.getText());
            /* 添加附件 */
            if (mailDTO.getAttachments() != null) {
                for (Attachment attachment : mailDTO.getAttachments()) {
                    FileSystemResource file = new FileSystemResource(new File(attachment.getFilePath()));
                    helper.addAttachment(attachment.getFileName(), file);
                }
            }
            mailSender.send(message);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @Author: liwencai
     * @Description: 发送静态资源邮件
     * @Date: 2022/7/24
     * @Param map:
     * @return: void
     */
    @Override
    public void sendInlineMail(Map<String,Object> map) {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo((String) map.get("to"));
            helper.setSubject(map.get("subject").toString());
            /* 第二个参数指定发送的是HTML格式,同时cid:是固定的写法 */
            helper.setText("<html><body>带静态资源的邮件内容 图片:<img src='cid:picture' /></body></html>", true);
            FileSystemResource file = new FileSystemResource(new File("D:\\images\\upload\\img\\2022-07-18\\9f586bd549d54dfe9ff225591736fe97.jpeg"));
            helper.addInline("picture",file);
        } catch (Exception e){
            e.printStackTrace();
        }
        mailSender.send(message);
    }

    /**
     * @Author: liwencai
     * @Description: 发送模板邮件
     * @Date: 2022/7/24
     * @Param map:
     * @return: void
     */
    @Override
    public void sendTemplateMail(Map<String,Object> map) {
        String[] filePath = new String[]{"D:\\Temp\\picture.jpg", "D:\\Temp\\picture1.jpg"};
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("content", "邮件内容");
        valueMap.put("filePathList", filePath);

        MimeMessage mimeMessage = null;
        try {
            mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(Sender);
            helper.setTo((map.get("to").toString()));
            helper.setSubject(map.get("subject").toString());

            Context context = new Context();
            context.setVariables(map);
            String content = this.templateEngine.process("mail.html", context);
            helper.setText(content, true);

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
