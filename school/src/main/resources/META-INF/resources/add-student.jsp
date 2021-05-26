<%@ include file="/init.jsp" %>

<portlet:actionURL name="addStudentDetail" var="addStudentDetailActionURL"/>
                     
<h2>Add Student</h2>
 
<aui:form action="<%=addStudentDetailActionURL%>" name="studentForm" method="POST">
    <aui:input name="studentName"/>
    <aui:input name="collegeName"/> 
    <aui:input name="specialization"/>
    <aui:input name="studentGpa"/>
    <aui:button type="submit" name="" value="Add Student"/>
</aui:form>