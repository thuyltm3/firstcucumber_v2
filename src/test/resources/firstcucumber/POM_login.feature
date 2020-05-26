Feature: Login pom

  Scenario: (1) Hien thi trang chu khi login voi username va password hop le
    Given Man hinh login duoc hien thi tren browser
    When User nhap thong tin username password la "khanh.tx@live.com" and "abc123"
    Then Trang chu sau khi login thanh cong duoc hien thi

