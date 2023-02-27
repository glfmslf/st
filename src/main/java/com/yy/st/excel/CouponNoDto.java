package com.yy.st.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author yuyou
 * @since 2022/10/31 22:08
 */
@Data
public class CouponNoDto {

    @ExcelProperty(index = 0)
    private String no;

    @ExcelProperty(index = 1)
    private String saleAmount;

}
