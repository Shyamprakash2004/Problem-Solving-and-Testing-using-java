import java.util.*;

public class JavaDateAndTime {
    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);

        String[] days = {
            "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY",
            "THURSDAY", "FRIDAY", "SATURDAY"
        };

        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public static void main(String[] args) {
        System.out.println(findDay(8, 14, 2017));
    }
}
