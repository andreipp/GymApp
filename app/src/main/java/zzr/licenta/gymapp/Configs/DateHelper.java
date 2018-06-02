package zzr.licenta.gymapp.Configs;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Andrei on 25-May-18.
 */

public class DateHelper {

    public static long calendarToLong(Calendar calendar){
        long result = 0;
        Date date = new Date();
        date.setTime(calendar.getTimeInMillis());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        //Log.i("Calendar",dateFormat.format(date));

        result = Long.parseLong(dateFormat.format(date));
        Log.i("Calendar",result + "");


        return  result;
    }

    public static long calendarToLongYearAndWeek(int year, int week){
        long result =0;

        String together = year + "" + week;

        result = Long.parseLong(together);

        return result;
    }

    public String getIntervalByWeekOfYear(Calendar calendar,int weekNumber){
        String result;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            calendar.set(Calendar.WEEK_OF_YEAR, weekNumber);
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

            result = sdf.format(calendar.getTime());

            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

            result += " - " + sdf.format(calendar.getTime());

        return result;

    }
}
