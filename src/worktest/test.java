package worktest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class test {


    public static void main(String[] args) {
//        BigDecimal originalPrice = new BigDecimal(1);
//        BigDecimal discount = new BigDecimal(0.01);
//        BigDecimal discountPrice = originalPrice.multiply(discount)
//                .setScale(2, RoundingMode.HALF_UP);
//        int discountCentPrice = discountPrice.movePointRight(2).intValue();
//        System.out.println(discountPrice);
//        System.out.println(discountCentPrice);


        //cauculateRoomBackgroudRules2(3, 20, 5, false, 999);

        //cauculateRoomBackgroudRules2(5, 30, 6, false, 999);

        cauculateRoomBackgroudRules2(7, 40, 7, false, 999);

        //cauculateRoomBackgroudRules2(9, 50, 8, false, 999);

        //cauculateRoomBackgroudRules2(11, 70, 8, true, 999);

        //cauculateRoomBackgroudRules2(15, 90, 8, true, 999);


//        topupDO.setChannel(channel);

        //System.out.println(getDecimalPrice(9));


    }

    public static String getDecimalPrice(int price) {
        String priceStr = String.valueOf(price);
        String result = priceStr.substring(0, priceStr.length() - 2) + "." + priceStr.substring(priceStr.length() - 2);
        return result;
    }

    public static String intTostring(int price) {
        BigDecimal priceDecimal = new BigDecimal(price);
        BigDecimal result = priceDecimal.divide(BigDecimal.valueOf(100), 2, RoundingMode.CEILING);
        return result.toString();
    }

    private String cauculateRoomBackgroudRules(int DYNAMIC_NOR_FIRST, int DYNAMIC_NOR_END, int DYNAMIC_NOR_LEVEL, boolean maxLimit) {
        List<Integer> rules = new ArrayList<>();
        List<Integer> limit = new ArrayList<>();
        rules.add(0);
        rules.add(3);
        for (int i = 0; i < 8; i++) {
            Random random = new Random();
            int result = random.nextInt(5) + 5;
            int sum = rules.get(rules.size() - 1);
            result = result + sum;
            rules.add(result);
        }
        limit.add(0);
        limit.add(DYNAMIC_NOR_FIRST);
        int nextRule = 2;
        while (nextRule < DYNAMIC_NOR_LEVEL) {
            limit.add((rules.get(nextRule) * DYNAMIC_NOR_END) / rules.get(DYNAMIC_NOR_LEVEL));
            nextRule = nextRule + 1;
        }
        limit.add(DYNAMIC_NOR_END);
        if (maxLimit) {
            limit.add(999);
        }
        return limit.toString().replace("[", "").replace("]", "").replace(" ", "");
    }


    public static String cauculateRoomBackgroudRules2(int DYNAMIC_NOR_FIRST, int DYNAMIC_NOR_END, int DYNAMIC_NOR_LEVEL, boolean maxLimit, int max) {
        List<Integer> rules = new ArrayList<>();
        List<Integer> limit = new ArrayList<>();
        rules.add(0);
        rules.add(DYNAMIC_NOR_FIRST);
        for (int i = 0; i < 8; i++) {
            Random random = new Random();
            int result = random.nextInt(10) + 1;
            int sum = rules.get(rules.size() - 1);
            result = result + sum;
            rules.add(result);
        }
        limit.add(0);
        limit.add(DYNAMIC_NOR_FIRST);
        int nextRule = 2;
        while (nextRule < DYNAMIC_NOR_LEVEL) {
            limit.add((rules.get(nextRule) * DYNAMIC_NOR_END) / rules.get(DYNAMIC_NOR_LEVEL));
            nextRule = nextRule + 1;
        }
        limit.add(DYNAMIC_NOR_END);
        if (maxLimit) {
            limit.add(999);
        }
        System.out.println(limit);
        return limit.toString().replace("[", "").replace("]", "").replace(" ", "");


        //        List<Integer> rules = new ArrayList<>();
//        rules.add(0);
//        rules.add(3);
//        for (int i = 0; i < 8; i++) {
//            Random random= new Random();
//            int result = random.nextInt(10) + 1;
//            int sum = rules.get(rules.size()-1);
//            System.out.println(result + "---" + sum);
//            result = result + sum;
//            rules.add(result);
//        }
//        int third = (rules.get(2) * 20) / rules.get(5);
//        int four = (rules.get(3) * 20) / rules.get(5);
//        int five = (rules.get(4) * 20) / rules.get(5);
//        rules.add(third);
//        rules.add(four);
//        rules.add(five);


//        List<Integer> rules = new ArrayList<>();
//        List<Integer> limit = new ArrayList<>();
//        rules.add(0);
//        rules.add(3);
//        for (int i = 0; i < 8; i++) {
//            Random random= new Random();
//            int result = random.nextInt(10) + 1;
//            int sum = rules.get(rules.size()-1);
//            result = result + sum;
//            rules.add(result);
//        }
//        int third = (rules.get(2) * 20) / rules.get(5);
//        int four = (rules.get(3) * 20) / rules.get(5);
//        int five = (rules.get(4) * 20) / rules.get(5);
//        limit.add(0);
//        limit.add(3);
//        limit.add(third);
//        limit.add(four);
//        limit.add(five);
//        limit.add(20);
//
//        String a = rules.toString().replace("[","").replace("]","").replace(" ","");
        //         System.out.println(limit);
//        System.out.println(four);
//        System.out.println(five);
//        System.out.println(rules);

//        List<String> idsStringList = Arrays.asList(a.split(","));
//        System.out.println(idsStringList);
//        List<Integer> codesInteger = idsStringList.stream().map(Integer::parseInt).collect(Collectors.toList());
//        System.out.println(codesInteger);
        //return org.apache.commons.lang.StringUtils.join(rules,",");
    }
}
//level  3-6
