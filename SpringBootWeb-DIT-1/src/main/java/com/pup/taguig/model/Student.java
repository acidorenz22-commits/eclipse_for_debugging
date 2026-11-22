package com.pup.taguig.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = true)
	private float midtermGrade;

	@Column(nullable = true)
	private float finalGrade;

	public Student(long id, String firstName, String lastName, float midtermGrade, float finalGrade) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midtermGrade = midtermGrade;
		this.finalGrade = finalGrade;
	}

	public Student() {

	}

}
