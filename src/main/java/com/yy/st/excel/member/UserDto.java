package com.yy.st.excel.member;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author yuyou
 * @since 2022/10/31 22:08
 */
@Data
public class UserDto {

    @ExcelProperty(index = 0)
    private Long userMainId;

    @ExcelProperty(index = 1)
    private String cardId;
    @ExcelProperty(index = 2)
    private Integer userId;
    // @ExcelProperty(index = 3)
    // private String channel;

}
