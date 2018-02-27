/**
 * @author: Akhilesh Maloo
 * @date: 1/28/18.
 *
 *
 *
 */
public class MagicalBinaryString {

    public static void main(String[] args) {
        String str2 = "11011000";

        String str = "1011";

        int firstHalf = Integer.parseInt(str.substring(0,str.length()/2),2);
        int sec = Integer.parseInt(str.substring(str.length()/2),2);


        int bits1 = Integer.bitCount(Integer.parseInt(str,2));
        int bits0 = str.length() - bits1;
        System.out.println(firstHalf + " " + sec + " " + ((bits1) >= bits0 && firstHalf >= sec));


//        System.out.println(isMagical(str));
    }

    public static String largestMagical(String str) {

//        for(int i=0; i<str.length()-1; i++) {
//            for(int j = i+1; j<str.length(); j++) {
//                String sub = str.substring(i,j+1);
//                System.out.println(sub);
//            }
//        }

        return "";
    }

    public static boolean isMagical(String str) {

        /*
        boolean isMagic = false;

        if(subStr.length() == 1)
            isMagic = (subStr.equals("1"));
        else {
            int bits1 = Integer.bitCount(Integer.parseInt(subStr,2));
            int bits0 = subStr.length() - bits1;
            isMagic = (bits1) >= bits0;
        }


        if(subStr.length() > 1)
        isMagic = isMagic && isMagical(subStr.substring(0,subStr.length()-1));

        if(isMagic)
            System.out.println(subStr);

        return isMagic;
        */

        int firstHalf = Integer.parseInt(str.substring(0,str.length()/2),2);
        int sec = Integer.parseInt(str.substring(str.length()/2),2);


        int bits1 = Integer.bitCount(Integer.parseInt(str,2));

        int bits0 = str.length() - bits1;


        return ((bits1) >= bits0 && firstHalf >= sec);


    }

    public static String magicstr(String str) {

        int n = str.length();
        int maxInd = -1;
        int maxLen = -1;
        int maxVal = -1;
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int mag = ismagic(str, i, j);
                if (mag > maxVal && maxVal > -1) {
                    String nq = "";
                    String t1 = str.substring(maxInd, maxInd + maxLen);
                    String t2 = str.substring(i, j + 1);
                    String pre1 = str.substring(0, maxInd);
                    String po1 = str.substring(j+1, n);
                    String mi1 = str.substring(maxInd + maxLen+1, i + 1);

                    nq = pre1;
                    nq += t2;
                    nq += mi1;
                    nq += t1;
                    nq += po1;

                    str = magicstr(nq);
                } else if (mag > maxVal && maxVal == -1) {
                    maxInd = i;
                    maxLen = j - i + 1;
                    maxVal = mag;
                    break;
                }
            }
        }
        return str;
    }

    public static int ismagic(String str, int i, int j) {
        if (i == j)
            return -1;
        String bis = str.substring(i, j+1);
        if (bis.length() == 0)
            return -1;

        int bi = Integer.parseInt(bis, 2);
        int count1 = 0;
        int count0 = 0;

        int n = bis.length()-1;
        while (n >= 0) {
            if (((bi & (1 << n)) != 0) && ( (bi & (1 << n)) == 1 || (bi & (1 << n)) % 2 == 0))
                count1++;
            else
                count0++;

            if (count1 < count0)
                return -1;
            n--;
        }
        if (count1 == count0)
            return Integer.parseInt(bis);
        return -1;
    }

}
