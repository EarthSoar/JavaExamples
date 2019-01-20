package exception;

//业务异常处理
public class LogicException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogicException(String message) {
		super(message);
	}
}
