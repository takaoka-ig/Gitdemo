# 出席管理アプリ（Attendance App）

Spring Boot + MyBatis + PostgreSQL を使用した出席管理アプリです。

---

## 使用技術

- Java 21
- Spring Boot
- Thymeleaf
- MyBatis
- PostgreSQL

---

## データベース初期化手順（重要）

本アプリケーションを起動する前に、  
PostgreSQL にテーブルを作成してください。

## DBセットアップ

### 1. データベース作成

CREATE DATABASE attendance_db;

### 2. テーブル作成
sql/schema.sql を実行

### 3. 初期データ（任意）
sql/data.sql を実行

### 4. アプリ起動
Spring Boot を起動