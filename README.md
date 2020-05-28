# Cách tạo project cucumber bằng commandline: mvn archetype:generate -Dfilter=cucumber
  - "Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : " 
  -> nhập tùy chọn (6: chọn archetype cucumber thuần)
  - "Choose io.cucumber:cucumber-archetype version" -> chọn version archetype (nên chọn version mới nhất đã release)
  - "Define value for property 'groupId'": -> nhập groupId (example: viettel.vn,...)
  - "Define value for property 'artifactId'" -> nhập artifactId (tên project, duy nhất)
  - "Define value for property 'version' 1.0-SNAPSHOT:" -> nhập 1.0
  - "Define value for property 'package' viettel.vn:" -> nhập tên package
  - Nhập Y (confirm với các config vừa nhập)
  -> Nhấn enter để hoàn thành việc tạo project cucumber

# Cách run TC với nhiều thẻ @Tag: mvn test -Dbrowser=chrome -Dcucumber.options="--tags '@Sprint2 or @Sprint3'"

# Cách viết 1 kịch bản tốt với cucumber:
  https://automationpanda.com/2018/01/31/good-gherkin-scenario-titles/
  https://automationpanda.com/2017/01/30/bdd-101-writing-good-gherkin/
  
# [TIP] Khi làm việc với các WebElement sẽ có 3 cách để xác định Element trên WebPage:
  - Loại 1: Sử dụng các thuộc tính cơ bản của HTML (Xem băng trình Inspect của browser)
    - Nếu có ID thì dùng By.ID(“‘Gía trị của ID”)
    - Nếu có Name thì dùng By.Name(“Gía trị của thuộc tính Name”)
    - Nếu có Class thì đùng By.ClassName(“Giá trị của thuộc tính Class”)
    - Nếu là thẻ a thì có thể dùng innerText để tìm By.TextLink(“Content của Text Link”)

  - Loại 2: CSSSelector (Loại này khá hay dùng)
    - Kết hợp giữa Tag + ID  : Tag#ID
    - kết hợp giữa Tag + Class : Tag.ClassName
    - kết hợp giữa Tag + Attribute: Tag[@Attribute= Value]
    - Dùng dấu ^, $, * để lấy css (lấy đoạn đầu hoặc cuối, hoặc vị trí bất kỳ trong class): 
  Example: <div class="FormSearch__Form-sc-1fwg3wo-1 gUJHDL">   --> txtboxSearchTikiCss = input["class^='FormSearch__Input'"] 
    - Dùng dấu "." để lấy css trong thông qua 2 value trong class: example: <i class="tikicon icon-user"></i>  --> css = ".tikicon.icon-user"


* [TIP] waiting in selenium
