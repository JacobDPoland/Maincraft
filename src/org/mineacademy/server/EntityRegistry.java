package org.mineacademy.server;

import org.mineacademy.server.entity.Entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class EntityRegistry {
	private final Map<Integer, Entity> entities = new HashMap<>();
	private int lastUid = 0;

	public void add(Entity entity) {
		lastUid++;
		entities.put(lastUid, entity);
	}

	public void remove(Entity entity) {
		Iterator<Map.Entry<Integer, Entity>> it = entities.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, Entity> entry = it.next();
			Entity iteratedEntity = entry.getValue();

			if (iteratedEntity.equals(entity)) {
				it.remove();
			}
		}
	}

	public void remove(UUID uid) {
		entities.remove(uid);
	}

	public Map<Integer, Entity> getEntities() {
		return entities;
	}
}