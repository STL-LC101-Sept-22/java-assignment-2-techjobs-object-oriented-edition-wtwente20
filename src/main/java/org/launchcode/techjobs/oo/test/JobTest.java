package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    //    In JobTest, define a test called testSettingJobId. Do not forget to annotate it with @Test.
    @Test
    public void testSettingJobId() {

//        Create two Job objects using the empty constructor.
        Job firstJob = new Job();
        Job secondJob = new Job();

//        Use assertNotEquals to verify that the IDs of the two objects are distinct.
        assertNotEquals(firstJob, secondJob);
    }

    @Test
    public void testJobConstructorSetsAllFields(){

        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

//      Use assertTrue and assertEquals statements to test that the constructor correctly assigns
//      both the class and value of each field. Your test should have 5 assert statements of each type.

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality(){
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job secondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(firstJob.equals(secondJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(testJob.toString().charAt(0), '\n');
        assertEquals(testJob.toString().charAt(testJob.toString().length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(testJob.toString(), "\nID: " + testJob.getId() +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        assertEquals(testJob.toString(), "\nID: " + testJob.getId() +
                "\nName: Data Unavailable" +
                "\nEmployer: Data Unavailable" +
                "\nLocation: Data Unavailable" +
                "\nPosition Type: Data Unavailable" +
                "\nCore Competency: Data Unavailable\n");
    }
}
