package ru.fantasy.client;

import ru.fantasy.api.data.characters;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class charactersModel<characters> extends AbstractListModel<characters> {
    private List<characters> list = new ArrayList<>();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public characters getElementAt(int index) {
        return list.get(index);
    }

    public void setCharactersList(List<characters> charactersList) {
        list = charactersList;
    }

    public void addCharacter(characters character) {
        list.add(character);
        fireIntervalAdded(character,list.size()-1, list.size()-1);
    }

    public void delCharacter(characters character)
    {
        list.remove(character);
        fireIntervalRemoved(character, list.size(), list.size());
    }
}
