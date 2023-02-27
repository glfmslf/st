package com.yy.st.excel;

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
public class CouponNoLister extends AnalysisEventListener<CouponNoDto> {

    List<CouponNoDto> productDtos = new ArrayList<>();
    @Override
    public void invoke(CouponNoDto productDto, AnalysisContext analysisContext) {
        productDtos.add(productDto);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
