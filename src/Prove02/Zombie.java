package Prove02;


import java.awt.Color;

/**
 * Create a new Zombie class
 * Zombie moves from left to right
 * Zombie attack any creature, as long it isn't an instance of the Plant
 * They inflict 10 points of damage when they attack
 * They should be represented as blue squares.
 */

public class Zombie extends Creature implements Movable, Aggressor {

    public Zombie(){
       _health = 1;

    }
    // Zombies don't eat plants, but eats any other creatures.
    public Shape attack(Creature target) {
        if(target != null && !(target instanceof Plant)) {
            target.takeDamage(10);
        }

        return null;
    }

    public Color getColor() {
        return new Color(165);
    }

    Boolean isAlive() {
        return _health > 0;
    }

    public Shape getShape() {
        return Shape.Square;
    }

    // Move the zombie from left to right
    public void move() {
        _location.x++;

    }
}
