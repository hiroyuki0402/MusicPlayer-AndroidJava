package com.example.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import androidx.annotation.Nullable;

/**
 * CustomServiceは、デフォルトの着信音を再生するサービスです。
 */
public class CustomService extends Service {

    /** MediaPlayerインスタンス */
    private MediaPlayer player;

    /**
     * Serviceが開始されたときに呼ばれるメソッド。
     *
     * @param intent  サービスに渡されるインテント
     * @param flags   サービスの開始オプション
     * @param startId サービスのユニークなID
     * @return START_STICKY フラグ。これにより、サービスが強制終了された場合に再起動を要求します。
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // MediaPlayerを初期化し、デフォルトの着信音を設定
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        // MediaPlayerをループ再生させるように設定
        player.setLooping(true);

        // MediaPlayerを開始
        player.start();

        return START_STICKY;
    }

    /**
     * Serviceが終了するときに呼ばれるメソッド。
     * MediaPlayerを停止します。
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    /**
     * Serviceにbindするためのメソッド。
     * このサービスはbindをサポートしていないため、nullを返します。
     *
     * @param intent サービスにバインドする際のインテント
     * @return null  このサービスはbindingをサポートしていないためnullを返す
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
