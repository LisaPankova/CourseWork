package ru.fantasy.client;

import com.caucho.hessian.client.HessianProxyFactory;
import ru.fantasy.api.data.characters;
import ru.fantasy.api.data.countries;
import ru.fantasy.api.services.CharacterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class countriesPaneFirst extends JPanel {
    public countriesPaneFirst(String name, String description) {
        super();
        setLayout(new BorderLayout());


        JPanel infoPanel = new JPanel(new BorderLayout());
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Название страны: " + name));

        infoPanel.add(namePanel, BorderLayout.NORTH);
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.add(new JLabel(description), BorderLayout.CENTER);
        descriptionPanel.setBorder(BorderFactory.createTitledBorder("Описание"));
        infoPanel.add(descriptionPanel, BorderLayout.SOUTH);
        add(infoPanel, BorderLayout.NORTH);

        JButton lookButton = new JButton("узнать, кто сейчас находится здесь.");
        JPanel lookPanel = new JPanel();
        lookPanel.add(lookButton);
        add(lookButton, BorderLayout.AFTER_LAST_LINE);

        lookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "http://127.0.0.1:8080/character";
                    HessianProxyFactory factory = new HessianProxyFactory();
                    factory.setOverloadEnabled(true);
                    CharacterService characterService = (CharacterService) factory.create(CharacterService.class, url);
                    String message = "";
                    List<characters> characters = characterService.lookCountry(name);
                    for (int i = 0; i < characters.size(); i++) {
                        if (i != characters.size()-1) message = message + characters.get(i).getName() + ", ";
                        else message = message + characters.get(i).getName() + ". ";
                    }
                    if (characters.size() == 0) message = "никто здесь не находится.";
                    JOptionPane.showMessageDialog(countriesPaneFirst.this, message, "В стране " + name + " находятся:", JOptionPane.INFORMATION_MESSAGE);
                }   catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
