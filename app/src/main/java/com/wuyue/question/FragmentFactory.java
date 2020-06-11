package com.wuyue.question;

public class FragmentFactory {


    public static <T extends Product> T createProduct(String s){

        Product p = null;
        Class clz;
        switch (s){
            case "回答":
                clz = Fragment_ans.class;
                break;
            case "提问":
                clz = Fragment_ques.class;
                break;
            case "查找":
                clz = Fragment_query.class;
                break;
            default:
                clz = null;
        }
        try {
            p = (Product) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) p;
    }

}
