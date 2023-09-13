package com.yy.st.excel.couponcate;

import com.alibaba.excel.EasyExcel;
import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 优惠券模版缓存刷新
 * @author yuyou
 * @since 2023/6/5 17:32
 */
public class ExcelMain {


    public static void main(String[] args) throws IOException {
        String mapper = "TN20181130041:88,TN20181130059:99,TN20181130082:110,TN20181130088:91,TN20181130099:96,TN20181130251:74,TN20181130255:76,TN20181130318:101,TN20181130379:73,TN20181130399:92,TN20181130462:86,TN20181130483:103,TN20181130608:94,TN20181130618:100,TN20181130623:77,TN20181130651:85,TN20181130664:89,TN20181130666:111,TN20181130667:93,TN20181130740:97,TN20181130768:75,TN20181130773:102,TN20181130792:87,TN20181130806:98,TN20181130910:90,TN20181130924:95,TN20181130933:78,TN20190424460:1305,TN20190424571:1308,TN20190424581:1309,TN20190424634:1306,TN20190424686:1303,TN20190424867:1307,TN20190424987:1304,TN20200408001:3000,TN20200408002:3001,TN20200408003:3002,TN20200408004:3003,TN20200408005:3005,TN20200408006:3004,TN20200408007:3006,TN20200408008:3007,TN20200408009:3008,TN20200408010:3009,TN20200408011:3010,TN20200408012:3011,TN20200408013:3012,TN20200408014:3013,TN20200408015:3014,TN20200408016:3015";
        Map<String,Integer> map = Arrays.stream(mapper.split(",")).collect(Collectors.toMap(item -> item.split(":")[0],
                item -> Integer.valueOf(item.split(":")[1]),
                (k1, k2) -> k2));
        System.out.println(map);

        CouponCatLister couponCatLister = new CouponCatLister();
        EasyExcel.read("/Users/yuyou/Downloads/0831-星球会员劵模板分类调整事项(1).xlsx", CouponCatDto.class, couponCatLister).sheet().doRead();
        FileWriter fileWriter = new FileWriter("/Users/yuyou/Desktop/result.txt");
        for (CouponCatDto couponCatDto : couponCatLister.getCouponCatDtos()) {
            String categoryIds = couponCatDto.getCategoryIds();
            if (StringUtils.isBlank(categoryIds)) {
                continue;
            }
            String couponNo = couponCatDto.getNo();
            Integer couponId = map.get(couponNo);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("update coupons set category_limit = 1 where no = '"  + couponNo + "';\n");
            stringBuffer.append("delete from coupon_categories where coupon_id = " + couponId + ";\n");
            for (String categoryId : categoryIds.split(",")) {
                stringBuffer.append("insert into coupon_categories(coupon_id, sku_category_id) values(" + couponId + "," + categoryId + ");\n");
            }
            stringBuffer.append("\n");
            System.out.print(stringBuffer);
            fileWriter.write(stringBuffer.toString());
        }

        fileWriter.flush();
    }
}
