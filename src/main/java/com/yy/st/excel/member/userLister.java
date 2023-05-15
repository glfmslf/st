package com.yy.st.excel.member;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyou
 * @since 2022/10/31 22:11
 */
@Data
public class userLister extends AnalysisEventListener<UserDto> {

    List<UserDto> userDtos = new ArrayList<>();
    @Override
    public void invoke(UserDto userDto, AnalysisContext analysisContext) {
        userDtos.add(userDto);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
