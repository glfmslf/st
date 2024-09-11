package com.yy.st;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yuyou
 * @since 2023/6/15 17:52
 */
public class MainTest {
    public static void main(String[] args) {
        String s = "coupon:package:purchase:incr:record:{userMainId}:{orderNo}";
        System.out.println(String.format(s, 2222, "3333"));
        MessageFormat messageFormat = new MessageFormat(s);
        Object[] objects = new Object[]{2222, "33333"};
        System.out.println(messageFormat.format(objects).toString());
    }

    private static boolean isCouponNameChartest(String[] strings,String couponRegex) {
        if(StringUtils.isEmpty(couponRegex)){
            return true;
        }
        Pattern p = Pattern.compile(couponRegex);
        for(String str : strings){
            Matcher matcher = p.matcher(str);
            boolean b = matcher.find();
            if(b){
                return true;
            }
        }
        return false;
    }

}
