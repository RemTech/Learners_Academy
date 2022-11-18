package org.academy.object.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TEACHERS")
public class Teachers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEACHER_ID")	
 private int teacher_id;
	
	@Column(name="FIRST_NAME")
 private String first_name;
	
	@Column(name="LAST_NAME")
 private String last_name;
	
	@Column(name="QUALIFICATION")
 private String qualification;
	
	@Column(name="AGE")
 private int age;
	
	@Column(name="GENDER")
 private String gender;
	
 @OneToMany(mappedBy="classes")
 private Classes classes; /** One To Many **/

public Teachers() {
	super();
}
 public Teachers(String first_name, String last_name, String qualification, int age, String gender) {
	     super();
	     this.first_name = first_name;
	     this.last_name = last_name;
	     this.qualification = qualification;
	     this.age = age;
	     this.gender = gender;
	
}
 public Teachers(String first_name, String last_name, String qualification, int age, String gender,Classes classes) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.qualification = qualification;
		this.age = age;
		this.gender = gender;
		this.classes = classes;
	}
 public Teachers(int teacher_id, String first_name, String last_name, String qualification, int age, String gender,Classes classes) {
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
public int getAge() {
	return age;
}
public void setAge(int age) {
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
