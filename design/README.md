# 悪いコードサンプル集

## このリポジトリについて
このリポジトリは、悪いコードサンプルを集めたものです。

## 使い方
各ディレクトリには、それぞれの言語で書かれた悪いコードが入っています。
どこがわるいかを見つけてみましょう。
そして、どうすればよくなるかを考えてみましょう。

## 一覧
### practice1: 料金からポイント数算出
- version1: 一つの関数で処理を行う
- version2: 業務ロジックを別クラスにくくり出す

### practice2: ワークフロータスクのステータス更新
- version1: 実装の詳細が公開されている
- version2: 実装の詳細を隠蔽している

### practice3: 会員ランクに応じたポイント数算出
- version1: 一つの関数で処理を行う
- version2: 業務ロジックを別クラスにくくり出す

### practice4: キャンペーンが適用されるかの判定
- version1: 中途半端な状態でインスタンスが生成できる
- version2: ガード節により中途半端な状態を許容しない

### practice5: 会員ランクに応じた配送
- version1: 一つの関数で処理を行う
- version2: 業務ロジックを別クラスにくくり出す
- version3: 業務ロジックを別クラスにくくり出し、ストラテジパターンを導入