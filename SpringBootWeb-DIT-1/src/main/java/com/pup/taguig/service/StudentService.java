package com.pup.taguig.service;

public interface StudentService {

	String getStudentResult(String name, double grade);

	String getRemarks(double grade);

	String getStatus(double grade);

	String getAverage(double grade1, double grade2, double grade3);
}