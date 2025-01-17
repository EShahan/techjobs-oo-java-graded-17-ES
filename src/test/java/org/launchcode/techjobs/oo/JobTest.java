package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job secondJob = new Job();
        assertNotEquals(firstJob.getId(), secondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job secondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(firstJob.equals(secondJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job newLineJob = new Job();
        assertTrue(newLineJob.toString().startsWith(System.lineSeparator()));
        assertTrue(newLineJob.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job correctLabelsJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedString =
                System.lineSeparator() +
                        "ID: " + correctLabelsJob.getId() + System.lineSeparator() +
                        "Name: Product tester" + System.lineSeparator() +
                        "Employer: ACME" + System.lineSeparator() +
                        "Location: Desert" + System.lineSeparator() +
                        "Position Type: Quality control" + System.lineSeparator() +
                        "Core Competency: Persistence" + System.lineSeparator();
        assertEquals(expectedString, correctLabelsJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job emptyFieldJob = new Job();
        assertEquals(System.lineSeparator() + "OOPS! This job does not seem to exist." + System.lineSeparator(), emptyFieldJob.toString());
    }
}
