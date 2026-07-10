package ru.zhyldyz.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PracticeFormPage {

    public PracticeFormPage selectDateDatepicker(String dateMonthYear) {

        String[] parts = dateMonthYear.split("\\s+");

        if (parts.length != 3) {

            throw new IllegalArgumentException(
                    "Expected format: 'dd Month yyyy', but got: " + dateMonthYear);

        }

        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        return selectDate(day, month, year);

    }

    private PracticeFormPage selectDate(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);

        String daySelector = String.format(
                ".react-datepicker__day--%03d:not(.react-datepicker__day--outside-month)",
                Integer.parseInt(day)

        );
        $(daySelector).click();

        return this;
    }

    public String selectRandomItem(String itemsXpath) {

        ElementsCollection items = $$(By.xpath(itemsXpath))
                .filter(visible);

        int index = ThreadLocalRandom.current().nextInt(items.size());
        SelenideElement item = items.get(index);
        String text = item.getText();
        item.click();
        return text;
    }

    public String formatDateForResult(String date) {

        String[] parts = date.split("\\s+");
        return String.format("%s %s,%s",

                parts[0],
                parts[1],
                parts[2]);
    }

    public String getFileName(String filePath) {

        return Paths.get(filePath).getFileName().toString();

    }
}
