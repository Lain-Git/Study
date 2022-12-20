package com.bird.util;

import java.awt.*;

public class Constant {
    //窗口的大小
    public static final int FRAME_WIDTH = 1000;
    public static final int FRAME_HEIGHT = 600;

    //窗口的标题
    public static final String FRAME_TITLE = "飞翔的小鸟";

    //窗口的初始化设置
    public static final int FRAME_X = 200;
    public static final int FRAME_Y = 150;

    //图片路径
    public static final String bg_img_path = "resources/ground.png";

    //游戏背景颜色
    public static final Color bg_color = new Color(0x00C1FC);

    //小鸟图片资源
    public static final String[] bird_img =
            {"resources/0.png","resources/1.png","resources/2.png"
                    ,"resources/3.png","resources/4.png"
                    ,"resources/5.png","resources/6.png","resources/7.png"};

    //障碍物图片资源
    public static final String[] barrier_img_path = {
            "resources/barrier.png","resources/barrier_up.png","resources/barrier_down.png"
    };
}
