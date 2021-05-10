
public class Cronometro {
	
	int hour;
	int minutes;
	int seconds;
	
	public Cronometro() {
		
		this.hour = 0;
		this.minutes = 0;
		this.seconds = 0;
		
	}
	
	//Set all methods:
	
	public void start() {
	
		// When the hour will be 60, the watch will stop himself giving a text massage to user
		while(this.hour < 60) {
			
			// Check minutes
			if(this.minutes < 60) {
				
				// Check seconds
				if(this.seconds < 60) {
					this.seconds++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					this.minutes++;
				}
				
			} else {
				this.hour++;
			}
		}
		
	}
	
	public void reset() {
		
		this.hour = 0;
		this.minutes = 0;
		this.seconds = 0;
		
	}
	
	public void stop() {
		
		this.hour = 0;
		this.minutes = 0;
		this.seconds = 0;
		
	}
	
	public void pause() {
		
		
		
	}
}
