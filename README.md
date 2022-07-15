# どのようなアプリケーションか？
このプロジェクトはSpring Securityを使って開発したプロジェクトでございます。Spring Securityで認証方式を開発しました。ユーザー名とパスワードを入力してログインできます。
STUDENT, ADMINっていうroleをわけてSTUDENTならCOURSE＿WRITE,COURSE＿READ<STUDENT_WRITE,STUDENT＿READなどをできません。

# 動作する環境（Javaのバージョン）
11 Oracale OpenJDK version 18.0.1
# 起動するための手順（Spring Bootの起動）
1.ユーザー名とパスワードを入力します。
- ユーザー名=Jhon(ADMIN),Smith(STUDENT)
- パスワード=jhon123,smith123
- STUDENTとしてログインしたらデータは見えません。
![image](https://user-images.githubusercontent.com/51205058/179034221-558a9ab8-7d75-4229-9af0-19f97d038a9a.png)
2.ログインできたら学生のデータを見えます。
![image](https://user-images.githubusercontent.com/51205058/179148765-e5016dce-77c3-4142-8183-ea524040fc66.png)
3.PostManを使ってCRUDします。
STUDENTとしてログインしたらCRUDできません。ADMINとしてログインしたらCRUDできます。
STUDENTとしてログインした時
![image](https://user-images.githubusercontent.com/51205058/179148361-5fe0f5aa-e33e-440c-9870-a456a346f7a8.png)
ADMINとしてログインした時
![image](https://user-images.githubusercontent.com/51205058/179148411-1bbcc6bd-943c-4c23-9a12-a45caa77dc4e.png)
![image](https://user-images.githubusercontent.com/51205058/179148452-8fb9fb9e-c768-4e96-a0c9-71964903678f.png)


