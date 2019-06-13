package lifegame;

import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
 
import javax.swing.Timer;  


public class TimeClass
{
	// 动画帧之间的延时，每秒60帧  
    private final int DELAY_TIME = 1200;  
	Timer timer;
	public WorldMap wordmap;
	
	TimeClass()
	{
		wordmap=new WorldMap();
		 // 创建计时器  
        timer = new Timer(DELAY_TIME, new ActionListener() {  
  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                wordmap.logic.changeCellStatus(wordmap.nextStatus,wordmap.tempStatus);  
                wordmap.copyWorldMap();
                wordmap.repaint();  
            }  
        });  
        // 开启计时器  
        timer.start();  
	}
}
