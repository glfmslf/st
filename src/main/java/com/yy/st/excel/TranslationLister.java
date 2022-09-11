package com.yy.st.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyou
 * @date 2022/5/10 17:06
 */
@Data
public class TranslationLister extends AnalysisEventListener<TranslationDto> {
    List<TranslationDto> translationDtoList = new ArrayList<>();
    @Override
    public void invoke(TranslationDto translationDto, AnalysisContext analysisContext) {
        translationDtoList.add(translationDto);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
