package com.bbking.yedis.ui;

import com.bbking.yedis.constants.Constant;

import javax.swing.*;
import java.awt.*;

/**
 * Yedis菜单
 *
 * @author BBKing
 * @date 2018-10-22
 */
public class YedisMenuBar extends JMenuBar {
    public YedisMenuBar() {
        Color color = new Color(60, 63, 65);
        JMenu add = new JMenu();
        ImageIcon addIcon = new ImageIcon(this.getClass().getClassLoader().getResource(Constant.ADD_MENU));
        add.setIcon(addIcon);
        add.setText("Add");
        add.setForeground(Color.WHITE);
        add.setToolTipText("Add Redis Server");
        this.add(add);
        this.setBackground(color);
    }
}
