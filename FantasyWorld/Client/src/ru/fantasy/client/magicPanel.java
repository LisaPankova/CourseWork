package ru.fantasy.client;

import javax.swing.*;
import java.awt.*;

public class magicPanel extends JPanel {
    public magicPanel() {
        super();
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.RIGHT);
        tabbedPane.addTab("Высшая магия", new MagicPaneFirst("Высшая"));
        tabbedPane.addTab("Стандартная магия", new MagicPaneFirst("Стандартная"));
        tabbedPane.addTab("Древняя магия", new MagicPaneFirst("Древняя"));
        tabbedPane.addTab("Низшая магия", new MagicPaneFirst("Низшая"));
        add(tabbedPane);
    }
}
