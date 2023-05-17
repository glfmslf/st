package com.yy.st.excel.coupon;

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
public class CouponLister extends AnalysisEventListener<CouponDto> {

    List<CouponDto> couponDtos = new ArrayList<>();
    @Override
    public void invoke(CouponDto userDto, AnalysisContext analysisContext) {
        couponDtos.add(userDto);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
