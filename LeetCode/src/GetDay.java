import java.time.LocalDate;

/**
 * @author: Akhilesh Maloo
 * @date: 11/25/17.
 */
public class GetDay {
    public static String getDay(String day, String month, String year) {

        LocalDate ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        return ld.getDayOfWeek().toString();

    }

    public static void getDay2(String day, String month, String year) {


        int n_month = Integer.parseInt(month);
        int n_day = Integer.parseInt(day);
        int n_year = Integer.parseInt(year);

        /*
        int mon[] = {0,3,3,6,1,4,6,2,5,0,3,5};
        int ye = 6;
        int total=0;
        if(n_year > 2000 && n_year < 3000)
        {
            int new_year = n_year % 2000;
            int new_year_rem = new_year /4;

            total = mon[n_month-1] + n_day + new_year + new_year_rem + ye;
            System.out.print(mon[n_month-1] +"  "+  n_day +"  "+ new_year +"  "+ new_year_rem +"  "+  ye);

        }

        int ch = total % 7;
        */
        int a = (14 - n_month) / 12;
        int y = n_year - a;
        int m = n_month + 12 * a - 2;

        int d = (n_day + y + y/4 - y/100 + y/400 + (31*m)/12) % 7;


        switch(d)
        {
            case 0:
            {
                System.out.print("SUNDAY");
                break;
            }
            case 1:
            {
                System.out.print("MONDAY");
                break;
            }
            case 2:
            {
                System.out.print("TUESDAY");
                break;
            }
            case 3:
            {
                System.out.print("WEDNESDAY");
                break;
            }
            case 4:
            {
                System.out.print("THURSDAY");
                break;
            }
            case 5:
            {
                System.out.print("FRIDAY");
                break;
            }
            case 6:
            {
                System.out.print("SATURDAY");
                break;
            }

        }

    }

    public static void main(String[] args) {
        //System.out.println(getDay("05","08","2015"));
       getDay2("06","08","2015");
    }
}
