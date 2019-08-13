package com.junlaninfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junlaninfo.dao.PersonDao;
import com.junlaninfo.entity.Person;

@Service
public class PersonService {
   @Autowired
   private PersonDao  personDao;
   public Person  querypersonbyid( int id) {
	   return personDao.querypersonbyid(id);
   }
	public int inserperson(Person person) {
		return personDao.inserperson(person)
				;
	}
}
