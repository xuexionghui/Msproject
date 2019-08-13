package com.junlaninfo.dao;

import com.junlaninfo.entity.Person;

public interface PersonDao {
	
	
	public Person  querypersonbyid( int id);
	public int inserperson(Person person);

}
