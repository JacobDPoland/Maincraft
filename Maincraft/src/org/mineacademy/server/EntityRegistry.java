package org.mineacademy.server;

import org.mineacademy.server.entity.Entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EntityRegistry {

	private final Map<Integer, Entity> entities = new HashMap<>();

	public void add(Entity en) {
		entities.put(Entity.getEntitiesCreated(), en);
	}

	public void remove(String name) {
		Iterator<Map.Entry<Integer, Entity>> it = entities.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, Entity> entry = it.next();

			Entity iteratedEntity = entry.getValue();

			if (iteratedEntity.getName().equals(name))
				it.remove();
		}
	}

	public void remove(Entity en) {
		Iterator<Map.Entry<Integer, Entity>> it = entities.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, Entity> entry = it.next();

			Entity iteratedEntity = entry.getValue();

			if (iteratedEntity.equals(en))
				it.remove();
		}
	}

	public void remove(Integer uid) {
		entities.remove(uid);
	}

	public Map<Integer, Entity> getEntities() {
		return entities;
	}
}
