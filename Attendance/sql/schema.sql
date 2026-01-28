-- users テーブル
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    unit VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL
);

-- attendance テーブル
CREATE TABLE attendance (
    attendance_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    status VARCHAR(10) DEFAULT 'ATTEND',
    attendance_date DATE NOT NULL,
    CONSTRAINT fk_attendance_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);
