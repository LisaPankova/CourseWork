package ru.fantasy.client;

import ru.fantasy.api.data.countries;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class countriesModel extends AbstractListModel<countries> {
    private List<countries> list = new ArrayList<>();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public countries getElementAt(int index) {
        return list.get(index);
    }

}
