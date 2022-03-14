package com.cest.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * 发送短信DTO
 */
@Data
@Builder(toBuilder = true)
public class SmsDTO {

    /**手机号**/
    private String mobile;
    /**短信验证码**/
    private String verificationCode;
}
