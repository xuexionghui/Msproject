package com.junlaninfo.action;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.junlaninfo.entity.Person;
import com.junlaninfo.service.PersonService;

@Controller
public class PersonAction {
	
	@Autowired
	PersonService personService;
	
	@Test
	public void testPerson(){
		ApplicationContext applcition = new ClassPathXmlApplicationContext("application-context.xml");
		PersonAction personAction = (PersonAction) applcition.getBean("personAction");
//		Person person = personAction.personService.querypersonbyid(3);
		 Person person = new Person();
		person.setId(2);
		 person.setName("xuexionghui");
		 person.setAddress("meizhou");
		 person.setAge(15);
		 person.setBirthday("05-04");
		 personAction.personService.inserperson(person);
		System.out.println(person);
	}
	@Test 
	public void test2() {
		ApplicationContext applcition = new ClassPathXmlApplicationContext("application-context.xml");
		PersonAction personAction = (PersonAction) applcition.getBean("personAction");
        Person person = personAction.personService.querypersonbyid(2);
        System.out.print(person);
		
	}
	

}
