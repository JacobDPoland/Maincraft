package org.mineacademy.server;

import java.util.Objects;

public class Location {

	private final int x, y, z;

	public Location(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "Location{" +
				"x=" + x +
				", y=" + y +
				", z=" + z +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Location location = (Location) o;
		return x == location.x &&
				y == location.y &&
				z == location.z;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}
}
