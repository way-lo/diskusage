package com.google.android.diskusage.ui;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.google.android.diskusage.R;

/**
 * Receives the app the user picked in the "Open folder with" chooser
 * (Intent.EXTRA_CHOSEN_COMPONENT) and remembers it, so later folder opens go
 * straight to that app. App-built choosers can't offer Android's own
 * "Always" button, so DiskUsage keeps the choice itself.
 */
public class FolderChoiceReceiver extends BroadcastReceiver {
  public static final String PREFS = "diskusage_prefs";
  public static final String PREF_FOLDER_APP = "folder_app_component";

  @Override
  public void onReceive(Context context, Intent intent) {
    @SuppressWarnings("deprecation")
    ComponentName chosen = intent.getParcelableExtra(Intent.EXTRA_CHOSEN_COMPONENT);
    if (chosen == null) {
      return;
    }
    context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        .edit()
        .putString(PREF_FOLDER_APP, chosen.flattenToString())
        .apply();

    CharSequence label = chosen.getPackageName();
    try {
      PackageManager pm = context.getPackageManager();
      label = pm.getApplicationInfo(chosen.getPackageName(), 0).loadLabel(pm);
    } catch (PackageManager.NameNotFoundException ignored) {
    }
    Toast.makeText(context, context.getString(R.string.folder_app_remembered, label),
        Toast.LENGTH_LONG).show();
  }
}
