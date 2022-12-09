package com.yy.st.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author yuyou
 * @since 2022/12/7 19:58
 */
@Data
public class DyDisDto {
    @ExcelProperty(index = 0)
    private Integer id;
    @ExcelProperty(index = 1)
    private String outerId;
    @ExcelProperty(index = 2)
    private String couponLibraryNo;
}
