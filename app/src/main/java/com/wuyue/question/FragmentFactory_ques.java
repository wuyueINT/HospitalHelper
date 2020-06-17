package com.wuyue.question;

public class FragmentFactory_ques {


    public static <T extends Product_ques> T createProduct(String s){

        Product_ques p = null;
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
            p = (Product_ques) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) p;
    }

}
