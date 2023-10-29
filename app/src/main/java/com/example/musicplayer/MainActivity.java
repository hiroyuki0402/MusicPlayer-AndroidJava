package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // プロパティ

    /** プレイボタンの参照 */
    private Button startButton;

    /** ストップボタンの参照 */
    private Button stopButton;

    // ライフサイクル

    /**
     * アクティビティの作成時に呼び出されるメソッド
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ボタンの初期設定
        configureButton();
    }

    // メソッド

    /**
     * ボタンの参照を取得し、メンバ変数に設定する
     */
    void configureButton() {
        startButton = findViewById(R.id.button1);
        stopButton = findViewById(R.id.button2);
    }

    /**
     * 再生・停止のアクションの列挙型
     */
    enum Action {
        // 音楽の再生アクション
        Play,

        // 音楽の停止アクション
        Stop
    }

    /**
     * サービスを開始・停止するためのメソッド
     *
     * @param action 実行するアクション（再生 or 停止）
     */
    public void customServiceIntent(Action action) {
        // サービスへのインテントを作成
        Intent intent = new Intent(getApplicationContext(), CustomService.class);

        // アクションに応じてサービスを開始・停止
        switch (action) {
            case Play:
                startService(intent);
                break;
            case Stop:
                stopService(intent);
                break;
        }
    }

    // アクション

    /**
     * スタートボタンがタップされた時の処理
     *
     * @param view タップされたビュー
     */
    public void didTapStart(View view) {
        customServiceIntent(Action.Play);
    }

    /**
     * ストップボタンがタップされた時の処理
     *
     * @param view タップされたビュー
     */
    public void didTapEnd(View view) {
        customServiceIntent(Action.Stop);
    }
}
