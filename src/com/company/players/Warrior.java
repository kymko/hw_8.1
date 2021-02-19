package com.company.players;

import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);

    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random r = new Random();
        int random = 1 + r.nextInt(2);
        if (this.getHealth() > 0) {
            int temp = heroes[0].getDamage() * random;
            if (boss.getHealth() - this.getDamage() <= 0)
                boss.setHealth(0);
            boss.setHealth(boss.getHealth() + this.getDamage() - temp);
            System.out.println(heroes[0].getClass().getSimpleName() + " |умножил на " + temp + " урона|");
        }

    }
}
