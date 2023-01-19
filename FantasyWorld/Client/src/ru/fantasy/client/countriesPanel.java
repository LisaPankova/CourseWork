package ru.fantasy.client;

import ru.fantasy.api.data.countries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class countriesPanel extends JPanel {
    public countriesPanel() {
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT);
        tabbedPane.addTab("Энра", new countriesPaneFirst("Энра", "описание 1"));
        tabbedPane.addTab("Драуфенни", new countriesPaneFirst("Драуфенни", "описание 2"));
        tabbedPane.addTab("Анталинг", new countriesPaneFirst("Анталинг", "описание 3"));
        tabbedPane.addTab("Суофиа", new countriesPaneFirst("Суофиа", "описание 4"));
        tabbedPane.addTab("Водная страна", new countriesPaneFirst("Водная страна", "описание 5"));
        add(tabbedPane);
    }
}
