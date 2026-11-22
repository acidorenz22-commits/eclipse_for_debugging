package com.pup.taguig.service.impl;

import org.springframework.stereotype.Service;

import com.pup.taguig.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    // builds the full result
    @Override
    public String getStudentResult(String name, double grade) {
        return "Name: " + name + "\n"
                + "Grade: " + grade + "\n"
                + "Remarks: " + getRemarks(grade) + "\n"
                + "Status: " + getStatus(grade);
    }

    // checks grade range
    @Override
    public String getRemarks(double grade) {
        if (grade >= 90) {
            return "Outstanding";
        } else if (grade >= 85) {
            return "Very Satisfactory";
        } else if (grade >= 80) {
            return "Satisfactory";
        } else if (grade >= 75) {
            return "Fairly Satisfactory";
        } else {
            return "Did Not Meet Expectations";
        }
    }

    // 75 and up is passed
    @Override
    public String getStatus(double grade) {
        if (grade >= 75) {
            return "PASSED";
        }
        return "FAILED";
    }

    
    // Average getter
    // add 3 grades then divide by 3
    @Override
    public String getAverage(double grade1, double grade2, double grade3) {
        double average = (grade1 + grade2 + grade3) / 3;
        return "Average Grade: " + String.format("%.2f", average);
    }
}