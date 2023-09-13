package com.yy.st.excel.coupon;

import com.alibaba.excel.EasyExcel;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author yuyou
 * @since 2023/5/12 17:30
 */
public class TestMain {
    public static int[] couponIds = {11002, 11003, 11004, 11005, 11006, 11008, 11009};
    public static void main(String[] args) throws IOException {
        CouponLister couponLister = new CouponLister();
        EasyExcel.read("/Users/yuyou/Desktop/coupon_r.xlsx", CouponDto.class, couponLister).sheet().doRead();
        FileWriter fileWriter = new FileWriter("/Users/yuyou/Desktop/result.txt");
        for (CouponDto couponDto : couponLister.getCouponDtos()) {

            String s = "update coupon_librarys set status = 2,order_no =  '" + couponDto.getOrderNo() + "',order_id = " + couponDto.getOrderId() +
                    ",used_at = '" + couponDto.getUsedAt() + "' where id = " + couponDto.getId() + ";";
            System.out.println(s);

        }
        fileWriter.flush();
    }
}
