package com.hp.portlet;

import com.hp.constants.SchoolPortletKeys;
import com.hp.inter.model.Student;
import com.hp.inter.service.StudentLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author azhar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=School",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SchoolPortletKeys.SCHOOL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SchoolPortlet extends MVCPortlet {
	
	private Log logger = LogFactoryUtil.getLog(SchoolPortlet.class);
	
	@Reference
	StudentLocalService studentlocalservice;
	
	 @Override
	 public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		 logger.info("SchoolPortlet-->render-->");
		 
		 List<Student> studentSearchList = (List<Student>)renderRequest.getAttribute("studentSearchList");
		 List<Student> allStudentsList = new ArrayList<>();
		 if(Validator.isNotNull(studentSearchList)){
			 renderRequest.setAttribute("studentList", studentSearchList);
		 }else{
			 allStudentsList = studentlocalservice.getStudents(-1, -1);
			 renderRequest.setAttribute("studentList", allStudentsList);
		 }
	   super.render(renderRequest, renderResponse);
	 }
	 
	@ProcessAction(name = "addStudentDetail")
    public void addStudentDetail(ActionRequest actionRequest, ActionResponse actionResponse){
		logger.info("SchoolPortlet-->addStudent-->");
		
        String studentName = ParamUtil.getString(actionRequest, "studentName");
        String collegeName = ParamUtil.getString(actionRequest, "collegeName");
        String specialization = ParamUtil.getString(actionRequest, "specialization");
        double studentGpa = ParamUtil.getDouble(actionRequest, "studentGpa");
        
        studentlocalservice.addStudentDetail(studentName, collegeName, specialization, studentGpa);

    }
	
	
	@ProcessAction(name = "updateStudentDetail")
    public void updateStudentDetail(ActionRequest actionRequest,  ActionResponse actionResponse) {
		logger.info("SchoolPortlet-->updateStudentDetail-->");
		
        long studentId = ParamUtil.getLong(actionRequest,"studentId");
        String studentName = ParamUtil.getString(actionRequest, "studentName");
        String collegeName = ParamUtil.getString(actionRequest, "collegeName");
        String specialization = ParamUtil.getString(actionRequest, "specialization");
        double studentGpa = ParamUtil.getDouble(actionRequest, "studentGpa");
        		
        studentlocalservice.updateStudentDetail(studentId, studentName, collegeName, specialization, studentGpa);
    }
	
	
	@ProcessAction(name = "deleteStudent")
    public void deleteStudent(ActionRequest actionRequest, ActionResponse actionResponse){
		logger.info("SchoolPortlet-->deleteStudent-->");
		
        long studentId = ParamUtil.getLong(actionRequest, "studentId");
    	logger.info("Student portlet-->deleteStudent-->"+studentId);
        try {
        	studentlocalservice.deleteStudent(studentId);
        } catch (Exception e) {
        	logger.error("error while deleting studentdetail in db", e);
        }
    }
	
	@ProcessAction(name = "searchStudent")
    public void searchStudent(ActionRequest actionRequest, ActionResponse actionResponse){
		logger.info("SchoolPortlet-->searchStudent-->");
		
        String searchby = ParamUtil.getString(actionRequest, "searchby");
        String searchParam = ParamUtil.getString(actionRequest, "searchParam");
        
        logger.info("Student portlet-->searchStudent-->searchby::::"+searchby);
    
    	List<Student> studentSearchList = null;
        try {
        	if(searchby.equals("studentName")){
        		studentSearchList = studentlocalservice.searchByStudentName(searchParam);
        	}else if(searchby.equals("collegeName")){
        		studentSearchList = studentlocalservice.searchByCollegeName(searchParam);
        	}else if(searchby.equals("specialization")){
        		studentSearchList = studentlocalservice.searchBySpecialization(searchParam);
        	}else if(searchby.equals("studentGpa")){
        		studentSearchList = studentlocalservice.searchByStudentGpa(Double.valueOf(searchParam));
        	}
        	actionRequest.setAttribute("studentSearchList", studentSearchList);
        } catch (Exception e) {
        	logger.error("error while deleting studentdetail in db", e);
        }
    }
}