package com.ibm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.bean.ProjectDetails;

import com.ibm.service.ProjectService;

@SpringBootTest
class SearchTryApplicationTests {
	
	@Autowired
	ProjectService service;

	@Test
	void contextLoads() {
//		ProjectDetails project=new ProjectDetails(0, "Music System", "JBL",
//				"Python", "2019-08-16", "2019-10-29", "Bangalore",
//				"India", "MEDIUM", "Pallavi", "Working on Music system to improve bass.");
//		Iterable<ProjectDetails> proDet=service.getProjectDetails("Music System");
//		Iterator p1=proDet.iterator();
//		ProjectDetails p2=null;
//		while(p1.hasNext()) {
//			p2=(ProjectDetails)p1.next();
//			break;
//		}
//		assertThat(project).isEqualToComparingFieldByField(p2);
//	}
}
}
		


