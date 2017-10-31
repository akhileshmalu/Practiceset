/**
 * @author: Akhilesh Maloo
 * @date: 9/27/17.
 */

import java.util.Scanner;

public class RandomOp {

    public static void main(String[] args) {
        String[] operators = {"&&", "||", "!", "^", "&", "|"};

        Scanner key = new Scanner(System.in);
        String operator = "";
        String ans = "";
        Boolean expAns = false;

        while (!ans.equals("quit")) {
            operator = operators[(int) (Math.random() * 6)];
            Boolean first = (Math.random() > 0.5);
            Boolean second = (Math.random() > 0.5);


            if (!operator.equals("!")) {

                System.out.println(first + operator + second);
                ans = key.nextLine();

                switch (operator) {
                    case "&&":
                        expAns = first && second;
                        break;
                    case "||":
                        expAns = first || second;
                        break;
                    case "&":
                        expAns = first & second;
                        break;
                    case "|":
                        expAns = first | second;
                        break;
                    case "^":
                        expAns = first ^ second;
                        break;
                    default:
                        expAns = false;
                        System.out.println("wrong operator");
                }

                if (Boolean.parseBoolean(ans) == expAns)
                    System.out.println("correct Ans");
                else
                    System.out.println("wrong");

            } else {
                System.out.println(operator + first);
                ans = key.nextLine();

                if (Boolean.parseBoolean(ans) == !(first))
                    System.out.println("correct");
                else
                    System.out.println("wrong");

            }
            System.out.println("continue or quit");
            ans = key.nextLine();
        }


    }

}
