package com.yy.st.excel.tbcoupon;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

/**
 * @author yuyou
 * @since 2022/10/31 22:08
 */
@Data
public class CouponDto {


    @ExcelProperty(index = 0)
    private String id;

    @ExcelProperty(index = 15)
    private String usedAt;
    @ExcelProperty(index = 19)
    private String couponLibraryNo;

}
