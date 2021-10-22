package impl;

import skeleton.Person;

import java.time.LocalDate;

public class Employee extends Person {
	String department;
	String jobDescription;

	public Employee(String firstName, String lastName, String email, LocalDate birthdate, String department, String jobDescription) {
		super(firstName, lastName, email, birthdate);
		this.department = department;
		this.jobDescription = jobDescription;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	@Override
	public String toString() {
		return toStringBuilder()
				.append(", ")
				.append(jobDescription)
				.append(" in ")
				.append(department)
				.toString();
	}
}
