package io.hanshin.datamodel.utils;

public class MaskingUtil {

    public static String phoneMasking(String phone){
        StringBuffer stringBuffer = new StringBuffer( phone );
        return stringBuffer.replace( phone.length()-2, phone.length()-1, "**" ).toString();
    }
}
