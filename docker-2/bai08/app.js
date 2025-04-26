const mysql = require('mysql2');
const express = require('express');
const app = express();

let connection;

function connectWithRetry() {
  connection = mysql.createConnection({
    host: 'db',
    user: 'user',
    password: 'password',
    database: 'mydb'
  });

  connection.connect(err => {
    if (err) {
      console.error('Kết nối thất bại, thử lại sau 5s...', err);
      setTimeout(connectWithRetry, 5000);
    } else {
      console.log('✅ Kết nối MySQL thành công!');
    }
  });
}

connectWithRetry();

app.get('/', (req, res) => {
  if (!connection || connection.state === 'disconnected') {
    return res.status(500).send('❌ Chưa kết nối được MySQL');
  }

  connection.query('SELECT NOW()', (err, results) => {
    if (err) return res.status(500).send('❌ Lỗi query');
    res.send(`⏰ Thời gian từ MySQL: ${results[0]['NOW()']}`);
  });
});

app.listen(3000, () => {
  console.log('🚀 App chạy tại http://localhost:3000');
});
