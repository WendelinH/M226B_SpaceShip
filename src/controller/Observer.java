package controller;

/**
 * Das ist ein Interface Observer.<br>
 * Dieses Interface arbeitet mit dem Subject-Interface zusammen.
 * @author Wendelin
 *
 */
public interface Observer {
	
	/**
	 * Diese Methode updated den Observer je nach Nachricht die er bekommt.
	 * @param nachricht die �bermitelt wird.
	 */
	abstract void update(String nachricht);
	
}
