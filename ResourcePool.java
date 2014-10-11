ackage pool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pool.exception.NoSuchElementException;

public abstract class ResourcePool<R extends Resource> {
	
	private List<R> stock;
	private List<R> busy;
	
	public ResourcePool(int nbResources) {
		this.stock = new ArrayList<R>(this.CreateResource(nbResources));
		this.busy = new ArrayList<R>(nbResources);
	}

	protected abstract Collection<R> CreateResource(int nbResources);

	public R provideResources() throws NoSuchElementException{
		if (this.stock.isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
			R resource = this.stock.get(0);
			this.busy.add(resource);
			this.stock.remove(0);
			return resource;
		}
	}

	public void FreeResource(R resource) throws IllegalArgumentException{
		if (this.busy.contains(resource)) {
			this.busy.remove(resource);
			this.stock.add(resource);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

}
