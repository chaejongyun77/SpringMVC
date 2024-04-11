package org.fullstack4.chap01.util;

public class CommonUtils {
    public int requiredInput(String word) {

        if (word.isEmpty() || word.equals("null")) {
            return 1;
        }
        return 0;
    }

    public int requiredInputArr(String[] arr) {

        if ( arr==null ||arr.length==0 ) {
            return 1;
        }
        return 0;

    }
}
