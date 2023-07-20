package ru.netology.web.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.TransferPage;

import static com.codeborne.selenide.Selenide.open;



class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
      open("http://localhost:9999");
      var loginPage = new LoginPage();
//    var loginPage = open("http://localhost:9999", LoginPageV1.class);
      var authInfo = DataHelper.getAuthInfo();
      var verificationPage = loginPage.validLogin(authInfo);
      var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
      verificationPage.validVerify(verificationCode);
      var dashboardPage = new DashboardPage();
      dashboardPage.clickAddButton();
      var transferPage = new TransferPage();
      int initialBalance = dashboardPage.getCardBalance("0");
      transferPage.transferMoney("5559 0000 0000 0002", 1000);
      int updatedBalance = dashboardPage.getCardBalance("0");
      Assert.assertEquals(initialBalance - 1000, updatedBalance);
    }

}
