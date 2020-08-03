package com.testrunner;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApiTestRunner {
    @Test
    public void testParallel() {
        
        // if you want execute all feature file uncomment below line.
    	Results results = Runner.path("classpath:feature1").tags("~@ignore").parallel(2);
    	generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);        
    }
    
    public static void generateReport(String karateOutputPath) {        
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "Karate Sample Project");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();        
    }
    
}

