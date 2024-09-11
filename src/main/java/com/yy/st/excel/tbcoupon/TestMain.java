package com.yy.st.excel.tbcoupon;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.alibaba.excel.EasyExcel;

/**
 * @author yuyou
 * @since 2023/5/12 17:30
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        String compare = "TN20201124236202301180000000001,TN2022042500864202212170000000305,TN2022042500864202301050000000589,TN20201124744202301220000000021,TN20201124744202301220000000041,TN2022042500864202301120000000508,TN2022042500864202301170000000090,TN20201124629202301110000001178,TN20201124629202301250000001223,TN2022042500864202301240000000157,TN20201124744202301300000000111,TN2022042500864202301300000000348,TN2022042500864202301160000000303,TN20201124629202301180000001728,TN2022042500864202301030000001115,TN2022042500864202212220000000550,TN2022042500864202302010000000166,TN2022042500864202303220000000046,TN2022042500864202301250000000046,TN20201124629202301110000001133,TN2022042500864202212140000000589,TN2022042500864202301200000000301,TN2022042500864202302230000000254,TN2022042500864202302280000000108,TN2022042500864202301100000000321,TN2022042500864202301120000000062,TN2022042500864202302280000000109";

        String tradeNo = "33011768781371745034";
        Integer base = 30;
        List<String> compares = Arrays.asList(compare.split(","));
        TbCouponLister tbCouponLister = new TbCouponLister();
        EasyExcel.read("/Users/yuyou/Desktop/ldata.xlsx", TbCouponDto.class, tbCouponLister).sheet().doRead();

        CouponLister couponLister = new CouponLister();
        EasyExcel.read("/Users/yuyou/Desktop/cl.xlsx", CouponDto.class, couponLister).sheet().doRead();
        List<CouponDto> couponDtos = couponLister.getCouponDtos();
        Map<String, CouponDto> couponDtoMap = couponDtos.stream().collect(Collectors.toMap(CouponDto::getCouponLibraryNo, Function.identity(), (k1, k2) -> k2));
        StringJoiner stringJoiner = new StringJoiner(",");
        StringJoiner noJoiner = new StringJoiner(",");
        FileWriter fileWriter = new FileWriter("/Users/yuyou/Desktop/result.txt");
        for (TbCouponDto tbCouponDto : tbCouponLister.getCouponDtos()) {
            CouponDto couponDto = couponDtoMap.get(tbCouponDto.getCouponLibraryNo());
            if (!compares.contains(tbCouponDto.getCouponLibraryNo())) {
                String baseTradeNo = tradeNo + base;
                String s = "insert into tb_coupon_consumption_record(trade_no,out_trade_no,source_order_no,source_outer_id,coupon_library_no,order_channel,state,trade_time,cancel_state,cancel_time_stamp,retry_times) " +
                        "values('" + baseTradeNo + "','" + baseTradeNo + "','" + tbCouponDto.getOrderNo() + "','" + tbCouponDto.getOuterId() + "','" + tbCouponDto.getCouponLibraryNo() + "',1,0,'" + couponDto.getUsedAt() + "',0,0,0);\n";
                stringJoiner.add("'" + baseTradeNo + "'");
                noJoiner.add("'" + tbCouponDto.getCouponLibraryNo() + "'");
                System.out.println(s);
                fileWriter.write(s);
                base++;
            }
        }
        fileWriter.flush();

        System.out.println(stringJoiner);
        System.out.println(noJoiner);

    }
}
