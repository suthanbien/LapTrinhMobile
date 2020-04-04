package com.example.lap12;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class playSongService extends Service {
    private MediaPlayer mediaPlayer;
    public playSongService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
        // Service này là loại không giàng buộc (Un bounded)
        // Vì vậy method này ko bao giờ được gọi.
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Tạo đối tượng MediaPlayer, chơi file nhạc của .
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {

        // Giải phóng nguồn dữ nguồn phát nhạc.
        mediaPlayer.release();
        super.onDestroy();
    }
}
