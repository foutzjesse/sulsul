package com.tigertown.conosco.calendar;
import android.content.*;
import java.util.*;
import android.app.*;

public class WakeupReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {

			// Quote in Morning
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 8);
			calendar.set(Calendar.MINUTE, 30);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			Calendar cur = Calendar.getInstance();

			if (cur.after(calendar)) {
				calendar.add(Calendar.DATE, 1); //adds next day?
			}

			Intent myIntent = new Intent(context, AlarmReceiver.class);
			int ALARM1_ID = 10000;
			PendingIntent pendingIntent = PendingIntent.getBroadcast(context, ALARM1_ID, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			
			AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
		}
	}
}
