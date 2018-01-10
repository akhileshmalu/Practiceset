import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 11/24/17.
 */
public class NumberOfAtoms {

    public static String countOfAtoms(String formulas) {
        Stack<String> st = new Stack<>();
        Stack<String> stTrn = new Stack<>();
        String result = "";
        TreeMap<String, Integer> formula = new TreeMap<>();

        StringBuilder atoms = new StringBuilder("("+formulas+")");

        for (int i = 0; i < atoms.length(); i++) {

            if(atoms.charAt(i) == ')') {
                String multi = "1";
                if(i+1 < atoms.length() && Character.isDigit(atoms.charAt(i+1))) {
                    multi =  atoms.charAt(i+1) + "";
                    if(i+2 < atoms.length() && Character.isDigit(atoms.charAt(i+2))) {
                        multi +=  atoms.charAt(i+2) + "";
                        atoms.deleteCharAt(i+1);
                    }
                    atoms.deleteCharAt(i+1);
                }

                while(true) {
                    String tmp = st.pop();

                    if(tmp.equals("("))
                        break;

                    if(isNumber(tmp)) {
                        stTrn.push((Integer.parseInt(tmp) * Integer.parseInt(multi))+"");
                    } else {
                        if(stTrn.isEmpty() || Character.isUpperCase(stTrn.peek().charAt(0))) {
                            stTrn.push(multi);
                            stTrn.push(tmp);
                        } else
                            stTrn.push(tmp);
                    }
                }

                while(!stTrn.isEmpty()) {
                    st.push(stTrn.pop());
                }

            } else if(Character.isUpperCase(atoms.charAt(i))) {
                if(Character.isLowerCase(atoms.charAt(i+1))) {
                    st.push(atoms.charAt(i) + "" + atoms.charAt(i+1) );
                    i++;
                } else
                st.push(atoms.charAt(i) + "");
            } else if(Character.isDigit(atoms.charAt(i))){

                if(Character.isDigit(atoms.charAt(i+1))){
                    st.push(atoms.charAt(i) + "" + atoms.charAt(i+1));
                    i++;
                } else
                st.push(atoms.charAt(i) + "");
            } else {
                st.push(atoms.charAt(i) + "");
            }
        }

        System.out.println(st);

        while(!st.isEmpty()) {
            int val = Integer.parseInt(st.pop());
            String key = st.pop();
            formula.put(key, formula.getOrDefault(key,0) + val);
        }

        for (Map.Entry formula1 : formula.entrySet()) {
            result += "" + formula1.getKey();
            if ((Integer) formula1.getValue() != 1) {
                result += "" + formula1.getValue();
            }
        }
        return result;
    }

    public static String countOfAtoms2(String formula) {
        int curr = 0, base = 1, weight = 1, end = formula.length();
        Stack<Integer> stack = new Stack<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = formula.length()-1; i >= 0; --i) {
            if(formula.charAt(i) == ')') {
                stack.push(curr == 0? 1: curr);
                weight *= stack.peek();
                curr = 0;
                base = 1;
                end = i;
            }
            else if(formula.charAt(i) == '(') {
                weight /= stack.pop();
                end = i;
            }
            else if(formula.charAt(i) <= '9') {
                curr += (formula.charAt(i) - '0') * base;
                base *= 10;
                end = i;
            }
            else if(formula.charAt(i) <= 'Z') {
                String t = formula.substring(i, end);
                int temp = curr == 0? 1: curr;
                map.put(t, map.getOrDefault(t, 0) + temp*weight);
                curr = 0;
                base = 1;
                end = i;
            }
        }
        List<String> elements = new ArrayList<>(map.keySet());
        Collections.sort(elements);
        StringBuilder ans = new StringBuilder("");
        for(String s: elements) {
            ans.append(s);
            if(map.get(s) > 1) ans.append(map.get(s));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(countOfAtoms2("(NB3)33"));


        //System.out.println(isNumber("12"));
    }

    public static boolean isNumber(String num) {
        try {
            double a = Double.parseDouble(num);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}
