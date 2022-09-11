package com.yy.st.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author yuyou
 * @date 2022/5/10 17:04
 */
@Data
public class TranslationDto {
    @ExcelProperty(index = 0)
    private Integer id;

    @ExcelProperty(index = 1)
    private String language;

    @ExcelProperty(index = 2)
    private String value;

}
