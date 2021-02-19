package com.company.players;

public class Golem extends Hero {

    public Golem(int health, int damage) {
        super(health, damage,SuperAbility.SAVE_DAMAGE_AND_REVERT);

    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int temp = boss.getDamage() / 5;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && boss.getDamage() > 0) {
                if (this.getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() + temp);
                }
            }
        }
    }
}

