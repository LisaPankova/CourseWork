package ru.fantasy.client;

import com.caucho.hessian.client.HessianProxyFactory;
import ru.fantasy.api.data.characters;
import ru.fantasy.api.services.CharacterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.List;

public class MagicPaneFirst extends JPanel {
    public MagicPaneFirst(String magic) {
        super();
        setLayout(new BorderLayout());

        JPanel GrPanel = new JPanel(new GridLayout(1,3));
        JPanel infoPanel = new JPanel(new BorderLayout());
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Первый тип"));
        infoPanel.add(namePanel, BorderLayout.NORTH);
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.add(new JLabel("описание"), BorderLayout.CENTER);
        descriptionPanel.setBorder(BorderFactory.createTitledBorder("Описание"));
        infoPanel.add(descriptionPanel, BorderLayout.SOUTH);
        GrPanel.add(infoPanel);
        add(GrPanel, BorderLayout.NORTH);

        JPanel infoPanel1 = new JPanel(new BorderLayout());
        JPanel namePanel1 = new JPanel();
        namePanel1.add(new JLabel("Второй тип"));
        infoPanel1.add(namePanel1, BorderLayout.NORTH);
        JPanel descriptionPanel1 = new JPanel();
        descriptionPanel1.add(new JLabel("описание"), BorderLayout.CENTER);
        descriptionPanel1.setBorder(BorderFactory.createTitledBorder("Описание"));
        infoPanel1.add(descriptionPanel1, BorderLayout.SOUTH);
        GrPanel.add(infoPanel1);

        JPanel infoPanel2 = new JPanel(new BorderLayout());
        JPanel namePanel2 = new JPanel();
        namePanel2.add(new JLabel("Второй тип"));
        infoPanel2.add(namePanel2, BorderLayout.NORTH);
        JPanel descriptionPanel2 = new JPanel();
        descriptionPanel2.add(new JLabel("описание"), BorderLayout.CENTER);
        descriptionPanel2.setBorder(BorderFactory.createTitledBorder("Описание"));
        infoPanel2.add(descriptionPanel2, BorderLayout.SOUTH);
        GrPanel.add(infoPanel2);


        JButton lookButton = new JButton("узнать, кто владеет этой магией.");
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
                    List<characters> characters = characterService.lookMagic(magic);
                    for (int i = 0; i < characters.size(); i++) {
                        if (i != characters.size()-1) message = message + characters.get(i).getName() + ", ";
                            else message = message + characters.get(i).getName() + ". ";
                    }
                    if (characters.size() == 0) message = "Никто не владеет этой магией.";
                    JOptionPane.showMessageDialog(MagicPaneFirst.this, message, "Владеют первой магией", JOptionPane.INFORMATION_MESSAGE);
                }   catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

}
