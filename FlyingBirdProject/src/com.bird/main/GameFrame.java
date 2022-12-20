package com.bird.main;

import javax.swing.plaf.metal.MetalInternalFrameUI;

import static com.bird.util.Constant.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 游戏的主窗口类，所有关于游戏中绘制的内容都在此类中
 */

//继承Frame类，就拥有了创建窗口的功能
public class GameFrame extends Frame {

    //实例化GameBackground
    private GameBackground gameBackground;

    //实例化Bird类
    private Bird bird;

    //实例化GameBarrierLayer类
    private GameBarrierLayer gameBarrierLayer;

    //实例化GameFront类
    private GameFront gameFront;

    //存放图片的图片
    private BufferedImage buffimg = new BufferedImage(FRAME_WIDTH,FRAME_HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);

    //构造方法中初始化一些参数
    public GameFrame() {
        //窗口是否可见
        setVisible(true);

        //窗口的大小
        setSize(FRAME_WIDTH,FRAME_HEIGHT);

        //窗口的标题
        setTitle(FRAME_TITLE);

        //窗口的初始化设置
        setLocation(FRAME_X,FRAME_Y);

        //窗口的大小不可改变
        setResizable(false);

        //窗口的关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                //结束程序
            }
        });

        initGame();

        new Run().start();

        //添加按键监听器
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                add(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                minu(e);
            }
        });
    }

    //对游戏中的对象初始化
    public void initGame() {
        gameBackground = new GameBackground();
        bird = new Bird();
        gameFront = new GameFront();
        gameBarrierLayer = new GameBarrierLayer();
    }

    class Run extends Thread {
        @Override
        public void run() {
            while(true) {
                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 所有需要绘制的内容都在此方法中进行调用绘制
     */
    @Override
    public void update(Graphics g) {
        if(bird.life) {
            //得到图片的画笔
            Graphics graphics = buffimg.getGraphics();

            gameBackground.draw(graphics);
            bird.draw(graphics);
            gameFront.draw(graphics);
            try {
                gameBarrierLayer.draw(graphics, bird);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //一次性将图片绘制在屏幕中
            g.drawImage(buffimg,0,0,null);
        } else {
            String over = "游戏结束";
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑", 1, 60));
            g.drawString(over, 360, 300);

            String reset = "Space Reset Game";
            g.drawString(reset,200,430);
        }


    }

    //按键
    public void add(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                bird.fly(1);
                break;
            case KeyEvent.VK_SPACE:
                if (bird.life == false) {
                    reStart();
                }
                break;
        }
    }

    //抬键
    public void minu(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                bird.fly(2);
                break;
        }
    }

    //重置游戏
    public void reStart() {
        gameBarrierLayer.reStart();
        bird.reStartDraw();
    }
}
