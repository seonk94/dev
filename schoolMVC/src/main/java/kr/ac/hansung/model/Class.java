package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@ToString
public class Class {
	
	//@NotEmpty(message="Year can not be empty")
	private int year;
	
	//@Size(min=2, max=100, message="Name must be between 2 and 100 chars")
	//@NotEmpty(message="Semester can not be empty")
	private int semester;
	
	//@Size(min=6, max=7, message="Code must be between 6 and 7 chars")
	//@NotEmpty(message="Code can not be empty")
	private String code;
	
	//@Size(min=2, max=30, message="Text must be between 2 and 30 chars")
	//@NotEmpty(message="Title can not be empty")
	private String title;
	
	//@NotEmpty(message="Division can not be empty")
	private String division;
	
	//@NotEmpty(message="Credit can not be empty")
	private int credit;
}
