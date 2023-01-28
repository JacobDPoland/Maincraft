package org.mineacademy.server.entity;

public interface Hostile {

	int maxTargets = 1;

	Entity getTarget();

	void setTarget(Entity entity);

	void damageTarget(int damage) throws Exception;
}
