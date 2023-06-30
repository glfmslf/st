package com.yy.st.excel.couponcate;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

/**
 * @author yuyou
 * @since 2022/10/31 22:08
 */
@Data
public class CouponCatDto {

    @ExcelProperty(index = 3)
    private String no;
    @ExcelProperty(index = 7)
    private String categoryIds;


}
