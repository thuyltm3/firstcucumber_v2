$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/firstcucumber/POM_calculator.feature");
formatter.feature({
  "name": "Viet automation test cho ung dung https://www.desmos.com/scientific",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "(1) Phep cong",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Man hinh calculator duoc hien thi tren browser",
  "keyword": "Given "
});
formatter.match({
  "location": "firstcucumber.StepDefinitions.StepDefinitions_POM_Calculator.man_hinh_calculator_duoc_hien_thi_tren_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User chon cong cac so bat ky",
  "keyword": "When "
});
formatter.match({
  "location": "firstcucumber.StepDefinitions.StepDefinitions_POM_Calculator.user_chon_cong_cac_so_bat_ky()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Man hinh hien thi ket qua phep cong chinh xac",
  "keyword": "Then "
});
formatter.match({
  "location": "firstcucumber.StepDefinitions.StepDefinitions_POM_Calculator.man_hinh_hien_thi_ket_qua_phep_cong_chinh_xac()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});