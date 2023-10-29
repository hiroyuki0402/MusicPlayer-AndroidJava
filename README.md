# MusicPlayer-AndroidJava

## Serviceの基本的な学習

<img src="https://github.com/hiroyuki0402/MusicPlayer-AndroidJava/assets/88645049/e5d019ac-6967-4d04-95b3-ff1ebb83b1ab" width="300">


### アプリ内容

スタートボタンを押すと
音がなり、バックグラウンドでも継続して音がなる

ストップボタンを押すと
音が止まる

1. サービスの作成：バックグラウンドで音楽を再生するためのカスタムサービスクラスを作成してAndroidのServiceクラスを拡張する
2. メディアプレーヤーの使用で音楽の再生には、Androidのメディアプレーヤークラスを使用しこれにより、オーディオやビデオの再生の制御が可能
3. onStartCommandメソッドを使用して、サービスの動作を制御して再生を開始、停止、そして繰り返し再生の設定などができる
4. サービスの再起動の処理システムによってサービスが終了された後の再起動の動作を定義
