package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
  private SelenideElement amountMoney = $("[data-test-id=amount] input");
  private SelenideElement fromCard = $("[data-test-id=from] input");
  private SelenideElement transferButton = $("[data-test-id=action-transfer]");

  public void transferMoney(String cardNumber, int amount) {
    fromCard.setValue(cardNumber);
    amountMoney.setValue(String.valueOf(amount));
    transferButton.click();
  }
}
