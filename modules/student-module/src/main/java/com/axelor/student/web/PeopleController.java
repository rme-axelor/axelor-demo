package com.axelor.student.web;

import com.axelor.inject.Beans;
import com.axelor.meta.schema.actions.ActionView;
import com.axelor.meta.schema.actions.ActionView.ActionViewBuilder;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;
import com.axelor.student.db.People;
import com.axelor.student.db.School;
import com.axelor.student.db.repo.PeopleRepository;
import com.axelor.student.service.PeopleService;

public class PeopleController {

	public void checkPossibility(ActionRequest request, ActionResponse response) {
		Context context = request.getContext();

		Context parentContext = context.getParent();

		System.err.println("Parent context: " + parentContext);

		People people = context.asType(People.class);
		System.err.println(people);
		if (people.getId() != null) {
			people = Beans.get(PeopleRepository.class).find(people.getId());
		}
		System.err.println(people);

		// 1. Used to call service methods

		Beans.get(PeopleService.class).validateDOB(people);

		// 2. Used for validations
		response.setFlash("Hello Error");

		// 3. Used to update attributes.
		response.setAttr("test", "title", "Testing");

		// 4. Used to open view
		ActionViewBuilder actionViewBuilder = ActionView.define("Schools").model(School.class.getName()).add("grid",
				"school-grid");
		response.setView(actionViewBuilder.map());
	}

}
