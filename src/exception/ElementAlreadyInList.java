package exception;

public class ElementAlreadyInList extends Exception{
	
	public ElementAlreadyInList(String errorMessage){
		super(errorMessage);
	}
}
