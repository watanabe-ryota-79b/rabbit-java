# rabbit-java

Spring Boot 4.x プロジェクト（Java 25）。

## 技術スタック

- **Java**: 25
- **Spring Boot**: 4.0.3
- **Gradle**: 9.3.1 (Wrapper)
- **Lombok**: コンパイル時アノテーション処理

## よく使うコマンド

```bash
# アプリ起動
./gradlew bootRun

# ビルド
./gradlew build

# テスト
./gradlew test

# クリーン
./gradlew clean
```

## プロキシ設定

社内プロキシ経由でネットワークアクセスする。設定は以下のファイルで管理：

- `gradle.properties` — Gradle 依存関係解決用
- `gradle/wrapper/gradle-wrapper.properties` — Gradle Wrapper ダウンロード用

プロキシホスト: `zproxy.ns-sol.co.jp:8000`

## アーキテクチャ

Spring の3層アーキテクチャを採用する（Controller → Service → Repository）。

## パッケージ構成

ドメイン単位でパッケージを作成する。

```
com.rabbit.rabbit_java/
  {domain}/
    controller/
    service/
    repository/
    dto/
    entity/
```

## プロジェクト構成

```
src/
  main/java/com/rabbit/rabbit_java/
    RabbitJavaApplication.java
  test/java/com/rabbit/rabbit_java/
    RabbitJavaApplicationTests.java
```

## コミットルール

- コミットメッセージは日本語で記述する
- プレフィックスを付ける（`feat:`, `fix:`, `refactor:`, `test:`, `docs:` など）
- 1コミット1変更（機能追加とリファクタリングを混在させない）

## コーディング規約

- Lombok は `@Getter` / `@Builder` のみ使用する（`@Data` 等は使わない）
- クラスを作成したら必ず対応するテストクラスも作成する

## 依存関係

- `spring-boot-starter-web` — Spring MVC（Web層）
- `spring-boot-starter-test` — テスト（JUnit 5）
- `lombok` — ボイラープレート削減
