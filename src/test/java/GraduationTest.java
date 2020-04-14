
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "graduation",
        tags = "@Scenario2",
        snippets = CucumberOptions.SnippetType.CAMELCASE
        )
public class GraduationTest {

}
