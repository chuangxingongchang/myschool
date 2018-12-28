package com.school.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.school.entity.TUser;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SendCode {
    static Logger log = LoggerFactory.getLogger(SendCode.class);
    public static boolean sendCode(TUser user, int random) {
        //短信应用SDK AppID 1400开头
        int appid = 1400173396;
        //短信应用SDK AppKey
        String appkey = "126b706372967dbac87d20b1bb865d92";
        //需要发送短信的手机号码
        String[] phoneNumbers = {user.getPhoneno()};
        System.out.println(phoneNumbers[0]);
        try {
            SmsSingleSender sender = new SmsSingleSender(appid,appkey);
            SmsSingleSenderResult result = sender.send(0,"86",phoneNumbers[0],"【腾讯云】您的验证码是:"+random,"","");
            return true;
        }catch (JSONException | IOException e){
            log.info(e.toString());
            return  false;
        } catch (HTTPException e) {
            log.info(e.toString());
            return false;
        }
    }
}
