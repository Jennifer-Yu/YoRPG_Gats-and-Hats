/* abstract Mage class - contains and defines specific Mage methods
 * 
 * Notes:
 *	
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;

public abstract class Mage extends gChar{

	public int arcaniteForce(gChar enemy) {

		this.crit = false;
		int damage = this.magic - enemy.res + 10;

		if ( (Math.random() *100) <=luck){
		    this.crit = true;
		    damage = (int)(damage*1.03);
		}

		enemy.HP -= damage;
		return(damage);

        }
	
	
	




}

