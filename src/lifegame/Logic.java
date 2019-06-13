package lifegame;

import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import javax.swing.JPanel;  
import javax.swing.Timer;  
  
/** 
 *  
  */  
  
public class Logic extends JPanel {  
  
    //������־
    private final char WORLD_MAP_NONE = 'N';  
    private final char WORLD_MAP_ALIVE = 'A';  
    
    
    
    /** 
     * �ı�ϸ��״̬ 
     *  
        */  
    public void changeCellStatus(char[][] nextStatus,char[][] tempStatus) {  
        for (int row = 0; row < nextStatus.length; row++) {  
            for (int col = 0; col < nextStatus[row].length; col++) {  
  
                switch (neighborsCount(row, col,nextStatus,tempStatus)) {  
                case 0:  
                case 1:  
                case 4:  
                case 5:  
                case 6:  
                case 7:  
                case 8:  
                    nextStatus[row][col] = WORLD_MAP_NONE;  
                    break;  
                case 2:  
                    nextStatus[row][col] = tempStatus[row][col];  
                    break;  
                case 3:  
                    nextStatus[row][col] = WORLD_MAP_ALIVE;  
                    break;  
                }  
            }  
        }  
    }  
  
    /** 
     * ��ȡ��ǰ������ٽ�ϸ������ 
     *  
         */  
    private int neighborsCount(int row, int col,char[][] nextStatus,char[][] tempStatus) {  
        int count = 0, r = 0, c = 0;  
  
        for (r = row - 1; r <= row + 1; r++) {  
            for (c = col - 1; c <= col + 1; c++) {  
                if (r < 0 || r >= tempStatus.length || c < 0  
                        || c >= tempStatus[0].length) {  
                    continue;  
                }  
                if (tempStatus[r][c] == WORLD_MAP_ALIVE) {  
                    count++;  
                }  
            }  
        }  
        if (tempStatus[row][col] == WORLD_MAP_ALIVE) {  
            count--;  
        }  
        return count;  
    }  
}  
