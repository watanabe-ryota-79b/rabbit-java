# ADR-006: バリデーション方針

## コンテキスト

リクエストの入力値検証を各 Service や Controller に散在させると、検証ロジックの重複や抜け漏れが発生しやすい。
Spring MVC には Bean Validation (`@Valid`) と `BindingResult` を組み合わせた標準的な検証機構がある。

## 決定

入力値のバリデーションは以下の方針で行う。

- リクエスト DTO に Bean Validation アノテーション（`@NotNull`, `@Min` 等）を付与する
- Controller メソッドの引数に `@Valid` を付け、`BindingResult` でエラーを受け取る
- `BindingResult` にエラーがある場合は `400 Bad Request` を返す
- ビジネスルールに関わる検証（例: 上限値チェック）は Service 層で行い、違反時は `IllegalArgumentException` をスローする

## 結果

- **メリット**: 入力値の形式チェックと業務ロジックの検証が層ごとに分離され、責務が明確になる。
- **デメリット**: 検証箇所がController（形式）とService（業務）に分かれるため、どちらで検証すべきか判断が必要になる場面がある。
- **制約**: Service 層でフォーマット検証を行うことは避ける。
