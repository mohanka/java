package OOP;

public class Dog extends Animal {

    String name;

    public Dog(String name) {
        super();
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if( o == null || !(o instanceof Dog)) {
            return false;
        } else {
            Dog oAni = (Dog) o;
//            return super.equals(oAni);
            return oAni.name.equals(this.name);
        }
    }

    public void sound() {
        System.out.println("makes dog sound");
    }
}
