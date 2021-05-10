public class timer extends Cronometro {
    
//Attribute extends by Cronometro 

 public timer() { 

    super(); 

 }



//Method 
public void setAllarm(int ora, int minutes, int seconds) { 

    int max = 59; 

    this.hour = ora; 
    this.minutes = minutes; 
    this.seconds = seconds; 

    while(this.hour != 0 && this.minutes != 0 && this.seconds != 0) { 

        if(this.seconds > 0) {
            
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
               System.out.println(e);
            }
           this.seconds--; 

        } else if (this.minutes > 0) {

            this.minutes--; 
            this.seconds = max; 

        } else if (this.hour > 0) {

            this.hour--; 
            this.minutes = max; 
            this.seconds = max; 
        }
        

    } 
    
}



}


