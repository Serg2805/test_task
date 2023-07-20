package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
  private ElementsCollection cards = $$(".list__item div");
  private final String balanceStart = "баланс: ";
  private final String balanceFinish = " р.";
  private final SelenideElement addButton = $("[data-test-id= 'action-deposit']");

  public DashboardPage() {
  }

  public int getCardBalance(String id) {
    for (SelenideElement card : cards) {
      String dataTestId = card.getAttribute("data-test-id");
      if (dataTestId.equals(id)) {
        String text = card.text();
        return extractBalance(text);
      }
    }
    return -1;
  }

  public void clickAddButton() {
    addButton.click();
  }

  private int extractBalance(String text) {
    val start = text.indexOf(balanceStart);
    val finish = text.indexOf(balanceFinish);
    val value = text.substring(start + balanceStart.length(), finish);
    return Integer.parseInt(value);
  }
}

