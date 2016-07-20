package de.appwerft.applifecycle;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Build;

class ForegroundCheckTask extends AsyncTask<Context, Void, TaskTestResult> {
	@Override
	protected TaskTestResult doInBackground(Context... params) {
		final Context context = params[0];
		return isAppOnForeground(context);
	}

	@SuppressWarnings("deprecation")
	private TaskTestResult isAppOnForeground(Context context) {
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		/* retreiving packagename of toppest task */
		String foregroundTaskPackageName = "";
		if (Build.VERSION.SDK_INT > 20) {
			foregroundTaskPackageName = am.getRunningAppProcesses().get(0).processName;
		} else {
			foregroundTaskPackageName = am.getRunningTasks(1).get(0).topActivity
					.getPackageName();
		}
		PackageManager pm = context.getPackageManager();
		PackageInfo foregroundAppPackageInfo = null;
		try {
			foregroundAppPackageInfo = pm.getPackageInfo(
					foregroundTaskPackageName, 0);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		String foregroundTaskAppId = foregroundAppPackageInfo.applicationInfo.packageName;
		return new TaskTestResult(context.getPackageName().equals(
				foregroundTaskAppId), foregroundTaskAppId);
	}
}