-- 既存テーブル削除
DROP TABLE IF EXISTS users.attendance;
DROP TABLE IF EXISTS attendance.attendance;

--attendanceスキーマ作成
CREATE SCHEMA IF NOT EXISTS attendance;


-- users テーブル作成 スキーマを指定
CREATE TABLE attendance.users (
    user_id SERIAL PRIMARY KEY,
    unit VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL
);

-- attendance テーブル作成 スキーマを指定
CREATE TABLE attendance.attendance (
    attendance_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    status VARCHAR(10) DEFAULT 'ATTEND',
    attendance_date DATE NOT NULL,
    CONSTRAINT fk_attendance_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);


