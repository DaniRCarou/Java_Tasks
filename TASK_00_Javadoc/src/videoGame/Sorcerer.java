package videoGame;


/**
 * Class representing a warlock with three attributes: life, hasSoul, and power.
 * 
 * This class will be used for a fighting video game.
 * 
 * Uploaded to the repository: <a href="https://github.com/DaniRCarou/Java_Tasks"/>
 * 
 * @author Daniel Rodriguez 
 * 
 * @version 1.0 * 
 */

public class Sorcerer {
	
	
	/**
	 * The sorcerer's life ranges from any negative number to 100. 
	 * However, if it is negative or reaches 0, they are dead.
	 */
	
	private int life;
	
	
	/**
	 * The sorcerer may or may not have a soul 	
	 */
	
	private boolean hasSoul;
	
	
	/**
	 * The sorcerer may possess power. 
	 * There is no maximum, but negatives are not allowed. 
	 */
	
	private int power;
	
		
		
/**
 * Method that returns whether the sorcerer is dead or not based on their life and whether they have a soul.
 *  		
 * @return Returns true if the warlock's life is less than or equal to zero.
 * 
 * Returns true if the warlock has life but no soul.
 * 
 * Returns false for other cases.
 */
		
	public boolean isDead() {
	
		if(life <= 0) {
		
			return true;
		
		}else if(!hasSoul) {
			
			return true;
		
		}
		
		return false;
		
	}
	
	


	
	// NORMALLY GETTERS AND SETTERS METHODS DON´T HAVE TO BE EXPLAINED. THIS SET METHOD WILL BE EXPLAINED BECAUSE IT HAS MANY STATEMENTS
	// If there are more parameters, every parameter has an "@param" and will be explained.

/**
 * Method that sets the sorcerer's power. 
 * Negatives are not allowed; if the attempted power is negative, the power will be set to 0.
 * 	
 * @param Power represents the power that is being set.
 */
	
	public void setPower(int power) {
		
		if(power < 0) {
			
			power = 0;
		
		}else {
			
			this.power = power;
	
		}
		
	}
	
	
	
	
	public int getLife() {
		
		return life;
		
	}
	
	
	
	public void setLife(int life) {
			
		this.life = life;
		
	}
	
	
	
	public boolean ishasSoul() {
		
		return hasSoul;
		
	}
		
		
		
		
	public void setHasSoul(boolean hasSoul) {
			
		this.hasSoul = hasSoul;
		
	}	
		
		
	
public int getPower() {
			
	return power;
		
}
		
}

