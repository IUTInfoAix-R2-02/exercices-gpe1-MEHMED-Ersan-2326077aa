package fr.amu.iut.exercice13;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.io.PrintStream;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static ListChangeListener<Personne> unChangementListener;
    private static ListChangeListener<Personne> plusieursChangementListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList(personne -> new Observable[] {
                personne.ageProperty()
        });

        PrintStream cout = System.out;

        /**unChangementListener = (ListChangeListener.Change<? extends Personne> changement) -> {
            while (changement.next()) {
                if (changement.wasAdded()) {
                    cout.println("Personne ajouté : " +
                            changement.getAddedSubList().get(0).getNom() + " - " +
                            changement.getAddedSubList().get(0).getAge());
                } else if ( changement.wasRemoved()) {
                    cout.println(
                            "Personne retiré : " +
                            changement.getRemoved().get(0).getNom() + " - " +
                            changement.getRemoved().get(0).getAge()
                    );
                } else if (changement.wasUpdated()) {
                    for (int i = changement.getFrom(); i < changement.getTo(); ++i) {
                        cout.println(
                                changement.getList().get(i).getNom() + " a maintenant : " +
                                changement.getList().get(i).getAge() + " ans"
                        );
                    }

                }
            }
        };**/

        plusieursChangementListener = (ListChangeListener.Change<? extends Personne> changement) -> {
            while (changement.next()) {
                if (changement.wasAdded()) {
                    for (Personne ajoutee : changement.getAddedSubList()) {
                        cout.println("Personne ajouté : " +
                                ajoutee.getNom() + " - " +
                                ajoutee.getAge());
                    }
                } else if (changement.wasRemoved()) {
                    for (Personne enleve : changement.getRemoved()) {
                        cout.println(
                                "Personne retiré : " +
                                        enleve.getNom() + " - " +
                                        enleve.getAge()
                        );
                    }
                } else if (changement.wasUpdated()) {
                    for (int i = changement.getFrom(); i < changement.getTo(); ++i) {
                        cout.println(
                                changement.getList().get(i).getNom() + " a maintenant : " +
                                        changement.getList().get(i).getAge() + " ans"
                        );
                    }
                }
            }
        };

        lesPersonnes.addListener(plusieursChangementListener);

        question5();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}

