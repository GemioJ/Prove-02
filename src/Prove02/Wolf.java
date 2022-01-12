package Prove02;

import java.awt.*;
import java.util.Random;

/**
 * The wolf class should attack any Animal, but not plant or zombie
 * They inflict 5 points of damage when they attack
 * They first move random. When checking for nearby animals
 * they should search in a clockwise patter starting at the top.
 */

public class Wolf extends Creature implements Movable, Aware, Aggressor, Spawner {

    private int _direction;
    private boolean _canSpawn;

    public Wolf() {
        _direction = new Random().nextInt(4);
        _health = 1;
        _canSpawn = false;

    }

    public Creature spawnNewCreature() {
        if (_canSpawn) {
            Wolf w = new Wolf();
            int thisX = this._location.x;
            int thisY = this._location.y;
            w.setLocation(new Point(--thisX, thisY));
            _canSpawn = false;
            return w;
        }
        return null;

    }


    public void move() {
        switch (_direction) {
            case 1:
                _location.x++;
                break;
            case 2:
                _location.x--;
                break;
            case 3:
                _location.y++;
                break;
            case 4:
                _location.y--;
                break;
            default:
                break;
        }

    }

    public Shape attack(Creature target) {
        if(target instanceof Animal) {
            target.takeDamage(5);
            if (!target.isAlive()) {
                _canSpawn = true;
            }
            _health++;
        }

        return null;
    }


    public Color getColor() {
        return Color.GRAY;
    }

    public Shape getShape() {
        return Shape.Square;
    }


    Boolean isAlive() {
        return _health > 0;
    }

    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
        // Wolves avoid wolfHunters
        if (above instanceof wolfHunter){
            _direction = 2;
        }
        if (below instanceof wolfHunter){
            _direction = 3;
        }
        if (left instanceof wolfHunter){
            _direction = 0;
        }
        if (right instanceof wolfHunter){
            _direction = 1;
        }

        switch (_direction){
            case 1:
                //moving right, check right
                if (right instanceof Animal) {

                }
                // check down
                else if (below instanceof Animal) {
                    _direction = 2;
                }
                // check left
                else if (left instanceof Animal) {
                    _direction = 1;
                }
                //check up
                else if (above instanceof Animal) {
                    _direction = 3;
                    break;
                }
            case 2:
                // moving down
                // check down
                if (below instanceof Animal) {

                }
                // check left
                else if (left instanceof Animal) {
                    _direction = 1;
                }
                    // check up
                else if (above instanceof Animal) {
                    _direction = 3;
                }
                    // check right
                else if (right instanceof Animal) {
                    _direction = 0;
                }
                break;

            case 3: // moving up
                // check up
                if (above instanceof Animal) {

                }
                // check right
                else if (right instanceof Animal) {
                    _direction = 0;
                }
                    // check down
                else if (below instanceof Animal) {
                    _direction = 2;
                }
                    // check left
                else if (left instanceof Animal) {
                    _direction = 1;
                }
                break;
            default:
                break;
        }
    }

}

