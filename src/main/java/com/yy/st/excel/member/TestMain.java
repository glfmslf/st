package com.yy.st.excel.member;

import java.io.FileWriter;
import java.io.IOException;

import com.alibaba.excel.EasyExcel;

/**
 * @author yuyou
 * @since 2023/5/12 17:30
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        Integer index = 1000;
        String pre = "TN202305110768520230511000000";

        userLister userLister = new userLister();
        EasyExcel.read("/Users/yuyou/Downloads/补齐用户数据.xlsx", UserDto.class, userLister).sheet().doRead();
        FileWriter fileWriter = new FileWriter("/Users/yuyou/Desktop/result.txt");
        FileWriter codeFile = new FileWriter("/Users/yuyou/Desktop/codeId.txt");
        for (UserDto userDto : userLister.getUserDtos()) {
            index++;
            String codeId = pre + index;
            String s = "insert into coupon_librarys (name, user_id, channel, order_id, coupon_id, coupon_no, policy, policy_rule, " +
                    "source_id, source_type, period_start, period_end, used_at, status, code, tab, code_id, use_limit, discount_fee, created_at, " +
                    "updated_at, deleted_at, interval_time, coupon_grands_id, card_id, card_no, used_at_time_stamp, region, source,  sale_amount, " +
                    "channel_type, user_main_id, remark, sale_batch_no, temp_flag) values  ( '5.13会员日赠饮券'," + userDto.getUserId() + ", \'" + userDto.getChannel()+"\', " +
                    "0, 4279, " +
                    "'TN202139501'," +
                    " " +
                    "'App\\\\Policies\\\\CouponLibrary\\\\FeeCouponPolicy', '{\"valen\":0,\"cup_type\":1,\"cup\":1}', 4279, " +
                    "'App\\\\Models\\\\Coupon', '2023-05-13 00:00:00', '2023-05-31 23:59:59', null, 1, null, 1, \'" + codeId + "\', 0, 0.00, now()," +
                    " now()," +
                    " " +
                    "null, '1', 0, " + userDto.getCardId() + ", null, now(), 'CN', 0,  null, 0, " + userDto.getUserMainId() + ", null, null, 0);\n";
            System.out.print(s);
            fileWriter.write(s );
            codeFile.write(codeId + "\n");
        }
        codeFile.flush();
        fileWriter.flush();
    }
}
