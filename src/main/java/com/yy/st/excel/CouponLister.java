package com.yy.st.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyou
 * @date 2022/4/25 10:49
 */
@Data
public class CouponLister extends AnalysisEventListener<CouponHeadDto> {
    List<CouponHeadDto> couponHeadDtos = new ArrayList<>();
    @Override
    public void invoke(CouponHeadDto couponHeadDto, AnalysisContext analysisContext) {
        couponHeadDtos.add(couponHeadDto);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

}
