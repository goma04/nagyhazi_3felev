package exception;

@SuppressWarnings("serial")
public class ElementAlreadyInList extends Exception{
	
	public ElementAlreadyInList(String errorMessage){
		super(errorMessage);
	}
}
