package ru.fantasy.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        super("Fantasy world");

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Информация");
        JMenuItem item1 = new JMenuItem("об игре");
        JMenuItem item2 = new JMenuItem("о возможностях");
        menuFile.add(item1);
        menuFile.add(item2);
        JMenuItem itemExit = new JMenuItem("Выход");
        menuBar.add(menuFile);
        menuBar.add(itemExit);

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainFrame.this, "Игра формата текстовой ролевой, где каждый отыгрывает своего придуманного персонажа. Здесь хранится основная информация о персонажах и мире.","об игре", 1);
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainFrame.this, "Здесь можно: добавить и удалить персонажа, узнать местонахождение каждого, принадлежность к расе и какой магией владеет.", "о возможностях", 1);
            }
        });

        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Персонажи", new charactersPanel());
        tabbedPane.addTab("Страны", new countriesPanel());
        tabbedPane.addTab("Магия", new magicPanel());
        tabbedPane.addTab("Расы", new racepanel());
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        setJMenuBar(menuBar);
    }
}
