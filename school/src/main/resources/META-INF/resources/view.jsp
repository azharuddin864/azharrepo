<%@ include file="/init.jsp" %>


<p><b><liferay-ui:message key="school.caption"/></b></p><br><br/>


<%  
 List<Student> studentList = (List<Student>)request.getAttribute("studentList");

long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String addActionKey = "ADD_STUDENT";
String updateActionKey = "UPDATE_STUDENT";
String deleteActionKey = "DELETE_STUDENT";

boolean ADD_PERMISSION = permissionChecker.hasPermission(groupId,name, primKey, addActionKey);
boolean UPDATE_PERMISSION = permissionChecker.hasPermission(groupId,name, primKey, updateActionKey);
boolean DELETE_PERMISSION = permissionChecker.hasPermission(groupId,name, primKey, deleteActionKey);

%>
<portlet:renderURL var="addStudentUpdateRenderURL">
    <portlet:param name="mvcPath" value="/add-student.jsp"/>
</portlet:renderURL>
 
 <%
 if(ADD_PERMISSION){%>
	 <div class="mb-5">
        <a href="<%=addStudentUpdateRenderURL%>" class="btn  btn-primary btn-default"><i class="glyphicon glyphicon-plus"></i> Add Student</a>
     </div>
 <%}%>


<portlet:actionURL name="searchStudent" var="searchStudentActionURL"/>
 
<!--  Search feature starts -->
<div class="mb-5">
   <aui:form action="<%=searchStudentActionURL%>" method="post" >
    <aui:select name="searchby" id="testSelect" label="Test Select">
            <aui:option value="studentName">Student Name</aui:option>
            <aui:option value="collegeName">College Name</aui:option>
            <aui:option value="specialization">Specialization</aui:option>
            <aui:option value="studentGpa">Student Gpa</aui:option>
    </aui:select> 
    <aui:input name="searchParam" value=""/>
    <aui:button type="submit" name="" value="Search Student"/>
</aui:form>
</div>
<!--  Search feature end -->

<table class="table table-striped">
    <tr >
        <th>Student Name</th>
        <th>College Name</th>
        <th>Specialization</th>
        <th>Student Gpa</th>
        <th colspan="2" style="width: 100px">Action</th>
    </tr>    
    <%
   if(studentList.isEmpty()){ %>
	   <span>No result found</span>
   <%}else{
    for(Student studentDetail: studentList){%>
    	
    	  <portlet:renderURL var="updateStudentRenderURL">
            <portlet:param name="mvcPath" value="/update-student.jsp"/>
            <portlet:param name="studentId" value="<%=Long.toString(studentDetail.getStudentId())%>"/>
            <portlet:param name="studentName" value="<%=studentDetail.getStudentName()%>"/>
            <portlet:param name="collegeName" value="<%=studentDetail.getCollegeName()%>"/>
            <portlet:param name="specialization" value="<%=studentDetail.getSpecialization()%>"/>
            <portlet:param name="studentGpa" value="<%=Double.toString(studentDetail.getStudentGpa())%>"/>
        </portlet:renderURL>
        
        <portlet:actionURL name="deleteStudent" var="deleteStudentActionURL">
         <portlet:param name="studentId" value="<%=Long.toString(studentDetail.getStudentId())%>"/>
        </portlet:actionURL>
                
        <tr> 
            <td><%=studentDetail.getStudentName()%></td>
             <td><%=studentDetail.getCollegeName()%></td>
             <td><%=studentDetail.getSpecialization()%></td>
             <td><%=studentDetail.getStudentGpa()%></td>
             
             <%if(UPDATE_PERMISSION){%>
              <td class="text-center" style="width: 50px">
                <a href="<%=updateStudentRenderURL%>" class="btn  btn-primary btn-default btn-sm px-2 py-1" ><i class ="glyphicon glyphicon-edit"></i></a>
            </td> 
            <%}
             if(DELETE_PERMISSION){%>
            	 <td class="text-center" style="width:50px">
                 <a href="<%=deleteStudentActionURL%>" 
                     class="btn  btn-primary btn-default btn-sm px-2 py-1"
                     onclick="return confirm('Are you sure you want to delete this item?');"> 
                     <i class ="glyphicon glyphicon-remove"></i>
                 </a>
             </td> 
             <%}%>
            
                                                
         </tr>
    	
    <%}}%>
</table>