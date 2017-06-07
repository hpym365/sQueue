package com.senyint.squeue.util;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-6 下午3:45
 */
public class StringUtils {
    /**
     * @param underscoreName the underscore name
     * @return the string
     * @Version 1.0
     * @Date 20170606 15:46:45
     * @Author hpym365 @gmail.com
     * @Description Camel  case name string.  下划线转驼峰
     */
    public static String camelCaseName(String underscoreName) {

        if(underscoreName.indexOf("_") == -1)
            return underscoreName;

        StringBuilder result = new StringBuilder();
        if (underscoreName != null && underscoreName.length() > 0) {
            boolean flag = false;
            for (int i = 0; i < underscoreName.length(); i++) {
                char ch = underscoreName.charAt(i);
                if ("_".charAt(0) == ch) {
                    flag = true;
                } else {
                    if (flag) {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                    } else {
                        result.append(Character.toLowerCase(ch));
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str="AbC_Ddf_EF_dfdf";
        System.out.println(camelCaseName(str));
    }
}
