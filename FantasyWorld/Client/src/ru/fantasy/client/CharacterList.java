package ru.fantasy.client;

import ru.fantasy.api.data.characters;
import javax.swing.*;

public class CharacterList extends JList<characters> {
    public CharacterList() {
        super(new charactersModel<>());
        setCellRenderer(new charactersRenderer());
    }

    public charactersModel getcharactersModel() { return (charactersModel) getModel(); }
}
