package com.yy.st.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author yuyou
 * @date 2022/5/6 16:17
 */
@Data
public class ProductDto {
    @ExcelProperty(index = 0)
    private String productId;
}
