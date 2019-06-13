package lifegame;

import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
 
import javax.swing.Timer;  


public class TimeClass
{
	// ����֮֡�����ʱ��ÿ��60֡  
    private final int DELAY_TIME = 1200;  
	Timer timer;
	public WorldMap wordmap;
	
	TimeClass()
	{
		wordmap=new WorldMap();
		 // ������ʱ��  
        timer = new Timer(DELAY_TIME, new ActionListener() {  
  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                wordmap.logic.changeCellStatus(wordmap.nextStatus,wordmap.tempStatus);  
                wordmap.copyWorldMap();
                wordmap.repaint();  
            }  
        });  
        // ������ʱ��  
        timer.start();  
	}
}
