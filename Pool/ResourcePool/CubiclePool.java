package pool.resourcePool;

import java.util.Collection;
import java.util.HashSet;

import pool.ResourcePool;
import pool.resource.Cubicle;

public class CubiclePool extends ResourcePool<Cubicle>{
	
	public CubiclePool(int nbCubicles) {
		super(nbCubicles);
	}

	protected Collection<Cubicle> CreateResource(int nbResources) {
		Collection<Cubicle> coll = new HashSet<Cubicle>(nbResources);
		for (int i = 0; i < nbResources; i++) {
			coll.add(new Cubicle());
		}
		return coll;
	}
}
