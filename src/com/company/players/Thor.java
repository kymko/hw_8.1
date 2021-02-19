package com.company.players;

import java.util.Random;

public class Thor extends Hero{

    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUN);

    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int r = random.nextInt(3);
        if (this.getHealth() > 0 && r == 1 && boss.getHealth() > 0){
            boss.setDamage(0);
            System.out.println(heroes[5].getClass().getSimpleName() + " |Thor stunned Boss for 1 round!|");
        }else boss.setDamage(50);

    }
}
