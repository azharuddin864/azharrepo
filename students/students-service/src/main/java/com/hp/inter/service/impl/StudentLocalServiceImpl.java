/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.hp.inter.service.impl;

import com.hp.inter.model.Student;
import com.hp.inter.service.base.StudentLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the student local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.hp.inter.service.StudentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.hp.inter.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.hp.inter.service.StudentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.hp.inter.service.StudentLocalServiceUtil</code>.
	 */
	private Log logger = LogFactoryUtil.getLog(StudentLocalServiceImpl.class);
	
    public void addStudentDetail(String studentName, String collegeName, String specialization, double studentGpa){
		logger.info("StudentLocalServiceImpl-->addStudentDetail-->");
		
		long studentId = counterLocalService.increment();
		Student studentDetail = null;
		try {
			studentDetail = studentLocalService.createStudent(studentId);
			studentDetail.setStudentName(studentName);
			studentDetail.setCollegeName(collegeName);
			studentDetail.setSpecialization(specialization);
			studentDetail.setStudentGpa(studentGpa);
		    studentLocalService.addStudent(studentDetail);
		} catch (Exception e) {
			logger.error("error while adding studentdetail in db", e);
		}
		
    }
    
    
    public void updateStudentDetail(long studentId, String studentName, String collegeName, String specialization, double studentGpa){
		logger.info("StudentLocalServiceImpl-->updateStudentDetail-->");
		
	    Student studentDetail = null;
	    try {
	    	studentDetail = studentLocalService.fetchStudent(studentId);
	    	if(Validator.isNotNull(studentDetail)){
	    		studentDetail.setStudentName(studentName);
	    	    studentDetail.setCollegeName(collegeName);
	    	    studentDetail.setSpecialization(specialization);
	    	    studentDetail.setStudentGpa(studentGpa);
	    	    studentLocalService.updateStudent(studentDetail);
	    	}
		} catch (Exception e) {
			logger.error("error while updating studentdetail in db", e);
		}   
    }
    
    
    public List<Student> searchByStudentName(String studentName){
		logger.info("StudentLocalServiceImpl-->updateStudentDetail-->");
		
		List<Student> studentDetail = new ArrayList<>();
	    try {
	    	studentDetail = studentPersistence.findBystudentName(studentName);
		} catch (Exception e) {
			logger.error("error while fetching  studentdetail by student name from db", e);
		}  
	    return studentDetail;
    }
    
    public List<Student> searchByCollegeName(String collegeName){
		logger.info("StudentLocalServiceImpl-->updateStudentDetail-->");
		
		List<Student> studentDetail = new ArrayList<>();
	    try {
	    	studentDetail = studentPersistence.findBycollegeName(collegeName);
		} catch (Exception e) {
			logger.error("error while fetching  studentdetail by college name from db", e);
		}  
	    return studentDetail;
    }
    
    public List<Student> searchBySpecialization(String specialization){
		logger.info("StudentLocalServiceImpl-->searchBySpecialization-->");
		
		List<Student> studentDetail = new ArrayList<>();
	    try {
	    	studentDetail = studentPersistence.findByspecialization(specialization);
		} catch (Exception e) {
			logger.error("error while fetching  studentdetail specialization from db", e);
		}  
	    return studentDetail;
    }
    
    public List<Student> searchByStudentGpa(double studentGpa){
		logger.info("StudentLocalServiceImpl-->searchByStudentGpa-->");
		
		List<Student> studentDetail = new ArrayList<>();
	    try {
	    	studentDetail = studentPersistence.findBystudentGpa(studentGpa);
		} catch (Exception e) {
			logger.error("error while fetching  studentdetail by student gpa from db", e);
		}  
	    return studentDetail;
    }
       
}