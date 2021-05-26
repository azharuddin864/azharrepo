<%@ include file="init.jsp"%>

 
<portlet:actionURL name="updateStudentDetail" var="updateStudentDetailActionURL"/>
 
<aui:form action="<%=updateStudentDetailActionURL%>" name="studentForm" method="POST"/>
 
<%
    String studentId = renderRequest.getParameter("studentId");
    String studentName = renderRequest.getParameter("studentName");
    String collegeName = renderRequest.getParameter("collegeName");
    String specialization = renderRequest.getParameter("specialization");
    String studentGpa = renderRequest.getParameter("studentGpa");
%>
<aui:form action="<%=updateStudentDetailActionURL%>" method="post" >
    <aui:input name="studentId" type="hidden" value="<%=studentId%>"/>
    <aui:input name="studentName" value="<%=studentName%>"/>
    <aui:input name="collegeName" value="<%=collegeName%>"/> 
    <aui:input name="specialization" value="<%=specialization%>"/>
    <aui:input name="studentGpa" value="<%=studentGpa%>"/>
    <aui:button type="submit" name="" value="Update Student"/>
</aui:form>