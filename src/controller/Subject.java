package controller;

/**
 * Das ist ein Interface Subject.<br>
 * Dieses Interface arbeitet mit dem Observer-Interface zusammen.
 * @author Wendelin
 *
 */
public interface Subject {
	
	/**
	 * Diese Methode fügt dem Subject ein Observer-Object hinzu mit dem es späther kommunizieren kann.
	 * @param observer : Observer
	 */
	public void attach(Observer observer);
	
	/**
	 * Diese Methode entfernt dem Subject ein Observer-Object.
	 * @param observer : Observer
	 */
	public void detach(Observer observer);
	
	/**
	 * Diese Methode benachrichtigt alle Observer-Objecte mit denen die hinzugefügt wurden.
	 * @param nachricht : String zu übermitelnde Nachricht
	 */
	public void notifyAllObserver(String nachricht);
	
}
