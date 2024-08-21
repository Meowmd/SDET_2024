package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalenderComponent {
    public void setDate(String day, String month, String year) {
            $(".react-datepicker__month-select").selectOption(month);
            $(".react-datepicker__year-select").selectOption(year);
            $(byText(day)).click();
        }
    }
