package com.axelor.student.service;

import com.axelor.student.db.People;

public class PeopleServiceImpl implements PeopleService {

	@Override
	public void validateDOB(People people) {
		System.err.println("Inside People Service Impl class.");
	}

	@Override
	public String test() {
		return "Hello";
	}
}
