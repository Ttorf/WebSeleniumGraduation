package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class SettingWebDriver {
    static WebDriver webDriver;


    public static WebDriver setUp() {

        File file = searchFile(System.getProperty("user.dir"), "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.toString());
        return webDriver = new ChromeDriver();

    }

    public static File searchFile(final String rootFolder, final String fileName) {
        File target = null;
        Path root = Paths.get(rootFolder);
        try (Stream<Path> stream = Files.find(root, Integer.MAX_VALUE, (path, attr) ->
                path.getFileName().toString().equals(fileName))) {
            Optional<Path> path = stream.findFirst();
            if (path.isPresent()) {
                target = path.get().toFile();
            }
        } catch (IOException e) {
        }
        return target;
    }


    }

