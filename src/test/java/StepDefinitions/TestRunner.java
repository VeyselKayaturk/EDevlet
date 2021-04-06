package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/resources/Features", glue = "StepDefinitions",
        monochrome = true,  //monochrome logların anlaşılır ve formatlanarak basılmasına yarıyor.

        // bu pluginler sayesinde target dosyası altında aşağıdaki formatlarda raporlar generate ediliyor.
        plugin= {"pretty", "html:target/HTMLReports/report.html",
                "json:target/JSONReports/report.json",
                "junit:target/JUnitReports/report.xml"
        },
        tags = "@ActiveTest"   // bu tag(hook) saysesinde sadece bu tagin verildiği senaryo veya featurlar koşuyor.
)
public class TestRunner {

}
