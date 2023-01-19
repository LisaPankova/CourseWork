package ru.fantasy.api.services;

import ru.fantasy.api.data.characters;
import ru.fantasy.api.data.countries;
import java.util.List;

public interface CharacterService {

    String addCharacter(characters character);

    void delCharacter(String id);

    characters getCharacter(String id);

    List<characters> lookCountry(String name);

    List<characters> lookMagic(String name);

    List<characters> lookRace(String name);

    List<characters> getCharacterList();
}
