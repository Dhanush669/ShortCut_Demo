package com.example.shortcutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ShortcutManager shortcutManager;
    List<ShortcutInfo> shortcuts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shortcutManager=getSystemService(ShortcutManager.class);
        Intent photointent=new Intent(getApplicationContext(),MainActivity.class);
        photointent.setAction(Intent.ACTION_VIEW);
        Intent videointent=new Intent(getApplicationContext(),VideoActivity.class);
        videointent.setAction(Intent.ACTION_VIEW);
        shortcuts=new ArrayList<>();
        ShortcutInfo photo_shortcut = new ShortcutInfo.Builder(this, "Photo_shortcut")
                .setShortLabel("Take a Snap")
                .setLongLabel("Open app to take photo and edit")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_camera))
                .setIntent(photointent)
                .build();
        ShortcutInfo video_shortcut = new ShortcutInfo.Builder(this, "Video_shortcut")
                .setShortLabel("Take a Video")
                .setLongLabel("Open app to take Video and edit")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_videocam))
                .setIntent(videointent)
                .build();
        shortcuts.add(photo_shortcut);
        shortcuts.add(video_shortcut);
        shortcutManager.setDynamicShortcuts(shortcuts);
    }
}