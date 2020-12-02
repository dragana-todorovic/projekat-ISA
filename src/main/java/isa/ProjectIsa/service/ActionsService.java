package isa.ProjectIsa.service;

import java.util.Collection;
import java.util.UUID;

import isa.ProjectIsa.model.Actions;

public interface ActionsService {
	Collection<Actions> findAll();
	Actions create( Actions actions) throws Exception;
}
