import java.awt.*;                      // Messagio di Notifica Windows
import java.awt.TrayIcon.MessageType;


public class Timer extends Cronometro {
    
//Attribute extends by Cronometro 

 public Timer() { 
    super(); 
 }



//Method 
public void setAllarm(int hour, int minutes, int seconds) { 

    int max = 59; 

    this.hour = hour; 
    this.minutes = minutes; 
    this.seconds = seconds; 

    while(this.hour != 0 || this.minutes != 0 || this.seconds != 0) { 

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
        
        if(this.hour < 10 && this.minutes < 10 && this.seconds < 10) {
            System.out.println("0" + this.hour + ":0" + this.minutes + ":0" + this.seconds);
            
        } else if(this.hour < 10 && this.minutes < 10) {
            System.out.println("0" + this.hour + ":0" + this.minutes + ":" + this.seconds);

        } else if(this.hour < 10) {
            System.out.println("0" + this.hour + ":" + this.minutes + ":" + this.seconds);

        } else if(this.minutes < 10 && this.seconds < 10) {
            System.out.println(this.hour + ":0" + this.minutes + ":0" + this.seconds);

        } else if(this.minutes < 10) {
            System.out.println(this.hour + ":0" + this.minutes + ":" + this.seconds);

        } else if(this.seconds < 10) {
            System.out.println(this.hour + ":" + this.minutes + ":0" + this.seconds);

        } else if(this.hour < 10 && this.seconds < 10) {
            System.out.println("0" + this.hour + ":" + this.minutes + ":0" + this.seconds);

        } else {
            System.out.println(this.hour + ":" + this.minutes + ":" + this.seconds);

        }

    } 

    try {
        this.AlarmNotf();
    } catch (AWTException Errore) {
        Errore.printStackTrace();
    }

    }

    public void AlarmNotf() throws AWTException {

        SystemTray tray = SystemTray.getSystemTray(); 

        Image image = Toolkit.getDefaultToolkit().createImage("resource/Immagine.png");
        TrayIcon trayIcon = new TrayIcon(image, "Timer Cronometro");
        trayIcon.setImageAutoSize(true);
        tray.add(trayIcon);
        trayIcon.displayMessage("Timer Finito", "Il TIMER E ARRIVATO ALLA FINE", MessageType.WARNING);

    }


}
