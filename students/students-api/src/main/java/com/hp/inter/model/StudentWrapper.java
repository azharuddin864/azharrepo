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

package com.hp.inter.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
public class StudentWrapper
	extends BaseModelWrapper<Student>
	implements ModelWrapper<Student>, Student {

	public StudentWrapper(Student student) {
		super(student);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("studentId", getStudentId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("studentName", getStudentName());
		attributes.put("collegeName", getCollegeName());
		attributes.put("specialization", getSpecialization());
		attributes.put("studentGpa", getStudentGpa());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String studentName = (String)attributes.get("studentName");

		if (studentName != null) {
			setStudentName(studentName);
		}

		String collegeName = (String)attributes.get("collegeName");

		if (collegeName != null) {
			setCollegeName(collegeName);
		}

		String specialization = (String)attributes.get("specialization");

		if (specialization != null) {
			setSpecialization(specialization);
		}

		Double studentGpa = (Double)attributes.get("studentGpa");

		if (studentGpa != null) {
			setStudentGpa(studentGpa);
		}
	}

	/**
	 * Returns the college name of this student.
	 *
	 * @return the college name of this student
	 */
	@Override
	public String getCollegeName() {
		return model.getCollegeName();
	}

	/**
	 * Returns the create date of this student.
	 *
	 * @return the create date of this student
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this student.
	 *
	 * @return the modified date of this student
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the specialization of this student.
	 *
	 * @return the specialization of this student
	 */
	@Override
	public String getSpecialization() {
		return model.getSpecialization();
	}

	/**
	 * Returns the student gpa of this student.
	 *
	 * @return the student gpa of this student
	 */
	@Override
	public double getStudentGpa() {
		return model.getStudentGpa();
	}

	/**
	 * Returns the student ID of this student.
	 *
	 * @return the student ID of this student
	 */
	@Override
	public long getStudentId() {
		return model.getStudentId();
	}

	/**
	 * Returns the student name of this student.
	 *
	 * @return the student name of this student
	 */
	@Override
	public String getStudentName() {
		return model.getStudentName();
	}

	/**
	 * Returns the uuid of this student.
	 *
	 * @return the uuid of this student
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the college name of this student.
	 *
	 * @param collegeName the college name of this student
	 */
	@Override
	public void setCollegeName(String collegeName) {
		model.setCollegeName(collegeName);
	}

	/**
	 * Sets the create date of this student.
	 *
	 * @param createDate the create date of this student
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this student.
	 *
	 * @param modifiedDate the modified date of this student
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the specialization of this student.
	 *
	 * @param specialization the specialization of this student
	 */
	@Override
	public void setSpecialization(String specialization) {
		model.setSpecialization(specialization);
	}

	/**
	 * Sets the student gpa of this student.
	 *
	 * @param studentGpa the student gpa of this student
	 */
	@Override
	public void setStudentGpa(double studentGpa) {
		model.setStudentGpa(studentGpa);
	}

	/**
	 * Sets the student ID of this student.
	 *
	 * @param studentId the student ID of this student
	 */
	@Override
	public void setStudentId(long studentId) {
		model.setStudentId(studentId);
	}

	/**
	 * Sets the student name of this student.
	 *
	 * @param studentName the student name of this student
	 */
	@Override
	public void setStudentName(String studentName) {
		model.setStudentName(studentName);
	}

	/**
	 * Sets the uuid of this student.
	 *
	 * @param uuid the uuid of this student
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected StudentWrapper wrap(Student student) {
		return new StudentWrapper(student);
	}

}