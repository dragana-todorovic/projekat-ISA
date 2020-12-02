package isa.ProjectIsa.repository;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import isa.ProjectIsa.model.Actions;

@Repository
public class ActionRepositoryImpl implements ActionRepository{

	private final ConcurrentMap<UUID, Actions> actions = new ConcurrentHashMap<UUID, Actions>();
		

	@Override
	public Collection<Actions> findAll() {
		return this.actions.values();
	}

	@Override
	public Actions create(Actions actions) {
		
		this.actions.put(UUID.randomUUID(),actions);
		return actions;
	}

	


	
}
