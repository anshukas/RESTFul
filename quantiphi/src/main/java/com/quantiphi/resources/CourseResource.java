package com.quantiphi.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.quantiphi.model.Course;
import com.quantiphi.services.CourseService;

@Path("/list")
public class CourseResource {
	
	CourseService courseService = new CourseService();
	
	/*@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Course> getCourses(){
		return courseService.getAllCourses();
	}*/
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getCoursesJSONOrXML(@QueryParam("type") String type){
		//Here we get list
		List<Course> list = courseService.getAllCourses();
		GenericEntity<List<Course>> entity = new GenericEntity<List<Course>>(list) {};
		Response response = Response
				.ok(entity, "xml".equals(type) ? MediaType.APPLICATION_XML : MediaType.APPLICATION_JSON)
				.build();
		return response;
	}
	
	@GET
	@Path("/count")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getCourseCount(@QueryParam("type") String type){
		Response response = Response
				.ok(courseService.getCount(), "xml".equals(type) ? MediaType.APPLICATION_XML : MediaType.APPLICATION_JSON)
				.build();
		return response;
	}
	
	
	@GET
	@Path("/search")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getCoursesSearchByTitle(@QueryParam("title") String title,@QueryParam("type") String type){
		List<Course> list = courseService.searchByTitle(title);
		GenericEntity<List<Course>> entity = new GenericEntity<List<Course>>(list) {};
		Response response = Response
				.ok(entity, "xml".equals(type) ? MediaType.APPLICATION_XML : MediaType.APPLICATION_JSON)
				.build();
		return response;
	}
	
}
