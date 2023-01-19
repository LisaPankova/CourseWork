package ru.fantasy.client;

import ru.fantasy.api.data.characters;

import javax.swing.*;
import java.awt.*;

public class charactersRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        setText(((characters)value).getName());
        return this;
    }

}
