package com.yy.st.excel.doudian;

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
public class ConsumptionLister extends AnalysisEventListener<ConsumptionDto> {

    List<ConsumptionDto> consumptionDtos = new ArrayList<>();
    @Override
    public void invoke(ConsumptionDto consuptionDto, AnalysisContext analysisContext) {
        consumptionDtos.add(consuptionDto);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
