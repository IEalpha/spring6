package com.icbc.sd;

import com.icbc.sd.bean.Animal;
import com.icbc.sd.factory.AnimalFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // to see how IntelliJ IDEA suggests fixing it.
        AnimalFactory.createAnimal("cat").scream();
        AnimalFactory.createAnimal("dog").scream();
        Animal cow = AnimalFactory.createAnimal("cow");
        cow.scream();
        cow.run();
        AnimalFactory.createAnimal("tiger").scream();
    }
}