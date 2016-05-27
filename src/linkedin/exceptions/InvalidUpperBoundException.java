package linkedin.exceptions;

public class InvalidUpperBoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private int invalidUpperBound = -1;

	public InvalidUpperBoundException(String message, int upperBound) {
		super(message);
		invalidUpperBound = upperBound;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public String getMessage() {
		return super.getMessage() + ", the invalidUpperBound :"
				+ invalidUpperBound + ". The should be larger than 0";
	}

}
