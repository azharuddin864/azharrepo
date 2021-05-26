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

package com.hp.inter.model.impl;

import com.hp.inter.model.Student;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StudentCacheModel)) {
			return false;
		}

		StudentCacheModel studentCacheModel = (StudentCacheModel)object;

		if (studentId == studentCacheModel.studentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", studentName=");
		sb.append(studentName);
		sb.append(", collegeName=");
		sb.append(collegeName);
		sb.append(", specialization=");
		sb.append(specialization);
		sb.append(", studentGpa=");
		sb.append(studentGpa);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		if (uuid == null) {
			studentImpl.setUuid("");
		}
		else {
			studentImpl.setUuid(uuid);
		}

		studentImpl.setStudentId(studentId);

		if (createDate == Long.MIN_VALUE) {
			studentImpl.setCreateDate(null);
		}
		else {
			studentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			studentImpl.setModifiedDate(null);
		}
		else {
			studentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (studentName == null) {
			studentImpl.setStudentName("");
		}
		else {
			studentImpl.setStudentName(studentName);
		}

		if (collegeName == null) {
			studentImpl.setCollegeName("");
		}
		else {
			studentImpl.setCollegeName(collegeName);
		}

		if (specialization == null) {
			studentImpl.setSpecialization("");
		}
		else {
			studentImpl.setSpecialization(specialization);
		}

		studentImpl.setStudentGpa(studentGpa);

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		studentId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		studentName = objectInput.readUTF();
		collegeName = objectInput.readUTF();
		specialization = objectInput.readUTF();

		studentGpa = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(studentId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (studentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(studentName);
		}

		if (collegeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(collegeName);
		}

		if (specialization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specialization);
		}

		objectOutput.writeDouble(studentGpa);
	}

	public String uuid;
	public long studentId;
	public long createDate;
	public long modifiedDate;
	public String studentName;
	public String collegeName;
	public String specialization;
	public double studentGpa;

}