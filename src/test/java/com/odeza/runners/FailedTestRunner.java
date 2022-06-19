package com.odeza.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        glue = "com/odeza/step_definitions",
        features = "@target/rerun.txt"
)

public class FailedTestRunner {

}
