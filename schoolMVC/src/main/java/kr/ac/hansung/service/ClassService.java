package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.ClassDAO;
import kr.ac.hansung.model.Class;
import kr.ac.hansung.model.SI;
import kr.ac.hansung.model.ysc;

@Service
public class ClassService {

	@Autowired
	private ClassDAO classDAO;
	
	public List<Class> getCurrent() {
		return classDAO.getClasses();
	}

	public void insert(Class tclass) {
		classDAO.insert(tclass);
	}
	
	public List<ysc> getYSC(){
		return classDAO.getYS();
	}
	
	public List<Class> getClasses_year_semester(int year, int semester){
		return classDAO.getClasses_year_semester(year,  semester);
	}
	
	public int getDivision_credit(String division) {
		return classDAO.getDivision(division);
	}
	
	public int getCountDivision() {
		return classDAO.getCountDivision();
	}
	
	public List<String> getDivision_s(){
		return classDAO.getDivision_s();
	}

	public List<SI> getSI() {
		return classDAO.getSI();
	}
}

