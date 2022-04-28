package com.tigertown.conosco.calendar;

public class AlarmReceiver extends BroadcastReceiver {
	DatabaseHelper databaseHelper;

	@Override
	public void onReceive(Context context, Intent intent) {

	String quote ;

	long when = System.currentTimeMillis();
	NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

	Intent notificationIntent = new Intent(context, DailySpecialActivity.class);
	notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,	notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

	Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

	// get your quote here
	quote = doSomeMethod();

	NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(context)
		.setSmallIcon(R.mipmap.ic_launcher)
		.setContentTitle("My Quotes")
		.setContentText(quote).setSound(alarmSound)
		.setAutoCancel(true).setWhen(when)
		.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
		.setStyle(new NotificationCompat.BigTextStyle().bigText(quote))
		.setContentIntent(pendingIntent)
		.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});  // Declair VIBRATOR Permission in AndroidManifest.xml
	
	notificationManager.notify(5, mNotifyBuilder.build());
	}
}
