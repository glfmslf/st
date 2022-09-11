package com.yy.st.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyou
 * @date 2022/5/6 16:18
 */
@Data
public class ProductLister extends AnalysisEventListener<ProductDto> {

    List<ProductDto> productDtos = new ArrayList<>();
    List<String> productIds = new ArrayList<>();
    @Override
    public void invoke(ProductDto productDto, AnalysisContext analysisContext) {
        if (!productIds.contains(productDto.getProductId())) {
            productIds.add(productDto.getProductId());
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
