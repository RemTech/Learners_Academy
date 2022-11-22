package org.academy.object.entity;

import javax.persistence.*;

@Entity
@Table(name="STUDENTS")
public class Students {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="student_id")
private int student_id;

@Column(name="FIRST_NAME")
private String first_name;

@Column(name="LAST_NAME")
private String last_name;

@Column(name="STUDENT_AGE")
private int student_age;

@Column(name="STUDENT_GENDER")
private String student_gender;

@OneToOne(mappedBy="students")
private Classes classes; /* ONE STUDENT TO A CLASS*/

public Students() {
	super();
}

public Students(String first_name, String last_name, int student_age, String student_gender) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.student_age = student_age;
	this.student_gender = student_gender;
	
}
public Students(String first_name, String last_name, int student_age, String student_gender,Classes classes) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.student_age = student_age;
	this.student_gender = student_gender;
	this.classes = classes;
}
public Students(int student_id, String first_name, String last_name, int student_age, String student_gender,Classes classes) {
	super();
	this.student_id = student_id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.student_age = student_age;
	this.student_gender = student_gender;
	this.classes = classes;
}

public int getStudent_id() {
	return student_id;
}

public void setStudent_id(int student_id) {
	this.student_id = student_id;
}

public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

public int getStudent_age() {
	return student_age;
}

public void setStudent_age(int student_age) {
	this.student_age = student_age;
}

public String getStudent_gender() {
	return student_gender;
}

public void setStudent_gender(String student_gender) {
	this.student_gender = student_gender;
}

public Classes getClasses() {
	return classes;
}

public void setClasses(Classes classes) {
	this.classes = classes;
}

@Override
public String toString() {
	return "Students [student_id=" + student_id + ", first_name=" + first_name + ", last_name=" + last_name
			+ ", student_age=" + student_age + ", student_gender=" + student_gender + ", classes=" + classes + "]";
}

}
