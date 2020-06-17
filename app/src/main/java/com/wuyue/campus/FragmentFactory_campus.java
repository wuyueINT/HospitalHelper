package com.wuyue.campus;

public class FragmentFactory_campus {


    public static <T extends Product_campus> T createProduct(String s){

        Product_campus product_campus = null;
        Class clz;
        if (s.equals("活动通知")) {
            clz = Fragment_activity.class;
        } else {
            clz = Fragment_partner.class;
        }

        try {
            product_campus = (Product_campus) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) product_campus;

    }


}
