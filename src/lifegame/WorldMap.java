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
  
public class WorldMap extends JPanel {  
  
    private static final long serialVersionUID = -336975817478756636L;  
  
    //��������
    //������
    private final int width = 22;  
    private final int height = 22;  
  
    //�������ı�־
    private final char WORLD_MAP_NONE = 'N';  
    private final char WORLD_MAP_ALIVE = 'A';  
  
    //��ʼ������ͼ��
    private final char[][] world = {  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A',  
                    'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A',  
                    'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N',  
                    'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'A', 'A', 'A', 'N', 'A', 'A', 'A', 'N', 'A', 'N', 'N', 'N',  
                    'A', 'A', 'N', 'N', 'N', 'A', 'N', 'A', 'A', 'A', 'A', 'A',  
                    'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'A',  
                    'N', 'N', 'A', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'A', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'A', 'N',  
                    'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'A', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'A', 'N',  
                    'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'A', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'A',  
                    'N', 'N', 'A', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'A', 'A', 'A', 'N', 'N', 'A', 'N', 'N', 'A', 'N', 'N', 'N',  
                    'A', 'A', 'N', 'N', 'N', 'A', 'N', 'A', 'A', 'A', 'A', 'A',  
                    'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A',  
                    'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N',  
                    'N' },  
            { 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A',  
                    'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N',  
                    'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',  
                    'N' },  
  
    };  
  
    private final char[][] world2 = {  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'A', 'A', 'A', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' }  
  
    };  
  
   // private Image none = LifeGameImages.NONE.getImage();  
  // private Image alive = LifeGameImages.ALIVE.getImage();  
  
    /** 
     * ��ǰϸ����һ״̬ 
     */  
    char[][] nextStatus = new char[world.length][world[0].length];  
  
    char[][] tempStatus = new char[world.length][world[0].length];  
    
    //�߼�����
    public Logic logic=new Logic();
  
    
  
    /** 
     * ��ͼ�ν��� 
     *  
     */  
    @Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        for (int i = 0; i < nextStatus.length; i++) {  
            for (int j = 0; j < nextStatus[i].length; j++) {  
                if (nextStatus[i][j] == WORLD_MAP_ALIVE) {  
                    g.fillRect( j * width, i * height, width, height);  
                   
                } else {  
                	 g.drawRect( j * width, i * height, width, height); 
                }  
            }  
        }  
    }  
  
  
    /** 
     * ���캯��
     *  
         */  
    WorldMap() {  
        for (int row = 0; row < world.length; row++) {  
            for (int col = 0; col < world[0].length; col++) {  
                nextStatus[row][col] = world[row][col];  
                tempStatus[row][col] = world[row][col];  
            }  
        }  
     
    }  
  
    /** 
     * ���Ƶ�ͼ 
     *  
 
     */  
    void copyWorldMap() {  
        for (int row = 0; row < nextStatus.length; row++) {  
            for (int col = 0; col < nextStatus[row].length; col++) {  
                tempStatus[row][col] = nextStatus[row][col];  
            }  
        }  
    }  
}  