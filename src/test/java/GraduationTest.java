
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "graduation",
        tags = "@Scenario1",
        snippets = CucumberOptions.SnippetType.CAMELCASE
        )
public class GraduationTest {

}