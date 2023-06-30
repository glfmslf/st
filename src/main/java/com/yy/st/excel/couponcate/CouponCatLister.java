package com.yy.st.excel.couponcate;

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
public class CouponCatLister extends AnalysisEventListener<CouponCatDto> {

    List<CouponCatDto> couponCatDtos = new ArrayList<>();
    @Override
    public void invoke(CouponCatDto couponCatDto, AnalysisContext analysisContext) {
        couponCatDtos.add(couponCatDto);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
