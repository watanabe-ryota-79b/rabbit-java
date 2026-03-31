# ADR-005: DTOの使用方針

## コンテキスト

Entity をそのまま API レスポンスや受け口として使うと、DB スキーマの変更が API インターフェースに直結し、過剰なフィールドの公開やセキュリティリスクが生じる。
また、Controller ↔ Service 間と Service ↔ Repository 間で同一クラスを使い回すと、層をまたいだ依存が強くなる。

## 決定

API の入出力には必ず DTO を使用し、Entity を Controller 層に露出させない。

| クラス | 用途 | 配置 |
|---|---|---|
| `*Request` | APIリクエストの受け口 | `{domain}/dto/` |
| `*Response` | APIレスポンスの出力 | `{domain}/dto/` |
| `*Entity` | DB との対応 | `{domain}/entity/` |

Entity から DTO への変換は Service 層で行う。

## 結果

- **メリット**: DBスキーマ変更の影響をService層内に閉じ込められる。APIに必要なフィールドのみを公開できる。
- **デメリット**: Entity と DTO の変換コードが増える。
- **制約**: Controller が Entity を直接参照・返却することは禁止する。
