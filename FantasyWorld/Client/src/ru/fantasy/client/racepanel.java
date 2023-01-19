package ru.fantasy.client;

import javax.swing.*;
import java.awt.*;

public class racepanel extends JPanel {
    public racepanel() {
        super();
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.RIGHT);
        tabbedPane.addTab("эльфы", new racePaneFirst("эльфы", "краткое описание"));
        tabbedPane.addTab("люди", new racePaneFirst("люди", "краткое описание"));
        tabbedPane.addTab("оборотни", new racePaneFirst("оборотни", "краткое описание"));
        tabbedPane.addTab("ингисы", new racePaneFirst("ингисы", "краткое описание"));
        add(tabbedPane);


    }
}
