package com.company.players;

import java.util.Random;

public class Magic extends Hero{

    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);

    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random r = new Random();
        int heal = 2+r.nextInt(10);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                if (this.getHealth() > 0) {
                    boss.setHealth(boss.getHealth() - heal);
                    if (boss.getHealth() - heroes[i].getDamage() <= 0)
                        boss.setHealth(0);
                }
            }
        }
        if(this.getHealth()>0){
            System.out.println(heroes[1].getClass().getSimpleName() + " |Added  "+heal+" damage for heroes|");
        }

    }
}
