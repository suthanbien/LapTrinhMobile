package com.example.lap14;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SimpleIntentService extends IntentService {
    public static final String ACTION_1 ="MY_ACTION_1";



    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.lap14.action.FOO";
    private static final String ACTION_BAZ = "com.example.lap14.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.lap14.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.lap14.extra.PARAM2";

    public SimpleIntentService() {
        super("SimpleIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SimpleIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SimpleIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        // Tạo một đối tượng Intent (Một đối tượng phát sóng).
        Intent broadcastIntent = new Intent();
        // Sét tên hành động (Action) của Intent này.
        // Một Intent có thể thực hiện nhiều hành động khác nhau.
        // (Có thể coi là nhiều nhiệm vụ).
        broadcastIntent.setAction(SimpleIntentService.ACTION_1);
        // Vòng lặp 100 lần phát sóng của Intent.
        for (int i = 0; i <= 100; i++) {
            // Sét đặt giá trị cho dữ liệu gửi đi.
            // (Phần trăm của công việc).
            broadcastIntent.putExtra("percel", i);
            // Send broadcast
            // Phát sóng gửi đi.
            sendBroadcast(broadcastIntent);
            // Sleep 100 Milliseconds.
            // Tạm dừng 100 Mili giây.
            SystemClock.sleep(100);
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
