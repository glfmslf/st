package com.yy.st.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author yuyou
 * @date 2022/4/25 10:42
 */
public class ExcelUtil {

    public static void main(String[] args) throws IOException {
//        couponSql();
//        couponLibrarySql();
//        couponRollBackSql();
//        couponLibraryRollbackSql();
//        getProductId();
//        getTranslationSql();
        getTranslationSqlTest();
    }

    public static void getTranslationSqlTest() throws IOException {
        TranslationLister translationLister = new TranslationLister();
        EasyExcel.read("/Users/yuyou/Documents/producttest.xlsx",TranslationDto.class,translationLister).sheet().doRead();
        List<TranslationDto> translationDtoList = translationLister.getTranslationDtoList();
        FileWriter fileWriter = new FileWriter("/Users/yuyou/Desktop/上线/多语言统一/sqltest.txt");
        for (TranslationDto translationDto : translationDtoList) {
            String str = "insert into i18n_translation(namespace, meta_type, meta_id, language, value) values('02', '0201', '" + translationDto.getId() + "', '" +
                    translationDto.getLanguage() + "', '" + translationDto.getValue() + "');\n";
            //            System.out.println(str);
            fileWriter.write(str);
        }
        TranslationLister translationLister1 = new TranslationLister();
        EasyExcel.read("/Users/yuyou/Documents/categorytest.xlsx", TranslationDto.class, translationLister1).sheet().doRead();
        List<TranslationDto> translationDtoList1 = translationLister1.getTranslationDtoList();
        System.out.println(translationDtoList1.size());
        for (TranslationDto translationDto : translationDtoList1) {
            String str =
                    "insert into i18n_translation(namespace, meta_type, meta_id, language, value) values('04', '0401', '" + translationDto.getId() + "', '" +
                            translationDto.getLanguage() + "', '" + translationDto.getValue() + "');\n";
            System.out.println(str);
            fileWriter.write(str);
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public static void getTranslationSql() throws IOException {
        TranslationLister translationLister = new TranslationLister();
        EasyExcel.read("/Users/yuyou/Documents/product.xlsx",TranslationDto.class,translationLister).sheet().doRead();
        List<TranslationDto> translationDtoList = translationLister.getTranslationDtoList();
        FileWriter fileWriter = new FileWriter("/Users/yuyou/Desktop/上线/多语言统一/sql.txt");
        for (TranslationDto translationDto : translationDtoList) {
            String str = "insert into i18n_translation(namespace, meta_type, meta_id, language, value) values('02', '0201', '" + translationDto.getId() + "', '" +
                    translationDto.getLanguage() + "', '" + translationDto.getValue() + "');\n";
//            System.out.println(str);
            fileWriter.write(str);
        }
        TranslationLister translationLister1 = new TranslationLister();
        EasyExcel.read("/Users/yuyou/Documents/category.xlsx", TranslationDto.class, translationLister1).sheet().doRead();
        List<TranslationDto> translationDtoList1 = translationLister1.getTranslationDtoList();
        System.out.println(translationDtoList1.size());
        for (TranslationDto translationDto : translationDtoList1) {
            String str =
                    "insert into i18n_translation(namespace, meta_type, meta_id, language, value) values('04', '0401', '" + translationDto.getId() + "', '" +
                    translationDto.getLanguage() + "', '" + translationDto.getValue() + "');\n";
            System.out.println(str);
            fileWriter.write(str);
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public static void getProductId() {
        ProductLister productLister = new ProductLister();
        EasyExcel.read("/Users/yuyou/Documents/product.xlsx", ProductDto.class, productLister).sheet().doRead();
        System.out.println(productLister.getProductIds());
        System.out.println(productLister.getProductIds().size());
        List<String> productIds = productLister.getProductIds();
        System.out.println(String.join(",", productIds));
    }

    public static void couponSql() {
        CouponLister couponLister = new CouponLister();
        EasyExcel.read("/Users/yuyou/Documents/coupon.xlsx", CouponHeadDto.class, couponLister).sheet().doRead();
        List<CouponHeadDto> couponHeadDtos = couponLister.getCouponHeadDtos();
        System.out.println(couponHeadDtos.size());
        for (CouponHeadDto couponHeadDto : couponHeadDtos) {
            JSONObject jsonObject = JSONObject.parseObject(couponHeadDto.getPolicy());
            JSONArray clsarr = jsonObject.getJSONArray("clsarr");
            Integer share = jsonObject.getInteger("share");
            List<String> strings = clsarr.toJavaList(String.class);
            if (share == 1 && !strings.contains("6")) {
                strings.add("6");
                JSONObject writeJson = new JSONObject();
                writeJson.put("share", share);
                writeJson.put("clsarr", strings);
                System.out.println("update coupons set policy_rule = '" + writeJson.toJSONString() + "' where id = " + couponHeadDto.getId() + ";");
            }
        }
    }

    public static void couponRollBackSql() {
        CouponLister couponLister = new CouponLister();
        EasyExcel.read("/Users/yuyou/Documents/test2.xlsx", CouponHeadDto.class, couponLister).sheet().doRead();
        List<CouponHeadDto> couponHeadDtos = couponLister.getCouponHeadDtos();
        System.out.println(couponHeadDtos.size());
        for (CouponHeadDto couponHeadDto : couponHeadDtos) {
            JSONObject jsonObject = JSONObject.parseObject(couponHeadDto.getPolicy());
            JSONArray clsarr = jsonObject.getJSONArray("clsarr");
            Integer share = jsonObject.getInteger("share");
            List<String> strings = clsarr.toJavaList(String.class);
            if (share == 1 && !strings.contains("6")) {
                System.out.println("update coupons set policy_rule='" + couponHeadDto.getPolicy() + "' where id=" + couponHeadDto.getId() + ";");
            }

        }
    }

    public static void couponLibrarySql() {
        CouponLister couponLister = new CouponLister();
        EasyExcel.read("/Users/yuyou/Documents/couponLibrary.xlsx", CouponHeadDto.class, couponLister).sheet().doRead();
        List<CouponHeadDto> couponHeadDtos = couponLister.getCouponHeadDtos();
        System.out.println(couponHeadDtos.size());
        for (CouponHeadDto couponHeadDto : couponHeadDtos) {
            JSONObject jsonObject = JSONObject.parseObject(couponHeadDto.getPolicy());
            JSONArray clsarr = jsonObject.getJSONArray("clsarr");
            Integer share = jsonObject.getInteger("share");
            List<String> strings = clsarr.toJavaList(String.class);
            if (share == 1 && !strings.contains("6")) {
                strings.add("6");
                JSONObject writeJson = new JSONObject();
                writeJson.put("share", share);
                writeJson.put("clsarr", strings);
                System.out.println("update coupon_librarys set policy_rule = '" + writeJson.toJSONString() + "' where coupon_id = " + couponHeadDto.getId() +
                        " and status in(0,1);");
            }
        }
    }

    public static void couponLibraryRollbackSql() {
        CouponLister couponLister = new CouponLister();
        EasyExcel.read("/Users/yuyou/Documents/couponLibrary.xlsx", CouponHeadDto.class, couponLister).sheet().doRead();
        List<CouponHeadDto> couponHeadDtos = couponLister.getCouponHeadDtos();
        System.out.println(couponHeadDtos.size());
        for (CouponHeadDto couponHeadDto : couponHeadDtos) {
            JSONObject jsonObject = JSONObject.parseObject(couponHeadDto.getPolicy());
            JSONArray clsarr = jsonObject.getJSONArray("clsarr");
            Integer share = jsonObject.getInteger("share");
            List<String> strings = clsarr.toJavaList(String.class);
            if (share == 1 && !strings.contains("6")) {
                System.out.println("update coupon_librarys set policy_rule='" + couponHeadDto.getPolicy() + "' where coupon_id=" + couponHeadDto.getId() + " and status in (0,1);");

            }
        }
    }
}
