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

### 1. データベース作成

```sql
CREATE DATABASE attendance_db;
