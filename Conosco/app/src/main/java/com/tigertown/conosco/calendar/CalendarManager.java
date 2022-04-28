package com.tigertown.conosco.calendar;

public class CalendarManager
{
	public void setAlarm() {
		// Quote in Morning at 08:32:00 AM
		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 32);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		Calendar cur = Calendar.getInstance();

		if (cur.after(calendar)) {
			calendar.add(Calendar.DATE, 1);
		}

		Intent myIntent = new Intent(context, DailyReceiver.class);
		int ALARM1_ID = 10000;
		PendingIntent pendingIntent = PendingIntent.getBroadcast(
		context, ALARM1_ID, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
	}
	
	public void AddReminder()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(...);

		Intent i = new Intent(context, YourBroadcastReceiver.class);
		//PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);

		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		PendingIntent pendingIntent = PendingIntent.getService(context, requestId, intent, PendingIntent.FLAG_NO_CREATE);
		
		if (pendingIntent != null && alarmManager != null)
		{
			alarmManager.cancel(pendingIntent);
		}
		
//		AlarmManager mgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//		mgr.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
	}
	
	private String getCalendarUriBase(Activity act)
	{
		String result = null;
		Uri calendars = Uri.parse("content://calendar/calendars");
		Cursor managedCursor = null;
		
		try {
			managedCursor = act.managedQuery(calendars, null, null, null, null);
		} catch (Exception e) {}
		
		if (managedCursor != null)
		{
			result = "content://calendar/";
		}
		else
		{
			calendars = Uri.parse("content://com.android.calendar/calendars");
			
			try
			{
				managedCursor = act.managedQuery(calendars, null, null, null, null);
			} catch (Exception e) {}

			if (managedCursor != null) {
				result = "content://com.android.calendar/";
			}
		}
		
		return result;
	}
}
