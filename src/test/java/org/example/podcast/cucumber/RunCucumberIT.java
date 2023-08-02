package org.example.podcast.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue="org/example/podcast/steps",
        tags="@podcast"
)

public class RunCucumberIT {

}
