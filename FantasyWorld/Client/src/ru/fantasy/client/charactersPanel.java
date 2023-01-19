package ru.fantasy.client;

import com.caucho.hessian.client.HessianProxyFactory;
import ru.fantasy.api.data.characters;
import ru.fantasy.api.data.countries;
import ru.fantasy.api.data.magic;
import ru.fantasy.api.data.races;
import ru.fantasy.api.services.CharacterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class charactersPanel extends JPanel {
    public charactersPanel() {
        CharacterList list = new CharacterList();

        try {
            String url = "http://127.0.0.1:8080/character";
            HessianProxyFactory factory = new HessianProxyFactory();
            CharacterService characterService = (CharacterService) factory.create(CharacterService.class, url);
            list.getcharactersModel().setCharactersList(characterService.getCharacterList());
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }

        charactersModel<characters> model = new charactersModel<>();
        JTextField nameField = new JTextField(15);
        JTextArea aboutArea = new JTextArea();
        JButton addButton = new JButton("Добавить");
        JButton delButton = new JButton("Удалить");
        JButton checkButton = new JButton("Посмотреть");

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(addButton);
        toolBar.add(delButton);
        toolBar.add(checkButton);

        ArrayList<String> cont = new ArrayList<String>();
        countries country1 = new countries();
        country1.setName("Энра");
        cont.add(country1.getName());
        countries country2 = new countries();
        country2.setName("Драуфенни");
        cont.add(country2.getName());
        countries country3 = new countries();
        country3.setName("Суофиа");
        cont.add(country3.getName());
        countries country4 = new countries();
        country4.setName("Анталинг");
        cont.add(country4.getName());
        countries country5 = new countries();
        country5.setName("Водная страна");
        cont.add(country5.getName());
        JComboBox<countries> comboBox = new JComboBox<>(new countries[]{country1, country2, country3, country4, country5});
        comboBox.setSelectedIndex(0);
        comboBox.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(((countries)value).getName());
                return this;
            }
        });
        add(comboBox, BorderLayout.NORTH);

        ArrayList<String> rac = new ArrayList<String>();
        races race1 = new races();
        race1.setName("эльфы");
        rac.add(race1.getName());
        races race2 = new races();
        race2.setName("люди");
        rac.add(race2.getName());
        races race3 = new races();
        race3.setName("оборотни");
        rac.add(race3.getName());
        races race4 = new races();
        race4.setName("ингисы");
        rac.add(race4.getName());;
        JComboBox<races> comboBoxR = new JComboBox<>(new races[]{race1, race2, race3, race4});
        comboBoxR.setSelectedIndex(0);
        comboBoxR.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(((races)value).getName());
                return this;
            }
        });
        add(comboBoxR, BorderLayout.NORTH);

        ArrayList<String> mag = new ArrayList<String>();
        magic magic0 = new magic();
        magic0.setName("не владеет магией");
        mag.add(magic0.getName());
        magic magic1 = new magic();
        magic1.setName("Высшая");
        mag.add(magic1.getName());
        magic magic2 = new magic();
        magic2.setName("Стандартная");
        mag.add(magic2.getName());
        magic magic3 = new magic();
        magic3.setName("Древняя");
        mag.add(magic3.getName());
        magic magic4 = new magic();
        magic4.setName("Низшая");
        mag.add(magic4.getName());
        JComboBox<magic> comboBoxM = new JComboBox<>(new magic[]{magic0, magic1, magic2, magic3, magic4});
        comboBoxM.setSelectedIndex(0);
        comboBoxM.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(((magic)value).getName());
                return this;
            }
        });
        add(comboBoxM, BorderLayout.NORTH);

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Имя: "));
        namePanel.add(nameField);
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.add(new JLabel("Находится сейчас в: "));
        statusPanel.add(comboBox, BorderLayout.NORTH);
        statusPanel.add(new JLabel("Раса: "));
        statusPanel.add(comboBoxR, BorderLayout.CENTER);
        statusPanel.add(new JLabel("Владеет магией: "));
        statusPanel.add(comboBoxM, BorderLayout.SOUTH);


        JPanel aboutPanel = new JPanel(new BorderLayout());
        aboutPanel.add(aboutArea, BorderLayout.CENTER);
        aboutPanel.setBorder(BorderFactory.createTitledBorder("Описание"));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(toolBar, BorderLayout.NORTH);
        leftPanel.add(list, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        JPanel hightPanel = new JPanel(new BorderLayout());
        hightPanel.add(namePanel, BorderLayout.NORTH);
        hightPanel.add(statusPanel, BorderLayout.SOUTH);
        rightPanel.add(hightPanel, BorderLayout.NORTH);
        rightPanel.add(aboutPanel, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(250);

        setLayout(new BorderLayout());
        add(splitPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int index = comboBox.getSelectedIndex();
                String location = cont.get(index);
                String description = aboutArea.getText();
                int indexM = comboBoxM.getSelectedIndex();
                String magic = mag.get(indexM);
                int indexR = comboBoxR.getSelectedIndex();
                String race = rac.get(indexR);
                if (name != null) {
                    characters character = new characters();
                    character.setName(name);
                    character.setLocation(location);
                    character.setDescription(description);
                    character.setMagic(magic);
                    character.setRace(race);
                    try {
                        String url = "http://127.0.0.1:8080/character";
                        HessianProxyFactory factory = new HessianProxyFactory();
                        factory.setOverloadEnabled(true);
                        CharacterService characterService = (CharacterService) factory.create(CharacterService.class, url);
                        String id = characterService.addCharacter(character);
                        character.setId(id);
                        String sql = "INSERT INTO characters(id, character_name, location, description, magic, race) VALUES (\'" + character.getId() + "\'," +
                                " \'" + character.getName() + "\', \'" + character.getLocation() + "\' , \'" + character.getDescription() + "\', \'" +
                                character.getMagic() + "\', \'" + character.getRace() + "\')";
                        characters character1 = characterService.getCharacter(id);
                        list.getcharactersModel().addCharacter(character1);
                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                nameField.setText("");
                aboutArea.setText("");
                comboBox.setSelectedIndex(0);
                comboBoxR.setSelectedIndex(0);
                comboBoxM.setSelectedIndex(0);
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characters character = list.getSelectedValue();
                try {
                    String url = "http://127.0.0.1:8080/character";
                    HessianProxyFactory factory = new HessianProxyFactory();
                    CharacterService characterService = (CharacterService) factory.create(CharacterService.class, url);
                    characterService.delCharacter(character.getId());
                    list.getcharactersModel().delCharacter(character);
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characters character = list.getSelectedValue();
                try {
                    String url = "http://127.0.0.1:8080/character";
                    HessianProxyFactory factory = new HessianProxyFactory();
                    CharacterService characterService = (CharacterService) factory.create(CharacterService.class, url);
                    characterService.getCharacter(character.getId());
                    String name = characterService.getCharacter(character.getId()).getName();
                    String location = characterService.getCharacter(character.getId()).getLocation();
                    String description = characterService.getCharacter(character.getId()).getDescription();
                    if (character.getDescription() == "") description = "нет";
                    String magic = characterService.getCharacter(character.getId()).getMagic();
                    String race = characterService.getCharacter(character.getId()).getRace();
                    JOptionPane.showMessageDialog(charactersPanel.this, " Имя:  " + name +
                            ".\n Находится: " + location + ".\n Описание: " + description + ".\n Раса: " + race + ".\n Магия: " +
                            magic + ".", "Информация о персонаже", JOptionPane.INFORMATION_MESSAGE);
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
