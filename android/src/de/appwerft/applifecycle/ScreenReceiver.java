package de.appwerft.applifecycle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, final Intent intent) {
		if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
			de.appwerft.applifecycle.ApplifecycleModule.onScreenChanged(false);

		} else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
			de.appwerft.applifecycle.ApplifecycleModule.onScreenChanged(true);
		}
	}

}