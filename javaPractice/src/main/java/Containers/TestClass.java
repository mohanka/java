package Containers;

public class TestClass {

    public static void main(String[] args) {
        System.out.println("Beginning...");

        var techEmployee = new BitSumAccessUsingInteger();
        techEmployee.addAccess(Access.ENTRANCE);
        techEmployee.addAccess(Access.TECH);
        techEmployee.addAccess(Access.CAFE);
        techEmployee.addAccess(Access.GYM);
        System.out.println("TechEmployee's sum = "+ techEmployee.getBitSumValue());
        System.out.println("TechEmployee's access = "+ techEmployee.getAllAccess());

        var cafeEmployee = new BitSumAccessUsingInteger();
        cafeEmployee.addAccess(Access.ENTRANCE);
        cafeEmployee.addAccess(Access.CAFE);
        cafeEmployee.addAccess(Access.PANTRY);
        System.out.println("CafeWorker's sum = "+ cafeEmployee.getBitSumValue());
        System.out.println("CafeWorker's access = "+ cafeEmployee.getAllAccess());

        System.out.println("...terminating");

    }
}
