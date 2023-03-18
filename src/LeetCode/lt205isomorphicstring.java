package LeetCode;

import java.util.HashMap;

public class lt205isomorphicstring {
    public static void main(String[] args) {
        if(isIsomorphic("abc","def")){
            System.out.println(true);
        }

    }

    public static boolean isIsomorphic(String s, String t){
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        char temps,tempt;
        HashMap<Character, Character> hm = new HashMap<>();
        HashMap<Character, Character> hm2 = new HashMap<>();
        for(int i = 0; i<ss.length;i++){
            temps = ss[i];
            tempt = tt[i];
            if(!hm.containsKey(temps) && !hm.containsValue(tempt)){
                hm.put(temps,tempt);
                hm2.put(tempt,temps);
            }else if(hm.containsKey(temps)){
                if(!hm.get(temps).equals(tempt)){
                    return false;
                }
            }else if(hm.containsValue(tempt)){
                if(!hm2.get(tempt).equals(temps)){
                    return false;
                }
            }
        }
        return true;
    }
}
