package HomeWork_8;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Test.feature"},
plugin = {"pretty"},
        publish = true)


public class RunTest {
}