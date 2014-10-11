ackage pool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pool.exception.NoSuchElementException;

/**
 * Abstract class to manage resources. 
 * 
 * @author Marion Tommasi
 *
 * @param <R> a type of resource
 */
public abstract class ResourcePool<R extends Resource> {
	
	private List<R> stock;
	private List<R> busy;
	
	/**
	 * Constructor of ResourcePool.
	 * 
	 * @param nbResources the number of resources to manage
	 */
	public ResourcePool(int nbResources) {
		this.stock = new ArrayList<R>(this.CreateResource(nbResources));
		this.busy = new ArrayList<R>(nbResources);
	}

	protected abstract Collection<R> CreateResource(int nbResources);

	/**
	 * Allocate a resource.
	 * 
	 * @return the resource allocated
	 * @throws NoSuchElementException if there is no resource to allocate
	 */
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

	/**
	 * Take back a resource.
	 * The resouce must be one previously allocated by the current ResourcePool. 
	 * 
	 * @param resource the resource passed back
	 * @throws IllegalArgumentException if the resource dosn't come from the current ResourcePool
	 */
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
