package com.yy.st.excel.coupon;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author yuyou
 * @since 2022/10/31 22:08
 */
@Data
public class CouponDto {


    @ExcelProperty(index = 2)
    private String skuNo;


}
