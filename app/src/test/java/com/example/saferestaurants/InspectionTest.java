package com.example.saferestaurants;

import com.example.saferestaurants.model.Inspection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InspectionTest {
    @Test
    public void inspection(){
        String date = "20181024";
        String type = "Follow-Up";
        String criticalIssues = "0";
        String nonCriticalIssues = "1";
        String hazardRating = "Low";
        ArrayList<String> violations = new ArrayList<>();
        violations.add("308,Not Critical,Equipment/utensils/food contact surfaces are not in good working order [s. 16(b)],Not Repeat");
        String inspectionDay = "24";
        String inspectionMonth = "Oct";
        String inspectionYear = "2018";

        Inspection inspection = new Inspection(date, type, criticalIssues, nonCriticalIssues, hazardRating, violations);

        Date date_ = new Date(2018-1900, 9, 24);
        Date currentDate = new Date();
        assertEquals(date_, inspection.getDate());
        assertEquals(type, inspection.getType());
        assertEquals(0, inspection.getCriticalIssues());
        assertEquals(1, inspection.getNonCriticalIssues());
        assertEquals(hazardRating, inspection.getHazardRating());
        assertTrue(null != inspection.getViolations());
        assertEquals("24", inspection.getInspectionDay());
        assertEquals("Oct", inspection.getInspectionMonth());
        assertEquals("2018", inspection.getInspectionYear());
        assertEquals((currentDate.getTime() - date_.getTime())/(1000*60*60*24), inspection.inspectionTimeDifferent() );
    }

    @Test
    public void inspectionEmptyViolation(){
        String date = "20181024";
        String type = "Follow-Up";
        String criticalIssues = "0";
        String nonCriticalIssues = "1";
        String hazardRating = "Low";
        ArrayList<String> violations = new ArrayList<>();

        Inspection inspection = new Inspection(date, type, criticalIssues, nonCriticalIssues, hazardRating, violations);

        Date date_ = new Date(2018-1900, 9, 24);
        assertTrue(date_.equals(inspection.getDate()));
        assertEquals(type, inspection.getType());
        assertEquals(0, inspection.getCriticalIssues());
        assertEquals(1, inspection.getNonCriticalIssues());
        assertEquals(hazardRating, inspection.getHazardRating());
        assertTrue(inspection.getViolations().isEmpty());
    }

    @Test
    public void setInspection(){
        String date = "20181024";
        String type = "Follow-Up";
        String criticalIssues = "0";
        String nonCriticalIssues = "1";
        String hazardRating = "Low";
        ArrayList<String> violations = new ArrayList<>();

        Inspection inspection = new Inspection(date, type, criticalIssues, nonCriticalIssues, hazardRating, violations);

        inspection.setCriticalIssues("1");
        inspection.setNonCriticalIssues("0");
        inspection.setHazardRating("High");
        inspection.setType("Routine");

        assertEquals(1, inspection.getCriticalIssues());
        assertEquals(0, inspection.getNonCriticalIssues());
        assertEquals("High", inspection.getHazardRating());
        assertEquals("Routine", inspection.getType());
    }

}
