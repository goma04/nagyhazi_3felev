package exception;

@SuppressWarnings("serial")
public class MemberNotFound extends Exception {
	public MemberNotFound(String errorMessage){
		super(errorMessage);
	}
}
