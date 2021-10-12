package com.axelor.student.service;

import com.axelor.meta.CallMethod;
import com.axelor.student.db.People;

public interface PeopleService {

	public void validateDOB(People people);

	@CallMethod
	public String test();
}
