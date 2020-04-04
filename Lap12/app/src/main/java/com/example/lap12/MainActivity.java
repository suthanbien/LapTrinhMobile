package com.example.lap12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Method này được gọi khi người dùng Click vào nút Start.
    public void playSong(View view) {
        // Tạo ra một đối tượng Intent cho một dịch vụ (PlaySongService).
        Intent myIntent = new Intent(MainActivity.this, playSongService.class);
        // Gọi phương thức startService (Truyền vào đối tượng Intent)
        this.startService(myIntent);
    }
    // Method này được gọi khi người dùng Click vào nút Stop.
    public void stopSong(View view) {
        // Tạo ra một đối tượng Intent.
        Intent myIntent = new Intent(MainActivity.this, playSongService.class);
        this.stopService(myIntent);
    }
}
