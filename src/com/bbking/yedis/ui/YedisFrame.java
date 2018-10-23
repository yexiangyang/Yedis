package com.bbking.yedis.ui;

import com.bbking.yedis.constants.Constant;

import javax.swing.*;
import java.awt.*;

/**
 * Yedis客户端主窗口
 *
 * @author BBKing
 * @date 2018-10-19
 */
public class YedisFrame extends JFrame {
    public static void main(String[] args) {
        YedisFrame yedisFrame = new YedisFrame();

    }

    public YedisFrame() {
        //设置标题
        this.setTitle(Constant.TITLE);
        //设置图标
        this.setIconImage(this.loadFrameIconImage());
        //设置大小
        this.setSize(this.getScreenSize());
        //设置背景色
        Color color = new Color(43, 43, 43);
        this.getContentPane().setBackground(color);
        this.setJMenuBar(new YedisMenuBar());
        //设置显示
        this.setVisible(true);
    }

    /**
     * 加载主窗口默认图标
     *
     * @return 主窗口默认图标
     */
    private Image loadFrameIconImage() {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getClassLoader().getResource(Constant.FRAME_ICON_PATH));
        return imageIcon.getImage();
    }

    /**
     * 获取屏幕大小,不包含状态栏
     *
     * @return 屏幕大小
     */
    private Dimension getScreenSize() {
        //获取屏幕大小
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        //获取状态栏
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int width = (int) (dimension.getWidth() - insets.left - insets.right);
        int height = (int) (dimension.getHeight() - insets.top - insets.bottom);
        return new Dimension(width, height);
    }
}
