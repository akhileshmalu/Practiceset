/**
 * @author: Akhilesh Maloo
 * @date: 8/31/17.
 */
public class JudgeCircle {

        public boolean judge(String moves) {
            int[] countArray = new int[122];
            char[] ch=moves.toCharArray();
            for(int i=0;i<ch.length; i++){
                countArray[(int)ch[i]]++;
            }
            if(countArray[(int)'U'] != countArray[(int)'D']){
                return false;
            }
            if(countArray[(int)'L'] != countArray[(int)'R']){
                return false;
            }
            return true;
        }

    public static void main(String[] args) {

            JudgeCircle jc = new JudgeCircle();

        System.out.println(jc.judge("LLLL"));
    }

}
