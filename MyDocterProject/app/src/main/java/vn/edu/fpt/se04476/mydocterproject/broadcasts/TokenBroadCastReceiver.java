package vn.edu.fpt.se04476.mydocterproject.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by EDGY on 2/10/2018.
 */

public abstract class TokenBroadCastReceiver extends BroadcastReceiver {
    private static final String TAG = "TokenBroadcastReceiver";
    public static final String ACTION_TOKEN = "com.google.example.ACTION_TOKEN";
    public static final String EXTRA_KEY_TOKEN = "key_token";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_TOKEN.equals(intent.getAction())) {
            String token = intent.getExtras().getString(EXTRA_KEY_TOKEN);
            onNewToken(token);
        }
    }

    public static IntentFilter getFilter() {
        IntentFilter filter = new IntentFilter(ACTION_TOKEN);
        return filter;
    }

    protected abstract void onNewToken(String token);
}
