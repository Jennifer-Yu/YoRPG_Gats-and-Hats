import java.io.*;
import java.util.*;


    public class Legendairy{
            
        
        private static final ArrayList<String> stats = new ArrayList();
        private static final ArrayList<String> traits = new ArrayList();
        private static final ArrayList<String> jobs = new ArrayList();
        
        private static ArrayList<String> player = new ArrayList();

        private Character cloud;
        private Character enemy;
        
        private boolean response;
        
        //private InputStreamReader isr;
        //private BufferedReader in;
        
        private Scanner in;
        
        public Legendairy() {
          //  isr = new InputStreamReader( System.in );
	      //  in = new BufferedReader( isr );
	        in = new Scanner(System.in);
	        response = false;
	        stats.add ("Health");
	        stats.add ("Strength");
	        stats.add ("Magic");
	        stats.add ("Defense");
	        stats.add ("Resistance");
	        stats.add ("Luck");
	        stats.add ("Agility");
	        
	        traits.add ("Outgoing");
	        traits.add ("Optimistic");
	        traits.add ("Calm");
	        
	        jobs.add ("Warrior");
	        jobs.add ("Mage");
	        jobs.add ("Archer");
	        
	        //A bit silly, but if the user happens to type it into lower case, the program will accept the input and uppercase it later on.

	        newGame();
        }
        
        public void newGame(){
        	System.out.print("\033[H\033[2J");
			System.out.flush();
            String message = "";
            message = "Welcome to Project Legendairy. \nWe appreciate you volunteering to help out. \nWould you mind telling me your name?";
            System.out.println (message);
            
            //try {
	            player.add (in.nextLine());
	        //}
	        //catch ( IOException e ) {}
	        System.out.print("\033[H\033[2J");
		System.out.flush();
	        
	        message = "Choose your vocation.\n";
	        message += "Warrior\n";
	        message += "Mage\n";
        	message += "Archer\n";
        	
        	
        	while (!response){
                
                //try {
                	System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                String choice =in.nextLine();
	               	System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( jobs.contains (choice) ) {
	                    player.add (choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
            response = false;
	        System.out.print("\033[H\033[2J");
			System.out.flush();
	        message = "What do you think is your strongest asset?\n";
	        message += "\nHealth\n";
	        message += "Strength\n";
        	message += "Magic\n";
        	message += "Defense\n";
        	message += "Resistance\n";
	        message += "Luck\n";
        	message += "Agility\n";
       
            
            
            while (!response){
                
                //try {
                	System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                String choice =in.nextLine();;
	                System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( stats.contains (choice) ) {
	                    player.add (choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
            response = false;
            
            System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "What do you think is your weakest asset?\n";
	        message += "\nHealth\n";
	        message += "Strength\n";
        	message += "Magic\n";
        	message += "Defense\n";
        	message += "Resistance\n";
	        message += "Luck\n";
        	message += "Agility\n";
       
            
            
            while (!response){
                
                //try {
                	System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                String choice =in.nextLine();
	                System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( stats.contains (choice) ) {
	                    player.add(choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
        
        
         response = false;
            System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "Which of the following best describes your character?\n";
        	message += "\nOutgoing\n";
	        message += "Optimistic\n";
	        message += "Calm\n";
        

            
            while (!response){
                
               // try {
               		System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                String choice =in.nextLine();
	                System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( traits.contains (choice) ) {
	                    player.add(choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
            response = false;
            
            //Description will be customized to fit what the player inputed previously
            System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "Hm, so you're " ;
            message += player.get(0);
            message += "?\n";
            System.out.println (message);
            cloud = new WarriorF(player);
       		//System.out.println (player);
       		
       		message = "So... why don't we start the battle simulator?\n";
       		message += "1. Sure!\n";
       		message += "2. No way!\n";
       		
       		while (!response){
       			System.out.println (message);
            	String choice =in.nextLine();
	            System.out.print("\033[H\033[2J");
				System.out.flush();
				if ( choice.equals ("1" )) {
	                    response = true;
	                }
       		}
       		
       		enemy = new Monster();
		System.out.println ("An enemy draws near! \n\n");
       		while( cloud.isAlive() && enemy.isAlive() ) {
       				try{
       					Thread.sleep(1000);
       				}catch (Exception e){}
       				System.out.print("\033[H\033[2J");
					System.out.flush();
       			
		    		System.out.println( "What will you do?" );
		    		System.out.println( "Attack\nNothing\n" );
		    		String choice =in.nextLine();
		    		
		    		cloud.normalize();
		    		if (choice.equals ("Attack")){
		    			int d1 = cloud.regAtk( enemy );
		    			if (d1 <= 0){
							d1 = 0;
						}
		
					
		    			System.out.println ("\n"+ player.get(0) + " smacks the enemy with a stick!" +"\nThe enemy took " + d1 + "!\n\n");
		    			if (cloud.crit){
							System.out.println("It's a critical hit!\n\n");
						}
						
		    			try{
       						Thread.sleep(200);
       					}catch (Exception e){}
        				
        				//System.out.print("\033[H\033[2J");
						//System.out.flush();
		    		}
		    		
		    		if (enemy.isAlive()) {
						int d2 = enemy.regAtk( cloud );
							if (d2 <= 0){
								d2 = 0;
						}
						System.out.println ("The enemy slaps " + player.get(0) +"!" +"\n" + player.get(0)+ " took " + d2 + "!\n\n");
						if (enemy.crit){
							System.out.println("It's a critical hit!\n\n");
						}
						
						try{
       						Thread.sleep(1500);
       					}catch (Exception e){}
        				System.out.print("\033[H\033[2J");
						System.out.flush();
		    		}
		    		
		    		else{
		    			System.out.println ("You win!");
		    			break;
		    		}
				
			}
			
			if (!cloud.isAlive()){
				System.out.println ("You lose.");
			}
            
            
        
        }
        
        public static void main (String[] args){
            Legendairy game = new Legendairy();
        }
    }
