package com.company.players;

public class Medic extends Hero{

    public Medic(int health, int damage) {
        super(health, damage, SuperAbility.HEAL);

    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}
