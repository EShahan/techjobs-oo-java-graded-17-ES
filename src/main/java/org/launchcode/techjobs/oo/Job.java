package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // added two constructors
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // Added custom equals and hashCode methods.

    @Override
    public String toString() {

        if (this.name == null || this.employer == null || this.location == null || this.positionType == null || this.coreCompetency == null) {
            return "OOPS! This job does not seem to exist.";
        }

        String returnString = "";

        returnString += System.lineSeparator();

        returnString += "ID: " + this.getId() + System.lineSeparator();

        if (this.getName().isEmpty()) {
            returnString += "Name: Data not available" + System.lineSeparator();
        }
        else {
            returnString += "Name: " + this.getName() + System.lineSeparator();
        }

        if (this.getEmployer().getValue().isEmpty()) {
            returnString += "Employer: Data not available" + System.lineSeparator();
        }
        else {
            returnString += "Employer: " + this.getEmployer().getValue() + System.lineSeparator();
        }

        if (this.getLocation().getValue().isEmpty()) {
            returnString += "Location: Data not available" + System.lineSeparator();
        }
        else {
            returnString += "Location: " + this.getLocation().getValue() + System.lineSeparator();
        }

        if (this.getPositionType().getValue().isEmpty()) {
            returnString += "Position Type: Data not available" + System.lineSeparator();
        }
        else {
            returnString += "Position Type: " + this.getPositionType().getValue() + System.lineSeparator();
        }

        if (this.getCoreCompetency().getValue().isEmpty()) {
            returnString += "Core Competency: Data not available";
        }
        else {
            returnString += "Core Competency: " + this.getCoreCompetency().getValue();
        }
        returnString += System.lineSeparator();

        return returnString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // added getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
