package pool.exception;


public class NoSuchElementException extends Exception {

	public NoSuchElementException() {}
	
	public NoSuchElementException(String msg) {
		super(msg);
	}
	
}

/* warning sur NoSuchElementException :
 *  The serializable class NoSuchElementException does not declare a static final serialVersionUID field of type long
 */
