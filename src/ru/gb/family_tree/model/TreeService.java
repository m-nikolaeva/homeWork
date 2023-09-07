package ru.gb.family_tree.model;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.filehandler.Writable;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

public class TreeService {
    private Writable writable;
    private FamilyTree<Human> activeTree;

    public TreeService(){
        activeTree = new FamilyTree<>();
    }

    public TreeService(FamilyTree<Human> activeTree) {
        this.activeTree = activeTree;
    }

    public void addHuman(int id, String name, String birthDate, Gender gender, String father, String mother) {
        Human human = new Human(id, name, birthDate, gender, father, mother);
        activeTree.add(human);
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void sortByName(){
        activeTree.sortByName();
    }

    public void sortByAge(){
        activeTree.sortByAge();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }

    public void write(){
        if (writable == null){
            return;
        }
        writable.write(activeTree);
    }

    public void read(){
        if (writable == null){
            return;
        }
        activeTree = writable.read();
    }

}
