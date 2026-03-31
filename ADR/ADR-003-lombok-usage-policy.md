# ADR-003: Lombokの使用方針

## コンテキスト

Lombokはボイラープレートコードを削減できる一方、アノテーションによっては生成されるコードが不透明になり、予期しない挙動（`equals`/`hashCode` の自動生成によるバグ等）を招くリスクがある。
特に `@Data` は `@Getter`, `@Setter`, `@RequiredArgsConstructor`, `@ToString`, `@EqualsAndHashCode` をまとめて付与するため、意図しないメソッドが生成される。

## 決定

Lombok のアノテーションは以下の4つに限定して使用する。

| アノテーション | 用途 |
|---|---|
| `@Getter` | フィールドの getter 生成 |
| `@Setter` | フィールドの setter 生成 |
| `@Builder` | Builder パターンの生成 |
| `@RequiredArgsConstructor` | `final` フィールドを引数に取るコンストラクタ生成（DIに利用） |

`@Data`, `@Value`, `@AllArgsConstructor` などは使用しない。

## 結果

- **メリット**: 生成されるメソッドが明示的になり、意図しない `equals`/`hashCode` の自動生成を防げる。コードレビュー時に挙動の予測が容易になる。
- **デメリット**: `@Data` に比べてアノテーションの記述量が増える場面がある。
- **制約**: 既存コードに `@Data` 等が混入していた場合は `@Getter`/`@Setter` への分割を必須とする。
