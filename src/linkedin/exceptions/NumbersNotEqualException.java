package linkedin.exceptions;

public class NumbersNotEqualException extends Exception {
	private static final long serialVersionUID = 2902352416037759125L;
	private int actionBtnListSize = -1;
	private int graphicsListSize = -1;
	private int currJobsListSize = -1;
	
	public NumbersNotEqualException(int actionBtnListSize, int graphicsListSize, int currJobsListSize) {
		this.actionBtnListSize = actionBtnListSize;
		this.graphicsListSize =graphicsListSize;
		this.currJobsListSize=currJobsListSize;
	}

	@Override
	public String getMessage() {
		return "actionBtnListSize is "+actionBtnListSize+", graphicsListSize is "+graphicsListSize+", currJobsListSize is "+currJobsListSize;
	}

}
