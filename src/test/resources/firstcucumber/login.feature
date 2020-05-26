Feature: Login
  @Sprint1
  Scenario: (1) Show Homepage after login with valid credentials
    Given The login screen is displayed on browser
    When The User attempt to login with his credentials is "khanh.tx@live.com" and "abc123"
    Then The homepage will be showed

  @Sprint2
  Scenario Outline: (2) Show error message after login with invalid credentials
    Given The login screen is displayed on browser
    When The user attempt to login with <username> and invalid <password>
    Then The error <message> is showed
    Examples:
      | username        | password | message                                   |
      |khanh.tx@live.com|abc       |Tên đăng nhập hoặc Mật khẩu không đúng     |
      |khanh.tx         |abc123    |Hãy nhập E-mail ở định dạng: user@email.com|

  @Sprint2
  Scenario: (3) Test data table
    Given The user input info 10 records
     | username|email                  |born|
     | kiennt69|kiennt69@viettel.com.vn|1996|
     | kiennt68|kiennt68@viettel.com.vn|1996|
     | kiennt67|kiennt67@viettel.com.vn|1996|



