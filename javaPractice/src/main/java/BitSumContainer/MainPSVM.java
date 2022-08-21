package BitSumContainer;

import java.util.logging.Logger;

public class MainPSVM {

    public static void main(String[] args) {

        var logger = Logger.getLogger("abcd");
        logger.info("Beginning...");

        var techEmployee = new BitSumAccessUsingInteger();
        techEmployee.addAccess(Access.ENTRANCE);
        techEmployee.addAccess(Access.TECH);
        techEmployee.addAccess(Access.CAFE);
        techEmployee.addAccess(Access.GYM);
        logger.info("TecEmployee's sum = "+ techEmployee.getBitSumValue());
        logger.info("TechEmployee's access = "+ techEmployee.getAllAccess());

        /* Prints:
            Beginning...
            values added
            TechEmployee's sum = 83
            TechEmployee's access = [TECH, CAFE, GYM, ENTRANCE]
        */

        var salesEmployee = new BitSumGenericsUsingInteger<>(Access.class);
        salesEmployee.addEnumVal(Access.ENTRANCE);
        salesEmployee.addEnumVal(Access.SALES);
        salesEmployee.addEnumVal(Access.CAFE);
        logger.info("SalesEmployee's sum = "+ salesEmployee.getBitSumValue());
        logger.info("SalesEmployee's access = "+ salesEmployee.getAllEnumValues());

        // drank too much of free bellyMarche coffee
        salesEmployee.revokeAccess(Access.CAFE);
        logger.info("SalesEmployee's new sum = "+ salesEmployee.getBitSumValue());
        logger.info("SalesEmployee's new access = "+ salesEmployee.getAllEnumValues());
        logger.info("...terminating");

        /* Prints:
            values added to enum registry
            SalesEmployee's sum = 25
            SalesEmployee's access = [CAFE, ENTRANCE, SALES]
            SalesEmployee's new sum = 9
            SalesEmployee's new access = [ENTRANCE, SALES]
            ...terminating
        */
    }
}
