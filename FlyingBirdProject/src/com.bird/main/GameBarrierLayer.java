package com.bird.main;


import java.awt.*;
import java.io.*;
import java.security.DrbgParameters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 障碍物层类
 */
public class GameBarrierLayer {
    private GameTime gameTime;

    private int txt;

    private Random random = new Random();

    private List<Barrier> barriers;

    public GameBarrierLayer() {
        barriers = new ArrayList<>();
        gameTime = new GameTime();
    }

    //绘制障碍物
    public void draw(Graphics g, Bird bird) throws IOException {
        for (int i = 0; i < barriers.size(); i++) {
            Barrier barrier = barriers.get(i);
            if(barrier.isVisible()) {
                barrier.draw(g);
            } else {
                Barrier remove = barriers.remove(i);
                BarrierPool.setPool(remove);
                i--;
            }
        }
        collideBird(bird);
        logic(g);
    }

    public void logic(Graphics g) throws IOException {
        if (barriers.size() == 0) {
            ran();
            gameTime.begin();
            insert(1000,0,numberTop,0);
            insert(1000,600 - numberDown,numberDown,2);
        } else {
            long differ = gameTime.differ();
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑", 1, 20));
            g.drawString("坚持了：" + differ + "秒", 50, 50);

            txt = getTxt();
            if(differ <= txt) {
                g.drawString("最高成绩" + txt,200,50);
            } else {
                setTxt(String.valueOf(differ));
                g.drawString("最高成绩" + getTxt(),200,50);
            }

            //判断最后一个障碍物是否完全进入屏幕内
            Barrier last = barriers.get(barriers.size() - 1);
            if(last.isInFrame()) {
                ran();
                if (number < 50) {
                    insert(1000, 32, 350, 4);
                } else if (number > 400) {
                    insert(1000, 150,250,6);
                } else {
                    insert(1000,0,numberTop,0);
                    insert(1000,600 - numberDown,numberDown,2);
                }
            }
        }
    }

    File file = new File("D:\\IDEA\\Projects\\Project Practice\\src\\com.bird\\The Highest Record.txt");
    /**
     * 用于得到文件中的数据
     */
    public int getTxt() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        int read = Integer.parseInt(in.readLine());
        in.close();
        return read;
    }

    /**
     * 用于储存数据
     */
    public void setTxt(String str) throws IOException {
        FileWriter fillWriter = new FileWriter(file);
        fillWriter.write(str);
        fillWriter.close();
    }

    /**
     * 用于从池中获取对象，并把参数封装成barrier，存入barriers数组中
     */
    public void insert(int x, int y, int num, int type) {
        Barrier top = BarrierPool.getPool();
        top.setX(x);
        top.setY(y);
        top.setHeight(num);
        top.setType(type);
        top.setVisible(true);
        barriers.add(top);
    }

    //上方障碍物高度
    private int numberTop;
    //下方障碍物高度
    private int numberDown;

    private int number;

    //产生两个150~600之间的随机高度
    public void ran() {
        numberTop = random.nextInt(450) + 150;
        numberDown = random.nextInt(450) + 150;

        number = random.nextInt(500);

        //如果管道重合，则重新生成
        if (numberTop + numberDown > 550) {
            ran();
        }
    }

    /**
     * 判断小鸟与障碍物发生碰撞
     */
    public boolean collideBird(Bird bird) {
        for (int i = 0; i < barriers.size(); i++) {
            Barrier barrier = barriers.get(i);
            //判断矩形是否相交
            if (barrier.getRect().intersects(bird.getRect())) {
                System.out.println("撞到一起");
                bird.life = false;
            }
        }
        return false;
    }

    /**
     * 用于清空障碍物池
     */
    public void reStart() {
        barriers.clear();
    }
}
