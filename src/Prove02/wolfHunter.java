package Prove02;

import java.awt.*;
import java.util.Random;

public class wolfHunter extends Creature implements Aggressor {

    private Random _rand;

    public wolfHunter() {
        _health = 5;
        _rand = new Random();
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    public Shape attack(Creature target) {
        if (target instanceof Zombie) {
            int gunShot = _rand.nextInt(10);
            if (gunShot == 7 || gunShot == 2) {
                target.takeDamage(target._health);
            }
        }
        else if (target != null && !(target instanceof Plant)) {
            target.takeDamage(target._health);
        }
        return null;
    }

    public Shape getShape() {
        return Shape.Circle;
    }

    public Color getColor() {
        return new Color(0x3E0000);
    }


}
