package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
  public VerificationPage validLogin(DataHelper.AuthInfo info) {
    fillLogin(info);

    return new VerificationPage();
  }

  public LoginPage invalidLogin(DataHelper.AuthInfo info) {
    fillLogin(info);

    $(".notification").shouldBe(Condition.visible);

    return this;
  }

  public void fillLogin(DataHelper.AuthInfo info) {
    $("[data-test-id=login] input").setValue(info.getLogin());
    $("[data-test-id=password] input").setValue(info.getPassword());
    $("[data-test-id=action-login]").click();
  }
}
