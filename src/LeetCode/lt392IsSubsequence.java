package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class lt392IsSubsequence {
    public static void main(String[] args) {
        isSubsequence("abc", "ahbgdc");

    }

    public static boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        if(ss.length == 0){
            return true;
        }
        char[] tt = t.toCharArray();
        int idxS = 0;
        int idxT = 0;
        for(idxT = 0 ; idxT < tt.length;idxT++){
            if(ss[idxS] == tt[idxT]){
                idxS++;
            }
            if(idxS == ss.length){
                break;
            }
        }
        if(ss.length != idxS){
            return false;
        }

        return true;

    }
}
