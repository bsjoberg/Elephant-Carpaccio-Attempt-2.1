package fun.bdd;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/resources"} ,
		features = "src/test/resources/features",
		snippets = SnippetType.CAMELCASE
		)
public class RunCukesTest {

}
