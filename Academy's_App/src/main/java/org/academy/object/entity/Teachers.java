package org.academy.object.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TEACHERS")
public class Teachers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private int teacher_id;
	
	@Column(name="FIRST_NAME")
 private String first_name;
	
	@Column(name="LAST_NAME")
 private String last_name;
	
	@Column(name="QUALIFICATION")
 private String qualification;
	
	@Column(name="AGE")
 private String age;
	
	@Column(name="GENDER")
 private String gender;
	
   @OneToOne
   @JoinColumn(name="subject_id")
private Subjects subjects;
	
 @ManyToOne()
 @JoinColumn(name="class_id")
 private Classes classes; /** Many Teachers to One Class **/

public Teachers() {
	super();
}



 public Teachers(String first_name, String last_name, String qualification, String age, String gender,Subjects subjects, Classes classes) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.qualification = qualification;
	this.age = age;
	this.gender = gender;
	this.subjects = subjects;
	this.classes = classes;
}



public Teachers(String first_name, String last_name, String qualification, String age, String gender) {
	     super();
	     this.first_name = first_name;
	     this.last_name = last_name;
	     this.qualification = qualification;
	     this.age = age;
	     this.gender = gender;
	
}
 public Teachers(String first_name, String last_name, String qualification, String age, String gender,Classes classes) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.qualification = qualification;
		this.age = age;
		this.gender = gender;
		this.classes = classes;
}
 public Teachers(int teacher_id, String first_name, String last_name, String qualification, String age, String gender,Classes classes) {
		super();
		this.teacher_id = teacher_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.qualification = qualification;
		this.age = age;
		this.gender = gender;
		this.classes = classes;
}
 
 
public int getTeacher_id() {
	return teacher_id;
}
public void setTeacher_id(int teacher_id) {
	this.teacher_id = teacher_id;
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
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Classes getClasses() {
	return classes;
}
public void setClasses(Classes classes) {
	this.classes = classes;
}
@Override
public String toString() {
	return "Teachers [teacher_id=" + teacher_id + ", first_name=" + first_name + ", last_name=" + last_name
			+ ", qualification=" + qualification + ", age=" + age + ", gender=" + gender + ", classes=" + classes + "]";
}
 
}
