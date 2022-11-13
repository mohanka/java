package OOP;

public class AnimalTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        Dog d = new Dog("dogName");
        Animal ad = new Dog("polyDog");

        a.sound();
        d.sound();
        ad.sound();

        if(a instanceof Dog) {
            System.out.println("yes a instance of Dog");
        }
        if(a instanceof Animal) {
            System.out.println("yes a instance of Animal");
        }

        if(a.equals(d)) {
            System.out.println("a equals d");
        } else {
            System.out.println("not equal");
        }

        if(d.equals(a)) {
            System.out.println("d equals a");
        } else {
            System.out.println("not equal");
        }


//         Output:
//        makes sound
//        makes dog sound
//        makes dog sound
//        yes a instance of Animal
//        a equals d
//        not equal   => contract of equivalence is breached. Effect of overriding equals method

    }
}
