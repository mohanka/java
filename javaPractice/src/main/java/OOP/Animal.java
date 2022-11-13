package OOP;

public class Animal {

    boolean alive;

    public Animal() {
        alive = true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if( o == null || !(o instanceof Animal)) {
            return false;
        } else {
            Animal oAni = (Animal) o;
            return oAni.alive == alive;
        }
    }

    public void sound() {
        System.out.println("makes sound");
    }
}
