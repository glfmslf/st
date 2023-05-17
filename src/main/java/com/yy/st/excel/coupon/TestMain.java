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
        EasyExcel.read("/Users/yuyou/Downloads/520券-可用商品范围.xlsx", CouponDto.class, couponLister).sheet().doRead();
        FileWriter fileWriter = new FileWriter("/Users/yuyou/Desktop/result.txt");
        for (int couponId : couponIds) {
            for (CouponDto couponDto : couponLister.getCouponDtos()) {
                if ("32000021".equals(couponDto.getSkuNo())) {
                    continue;
                }
                String s = "insert into coupon_products (coupon_id,sku_no) values(" + couponId + ",'" + couponDto.getSkuNo() + "');\n";
                System.out.print(s);
                fileWriter.write(s );
            }
        }
        fileWriter.flush();
    }
}
