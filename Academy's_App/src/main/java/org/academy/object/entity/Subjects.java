package org.academy.object.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="subjects")
public class Subjects{
	
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="subject_id")
  private int subject_id;
  
  @Column(name="SUBJECT_NAME")
  private String subject_name;
  
  @Column(name="SUBJECT_CODE")
  private String subject_code;
  
  @ManyToMany()
  @JoinTable(name="SUBJECT_CLASSES",joinColumns=@JoinColumn(name="subject_id",referencedColumnName = "subject_id"),inverseJoinColumns=@JoinColumn(name="class_id",referencedColumnName="class_id"))
  private List<Classes> classes; /** Many Subjects to Many Classes **/

public Subjects() {
	super();
}
  
public Subjects(String subject_name, String subject_code) {
	super();
	this.subject_name = subject_name;
	this.subject_code = subject_code;
}
public Subjects(String subject_name, String subject_code, List<Classes> classes) {
	super();
	this.subject_name = subject_name;
	this.subject_code = subject_code;
	this.classes = classes;
}
public Subjects(int subject_id, String subject_name, String subject_code, List<Classes> classes) {
	super();
	this.subject_id = subject_id;
	this.subject_name = subject_name;
	this.subject_code = subject_code;
	this.classes = classes;
}

public int getSubject_id() {
	return subject_id;
}

public void setSubject_id(int subject_id) {
	this.subject_id = subject_id;
}

public String getSubject_name() {
	return subject_name;
}

public void setSubject_name(String subject_name) {
	this.subject_name = subject_name;
}

public String getSubject_code() {
	return subject_code;
}

public void setSubject_code(String subject_code) {
	this.subject_code = subject_code;
}

public List<Classes> getClasses() {
	return classes;
}

public void setClasses(List<Classes> classes) {
	this.classes = classes;
}

@Override
public String toString() {
	return "Subjects [subject_id=" + subject_id + ", subject_name=" + subject_name + ", subject_code=" + subject_code
			+ ", classes=" + classes + "]";
}


}
