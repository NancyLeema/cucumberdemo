package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features= {"src/test/java/features/"},
           dryRun=false,
           glue="stepdefinition",
           snippets=SnippetType.CAMELCASE,
           monochrome=true,
           plugin= {"pretty",
        		   "html:report"
        		   }
		)
        
public class Classrunner extends AbstractTestNGCucumberTests{

}
