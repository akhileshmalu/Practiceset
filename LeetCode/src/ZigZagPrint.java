import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 1/4/18.
 */
public class ZigZagPrint {
    public static String convert(String input, int nRow) {

        char[][] res = new char[nRow][input.length()];

        if(nRow <= 1)
            return input;

        int i = 0, j = 0;

        boolean vertical = true;

        for(char ch: input.toCharArray()) {

            if(vertical)
                res[i++][j] = ch;

            if(!vertical) {
                res[--i][++j] = ch;
            }

            if(i == nRow) {
                vertical = false;
                i = nRow-1;
            }
            if(i-1 == 0 && !vertical) {
                vertical = true;
                i--;
                j++;
            }

        }

        print(res);

        StringBuilder out = new StringBuilder();
        for(char[] newArr : res) {
            for(char ch: newArr)
                if(ch != '\0')
                out.append(ch);
        }

        return out.toString();
    }

    public static String convert2(String s, int numRows) {
        if(numRows==0){
            return "";
        }
        if(numRows==1){
            return s;
        }
        int magic = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < numRows;i++){
            buildRow(sb, i, magic, s);
        }
        return sb.toString();
    }

    private  static void buildRow(StringBuilder sb, int start, int magic, String s){
        int idx = start;
        int distance1 = magic-start-start;
        int distance2 = start * 2;
        //handle first and last row
        if(distance1==0||distance2==0){
            distance1 = magic;
            distance2 = magic;
        }
        int count = 0;
        while(idx < s.length()){
            sb.append(s.charAt(idx));
            if(count%2==0){
                idx+=distance1;
            }else{
                idx+=distance2;
            }
            count++;
        }
    }

    public static void print(char[][] print) {

        for(char[] newArr : print) {
            for(char ch : newArr) {
                //System.out.print((Character.isAlphabetic(ch))? ch:" ");
                System.out.print(ch);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        System.out.println(convert2("ABCDEF",3));

    }
}
