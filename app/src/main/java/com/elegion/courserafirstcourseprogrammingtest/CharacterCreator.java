package com.elegion.courserafirstcourseprogrammingtest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class CharacterCreator extends Observable  implements Serializable{

    public enum Specialization {
        WARRIOR, ARCHER, MAGE;

    }

    public enum Race {
        HUMAN, ELF, ORC, DWARF;

    }

    public enum Attribute {
        STRENGTH, AGILITY, INTELLECT, STAMINA, LUCK;

    }

    public enum Perk {
        BERSERK, CALM, LIGHTWEIGHT, HEAVYARMORED, OBSERVANT, MEDITATIONS;
    }

    private String mName;
    private Specialization mSpecialization;
    private Race mRace;
    private int mAvailablePoints;

    private Map<String, Integer> mAttributesMap = new HashMap<>();
    private Map<String, Boolean> mPerksMap = new HashMap<>();


    public CharacterCreator() {
        mRace = Race.HUMAN;
        mSpecialization = Specialization.WARRIOR;
        mAvailablePoints = 5;
        mAttributesMap.put(Attribute.STRENGTH.name(), 5);
        mAttributesMap.put(Attribute.AGILITY.name(), 5);
        mAttributesMap.put(Attribute.INTELLECT.name(), 5);
        mAttributesMap.put(Attribute.STAMINA.name(), 5);
        mAttributesMap.put(Attribute.LUCK.name(), 5);
    }


    public String[] getSpecializations() {
        /*
        *   этот метод должен возвращать массив строк, созданных на основе enum Specialization
        *   Строки должны начинаться с заглавной буквы, остальные строчные
        * */
        List<String> SpecNames = new ArrayList<>();
        for (Specialization i : Specialization.values()) {
            String tmp = i.name().toLowerCase();
            tmp = tmp.substring(0, 1).toUpperCase() + tmp.substring(1);
            SpecNames.add(tmp);
        }
        String[] SpecNamesArray = new String[SpecNames.size()];
        SpecNames.toArray(SpecNamesArray);
        return SpecNamesArray;

    }

    public void setSpecialization(int position) {
        /*
        *  этот метод задает специализацию в переменную mSpecialization
        *  на вход подается число, и из enum Specialization выбирается соответствующий класс
        *  0 - Warrior
        *  1 - Archer
        *  2 - Mage
        *  если введенное число меньше 0, то в mSpecialization записывается самое первое (порядковый номер - 0) значение
        *  если введенное число больше длины enum, то в mSpecialization записывается самое последнее (длина - 1) значение
        *
        * */
        for (Specialization i : Specialization.values()) {
            if (position == i.ordinal()) {
                mSpecialization = i;
                return;
            }
        }
        if (position > Specialization.MAGE.ordinal()) {
            mSpecialization = Specialization.MAGE;
            return;
        }
        if (position < Specialization.WARRIOR.ordinal()) {
            mSpecialization = Specialization.WARRIOR;
        }
    }

    public String[] getRaces() {
        /*
        *   этот метод должен возвращать массив строк, созданных на основе enum Races
        *    Строка должна быть формата - первая буква заглавная, остальные строчные
        *   One, Two, Three
        * */
        List<String> RacesNames = new ArrayList<>();
        for (Race i : Race.values()) {
            String tmp = i.name().toLowerCase();
            tmp = tmp.substring(0, 1).toUpperCase() + tmp.substring(1);
            RacesNames.add(tmp);
        }
        String[] RacesNamesArray = new String[RacesNames.size()];
        RacesNames.toArray(RacesNamesArray);
        return RacesNamesArray;

    }

    public void setRace(int position) {
        /*
        *  этот метод задает специализацию в переменную mRace
        *  на вход подается число, и из enum Race выбирается соответствующая раса
        *  0 - Human
        *  1 - Elf
        *  2 - Orc
        *  3 - Dwarf
        *  если введенное число меньше 0, то в mRace записывается самое первое (порядковый номер - 0) значение
        *  если введенное число больше длины enum, то в mRace записывается самое последнее (длина - 1) значение
        *
        * */
        for (Race i : Race.values()) {
            if (position == i.ordinal()) {
                mRace = i;
                return;
            }
        }
        if (position > Race.DWARF.ordinal()) {
            mRace = Race.DWARF;
            return;
        }
        if (position < Race.HUMAN.ordinal()) {
            mRace = Race.HUMAN;
        }
    }

    public String[] getAttributes() {
        /*
        *   этот метод должен возвращать массив строк, созданных на основе enum Attribute
        *    Строка должна быть формата - первая буква заглавная, остальные строчные
        *   One, Two, Three
        * */
        List<String> AttributeNames = new ArrayList<>();
        for (Attribute i : Attribute.values()) {
            String tmp = i.name().toLowerCase();
            tmp = tmp.substring(0, 1).toUpperCase() + tmp.substring(1);
            AttributeNames.add(tmp);
        }
        String[] AttributeNamesArray = new String[AttributeNames.size()];
        AttributeNames.toArray(AttributeNamesArray);
        return AttributeNamesArray;

    }

    public String[] getPerks() {
        /*
        *   этот метод должен возвращать массив строк, созданных на основе enum Perk
        *   Строка должна быть формата - первая буква заглавная, остальные строчные
        *   One, Two, Three
        *
        * */
        List<String> PerkNames = new ArrayList<>();
        for (Perk i : Perk.values()) {
            String tmp = i.name().toLowerCase();
            tmp = tmp.substring(0, 1).toUpperCase() + tmp.substring(1);
            PerkNames.add(tmp);
        }
        String[] PerkNamesArray = new String[PerkNames.size()];
        PerkNames.toArray(PerkNamesArray);
        return PerkNamesArray;

    }
    public void updateAttributeValue(int position, int updateTo) {
        /*
        *  этот метод увеличивает/уменьшает соответствующее значение атрибута
        *  рекомендуется реализовывать его в последнюю очередь
        *
        * 1. на вход подается позиция изменяемого атрибута и на сколько нужно этот атрибут увеличить/уменьшить
        * 2. по позиции атрибута выявляется название атрибута из enum Attribute
        * 3. по названию атрибута получается значение атрибута из mAttributesMap
        * 4. если атрибут собирается увеличиться и у персонажа достаточно очков для увеличения атрибута (mAvailablePoints)
        *    или
        *    если атрибут собирается уменьшиться и уменьшенный атрибут будет больше 0,
        *    то атрибут изменяется, количество доступных очков меняется в противоположную сторону.
        *
        * 5. убедитесь в том, что измененное значение атрибута записано в mAttributesMap
        * 6. убедитесь в том, что измененное значение количества очков записано в mAvailablePoints;
        * 7. после изменения нужно вызвать методы setChanged(); notifyObservers();
        *    для того, чтобы изменения отразились на верстке
        *
        * пример работы алгоритма.
        * на вход подается (0, -1)
        * из значения 0 выясняем, что меняться будет атрибут STRENGTH
        * получаем текущее значение этого атрибута из mAttributesMap
        * допустим, оно равно 3
        * по условию все алгоритма все проходит
        * сила уменьшается до 2, количество доступных очков увеличивается на +1
        *
        * если STRENGTH равно 1, то ничего не происходит,
        * так как мы не можем уменьшить атрибут ниже 1
        *
        * если на вход пришло (0, 1)
        *   если доступных очков больше 0,
        *       то STRENGTH увеличивается на 1, количество доступных очков уменьшается на 1
        *   если количество доступных очков равно 0
        *       то мы не можем увеличить атрибут, ничего не происходит        *
        * */
        Attribute selectedAttribute = Attribute.AGILITY;
        for (Attribute i : Attribute.values()) {
            if (position == i.ordinal()) {
                selectedAttribute = i;
                break;
            }
        } // нашли атрибут


        int curPointsOnAttribute = getAttributesMap().get(selectedAttribute.name());
        if ((curPointsOnAttribute + updateTo <= 10 && curPointsOnAttribute + updateTo >= 0) && mAvailablePoints >= updateTo) {
            mAvailablePoints -= updateTo;
            mAttributesMap.put(selectedAttribute.name(), curPointsOnAttribute + updateTo);
        }
        setChanged();
        notifyObservers();
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAvailablePoints() {
        return String.valueOf(mAvailablePoints);
    }

    public Map<String, Integer> getAttributesMap() {
        return mAttributesMap;
    }

    public void checkPerk(String text, boolean isChecked) {
        mPerksMap.put(text, isChecked);
    }

    public Character create() {
        Character character = new Character();
        character.setName(mName);
        character.setRace(mRace);
        character.setSpecialization(mSpecialization);
        character.setAttributes(mAttributesMap);
        character.setPerks(mPerksMap);
        character.calculateParameters();
        return character;
    }

    public Specialization getSpecialization() {
        return mSpecialization;
    }

    public Race getRace() {
        return mRace;
    }

    public Map<String, Boolean> getPerksMap() {
        return mPerksMap;
    }

    public void setAvailablePoints(int availablePoints) {
        mAvailablePoints = availablePoints;
    }

    public int getRacePosition() {
        return mRace.ordinal();
    }

    public int getSpecializationPosition() {
        return mSpecialization.ordinal();
    }
}
