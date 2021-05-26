create table U_Student (
	uuid_ VARCHAR(75) null,
	studentId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	studentName VARCHAR(75) null,
	collegeName VARCHAR(75) null,
	specialization VARCHAR(75) null,
	studentGpa DOUBLE
);