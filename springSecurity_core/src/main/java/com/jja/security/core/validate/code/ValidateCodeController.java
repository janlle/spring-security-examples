package com.jja.security.core.validate.code;

import com.jja.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Mr.ruolin
 * @createBy: 2018-02-19 19:54
 **/
@RestController()
public class ValidateCodeController {

    @Autowired
    @Qualifier(value = "imageCodeGenerator")
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    @Qualifier(value = "smsCodeGenerator")
    private ValidateCodeGenerator smsCodeGenerator;

    @Autowired
    private SmsCodeSender smsCodeSender;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";


    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = (ImageCode)imageCodeGenerator.generate(new ServletWebRequest(request, response));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        ImageIO.write(imageCode.getBufferedImage(),"JPEG", response.getOutputStream());
    }

    @GetMapping("/code/sms")
    public void createSms(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ValidateCode smsCode = smsCodeGenerator.generate(new ServletWebRequest(request, response));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, smsCode);
        String mobile = ServletRequestUtils.getRequiredStringParameter(request,"mobile");
        smsCodeSender.send(mobile, smsCode.getCode());
    }

}
