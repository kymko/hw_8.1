package com.company.game;

import com.company.players.*;

public class RPG_Game {

    public static int roundCounter = 0;

    public static int getRoundCounter() {
        return roundCounter;
    }

    public static void setRoundCounter(int roundCounter) {
        RPG_Game.roundCounter = roundCounter;
    }


    public static void start() {


        Boss boss = new Boss(900, 50);
        Warrior warrior = new Warrior(250, 20);
        Magic magic = new Magic(220, 20);
        Medic medic = new Medic(230, 25);
        Hunter hunter = new Hunter(260, 10);
        Golem golem = new Golem(250, 15);
        Thor thor = new Thor(240, 20);
        Tank tank = new Tank(300, 6);
        Witcher witcher = new Witcher(240, 0);

        Hero[] heroes = {warrior, magic, medic, hunter, golem, thor, tank, witcher};

        start1(boss, heroes);


        while (isGameFinished(boss, heroes) == false) {
            round(boss, heroes);
        }


    }


    private static void round(Boss boss, Hero[] heroes) {

        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        applySuperAbility(boss, heroes);
        heroesHits(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void applySuperAbility(Boss boss, Hero[] heroes) {


        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);

            }
        }

    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("HEROES WIN!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("BOS WIN!!!");
        }
        return allHeroesDead;
    }


    public static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("---------------------------------");
        roundCounter++;
        System.out.println("Result of round:" + roundCounter);

        System.out.println("=================================");
        System.out.println("Boss health:" + boss.getHealth());

        for (int i = 1; i < heroes.length; i++) {


            System.out.println(heroes[i].getClass().getSimpleName() + " health: " + heroes[i].getHealth());
        }
        System.out.println("---------------------------------");
        System.out.println(" Finish of round: " + roundCounter);


    }

    private static void start1(Boss boss, Hero[] heroes) {
        System.out.println("==============START==============");
        System.out.println("Boss health:" + boss.getHealth());

        for (int i = 0; i < heroes.length; i++) {

            System.out.println(heroes[i].getClass().getSimpleName() + " Health: " + heroes[i].getHealth());

        }

    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i].getHealth() - boss.getDamage() <= 0) heroes[i].setHealth(0);
                else heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }

        }
    }


    private static void heroesHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                if (boss.getHealth() - heroes[i].getDamage() <= 0)
                    boss.setHealth(0);
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }

    }

}
