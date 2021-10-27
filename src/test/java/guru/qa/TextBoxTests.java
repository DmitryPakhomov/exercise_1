package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Dmitry");
        $("#lastName").setValue("Pakhomov");
        $("#userEmail").setValue("fotosymbol@gmail.com");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("+79093764969");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(String.valueOf(10));
        $(".react-datepicker__year-select").selectOptionByValue(String.valueOf(1985));
        $$(".react-datepicker__day").find(text("18")).click();
        $("#subjectsInput").val("English").pressEnter();
        $("#hobbiesWrapper").find(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("48396.jpg");
        $("#currentAddress").setValue("Akademika Pavlova 6k1");


        sleep(6000);
//        $("#userNumber").setValue("+79093764969");
//        $("#submit").click();

        $("#output #name").shouldHave(text("Some name"));
        $("#output").$("#email").shouldHave(text("aaa@aa.aa"));
        $("#output").$("#currentAddress").shouldHave(text("Some address"));
        $("#output").$("#permanentAddress").shouldHave(text("Another address"));

//        $("#output").shouldHave(text("Some name"), text("aaa@aa.aa"),
//                text("Some address"), text("Another address"));
    }
}
