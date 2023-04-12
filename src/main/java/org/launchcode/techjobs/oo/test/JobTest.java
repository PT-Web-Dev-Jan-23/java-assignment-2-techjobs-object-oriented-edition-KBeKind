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

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1 instanceof Job);
        assertTrue(job1.getName().equals("Product tester"));
        assertTrue(job1.getEmployer().getValue().equals("ACME"));
        assertTrue(job1.getLocation().getValue().equals("Desert"));
        assertTrue(job1.getPositionType().getValue().equals("Quality control"));
        assertTrue(job1.getCoreCompetency().getValue().equals("Persistence"));
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));

    }


    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = job1.toString();
        assertEquals(testString.charAt(0), '\n');
        assertEquals(testString.charAt(testString.length()-1), '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = job1.toString();
        String testString2 =  "\n" +
                "ID: " + job1.getId()+ "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";
        assertEquals(testString, testString2);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("Product tester", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = job1.toString();
        String testString2 =  "\n" +
                "ID: " + job1.getId()+ "\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";
        assertEquals(testString, testString2);

    }

}
