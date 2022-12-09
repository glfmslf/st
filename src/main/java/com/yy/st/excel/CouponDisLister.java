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
public class CouponDisLister extends AnalysisEventListener<CouponDisDto> {

    List<CouponDisDto> productDtos = new ArrayList<>();
    @Override
    public void invoke(CouponDisDto productDto, AnalysisContext analysisContext) {
        productDtos.add(productDto);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
