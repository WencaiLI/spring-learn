package com.lwc.springbootemail.controller;

import com.lwc.springbootemail.dto.MailDTO;
import com.lwc.springbootemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @Auther: liwencai
 * @Date: 2022/7/24 17:33
 * @Description:
 */
@RequestMapping("/springbootMail")
@RestController
public class EmailController {
    @Autowired
    @Qualifier("simpleUse")
    EmailService emailService;

    @RequestMapping(value = "/sendSimpleMail",method = RequestMethod.POST)
    public void sendSimpleMail(@RequestBody  Map<String,Object> map){
        System.out.println(map.toString());
        emailService.sendSimpleMail(map);
    }

    @RequestMapping(value = "/sendHtmlMail",method = RequestMethod.POST)
    public void sendHtmlMail(@RequestBody Map<String,Object> map){
        System.out.println(map.toString());
        emailService.sendHtmlMail(map);
    }

    @RequestMapping(value = "/sendAttachmentsMailByLocalFile",method = RequestMethod.POST)
    public void sendAttachmentsMailByLocalFile(@RequestBody MailDTO mailDTO){
        emailService.sendAttachmentsMailByLocalFile(mailDTO);
    }

    @RequestMapping(value = "/sendInlineMail",method = RequestMethod.POST)
    public void sendInlineMail(@RequestBody Map<String,Object> map){
        emailService.sendInlineMail(map);
    }

    @RequestMapping(value = "/sendTemplateMail",method = RequestMethod.POST)
    public void sendTemplateMail(@RequestBody Map<String,Object> map){
        emailService.sendTemplateMail(map);
    }
}
