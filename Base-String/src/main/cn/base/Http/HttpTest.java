package cn.base.Http;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;



import java.util.HashMap;

/**
 * @program: BasePromotion
 * @description: 充值接口测试
 * @author: yarne
 * @create: 2019-07-29 11:43
 **/
public class HttpTest {

    static String token;

    static {
        token=getToken();
    }

    static String getToken() {
        HashMap paramHashMap = new HashMap(5);
        paramHashMap.put("grant_type", "password");
        paramHashMap.put("Password", "tEstApI$58EON");
        paramHashMap.put("username", "ApiTesterOne");

        String post= HttpUtil.post("https://api.topup.com.mm/Token", paramHashMap,-1);
        JSONObject jsonObject = JSONUtil.parseObj(post);
        return (String) jsonObject.get("access_token");
    }

    static String TopUp(long OrderNumber) {
        String url = "https://api.topup.com.mm/api/v2/topupTest";

        HashMap paramHashMap = new HashMap(5);
        paramHashMap.put("PhoneNumber", "09799654552");
        paramHashMap.put("Amount", "1000");
        paramHashMap.put("OrderNumber", OrderNumber);

        HashMap headers = new HashMap(5);
        headers.put("Authorization", "Bearer ".concat(token));

        HttpRequest post = HttpUtil.createPost(url);
        post.addHeaders(headers);
        return post.form(paramHashMap).timeout(-1).execute().body();
    }

    static String inQuiryTopUp(long OrderNumber) {
        String url = "https://api.topup.com.mm/api/v2/enquiryTest";
        HashMap paramHashMap = new HashMap(5);
        paramHashMap.put("OrderNumber", OrderNumber);

        HashMap headers = new HashMap(5);
        headers.put("Authorization", "Bearer ".concat(token));

        HttpRequest post = HttpUtil.createPost(url);
        post.addHeaders(headers);
        return post.form(paramHashMap).timeout(-1).execute().body();
    }

    static String inQuiryBanlance(String token) {
        String url ="https://api.topup.com.mm/api/balance";

        HashMap headers = new HashMap(5);
        headers.put("Authorization", "Bearer ".concat(token));

        HttpRequest post = HttpUtil.createPost(url);
        post.addHeaders(headers);
        return post.form(new HashMap(2)).timeout(-1).execute().body();
    }


    public static void main(String[] args) {
        long OrderNumber = System.currentTimeMillis();
        System.out.println("OrderNumber: "+(OrderNumber));

        System.out.println("开始充值");
        String formatTopUpData = XmlUtil.format(TopUp(OrderNumber));
        System.out.println(formatTopUpData);

        System.out.println("开始查询充值");
        String formatEnquriyTopUp = XmlUtil.format(inQuiryTopUp(OrderNumber));
        System.out.println(formatEnquriyTopUp);

        System.out.println("开始查询余额");
        String formatEnquriyBanlance = XmlUtil.format(inQuiryBanlance(token));
        System.out.println(formatEnquriyBanlance);
    }
}
