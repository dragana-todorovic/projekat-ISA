package isa.ProjectIsa.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.ProjectIsa.model.Actions;
import isa.ProjectIsa.repository.ActionRepository;

@Service
public class ActionsServiceImpl implements ActionsService{

	@Autowired
	private ActionRepository actionsRepository;  
	@Override
	public Collection<Actions> findAll() {
		Collection<Actions> actions = actionsRepository.findAll();
		return actions;
	}

	@Override
	public Actions create(Actions actions) throws Exception {
		
		Actions savedAction = actionsRepository.create(actions);
		return savedAction;
	}

	

}
