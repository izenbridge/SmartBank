package uitest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty"},
		features="src/test/resources"
		)

public class CukesRunner {

}
 