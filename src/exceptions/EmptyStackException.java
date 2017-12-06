package exceptions;

public class EmptyStackException extends RuntimeException {

	public EmptyStackException() {
		super();
	}

	public EmptyStackException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyStackException(String message) {
		super(message);
	}

	public EmptyStackException(Throwable cause) {
		super(cause);
	}

}
