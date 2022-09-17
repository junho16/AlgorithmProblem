package AutumnQofEveryday;

/**
 * 1360. 日期之间隔几天
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 *
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 * @author Junho
 * @date 2022/9/15 13:55
 */
public class Main1360 {


    public int daysBetweenDates(String date1, String date2) {
        int day1 = getDays(date1);
        int day2 = getDays(date2);
        return Math.abs(day1 - day2);
    }

    int getDays(String date){
        int[] monthDays = new int[]{
                0,31,28,31,30,31,30,31,31,30,31,30,31
        };
        int dateV = 0;
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        for(int i = 1971 ; i < year ; i++) {
            dateV += ((i % 4 == 0 && i % 100 != 0 || i % 400 == 0)) ? 366 : 365;
        }
        for(int i = 1 ; i < month ; i++){
            if(i == 2){
                dateV += monthDays[i];
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    dateV += 1;
                }
            }else{
                dateV += monthDays[i];
            }
        }

        return dateV + day;
    }
}























