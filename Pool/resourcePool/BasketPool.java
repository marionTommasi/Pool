package pool.resourcePool;

import java.util.Collection;
import java.util.HashSet;

import pool.ResourcePool;
import pool.resource.Basket;

public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int nbBaskets) {
		super(nbBaskets);
	}

	@Override
	protected Collection<Basket> CreateResource(int nbResources) {
		Collection<Basket> coll = new HashSet<Basket>(nbResources);
		for (int i = 0; i < nbResources; i++) {
			coll.add(new Basket());
		}
		return coll;
	}

}
