package com.lwc;

import lombok.Data;

import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;

/**
 * @author liwencai
 * @since 2023/6/2
 */
@Data
public class UserInsertReq {
    @NotBlank(message = "id不能为空！",groups = {ValidateGroup.Update.class})
    private Long id;
    @NotBlank(message = "用户名不能为空！",groups = {ValidateGroup.Insert.class,ValidateGroup.Update.class})
    private String username;
    @NotBlank(message = "密码不能为空！",groups = {ValidateGroup.Insert.class})
    private String password;
    @NotBlank(message = "邮箱不能为空！")
    @Email(message = "邮箱格式错误！")
    private String email;
}
