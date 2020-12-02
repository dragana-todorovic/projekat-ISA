package isa.ProjectIsa.repository;

import java.util.Collection;
import java.util.UUID;

import isa.ProjectIsa.model.Actions;

public interface ActionRepository {
	Collection<Actions> findAll();
	Actions create( Actions actions);
}
