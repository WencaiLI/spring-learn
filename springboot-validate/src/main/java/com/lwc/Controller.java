package com.lwc;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;

/**
 * @author liwencai
 * @since 2023/6/2
 */
@RestController
@RequestMapping("/springboot-validate")
public class Controller {
    @PostMapping("/test")
    public JsonResult test(@RequestParam @NotBlank(message = "用户id不能为空！") String userId){
        // ...
        return JsonResult.success();
    }

    @PostMapping("/insert")
    public JsonResult insert(@RequestBody @Validated({ValidateGroup.Insert.class, Default.class })UserInsertReq userInsertReq){
        // ...
        return JsonResult.success();
    }

    @PostMapping("/update")
    public JsonResult update(@RequestBody @Validated(ValidateGroup.Update.class) UserInsertReq userInsertReq){
        // ...
        return JsonResult.success();
    }
}
