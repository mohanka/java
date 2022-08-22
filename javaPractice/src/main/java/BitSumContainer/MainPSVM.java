package BitSumContainer;

import java.util.logging.Logger;

public class MainPSVM {

    public static void main(String[] args) {

        var logger = Logger.getLogger("abcd");
        logger.info("Beginning...");

        // Regular class using Integer - caps to 32 Access Roles
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

        // Generic class using Integer - caps to 32 Access Roles
        var salesEmployee = new BitSumGenericsUsingInteger<>(Access.class);
        salesEmployee.addEnumVal(Access.ENTRANCE);
        salesEmployee.addEnumVal(Access.SALES);
        salesEmployee.addEnumVal(Access.CAFE);
        logger.info("SalesEmployee's sum = "+ salesEmployee.getBitSumValue());
        logger.info("SalesEmployee's access = "+ salesEmployee.getAllEnumValues());

        // drank too much of free coffee
        salesEmployee.revokeAccess(Access.CAFE);
        logger.info("SalesEmployee's new sum = "+ salesEmployee.getBitSumValue());
        logger.info("SalesEmployee's new access = "+ salesEmployee.getAllEnumValues());

        /* Prints:
            values added to enum registry
            SalesEmployee's sum = 25
            SalesEmployee's access = [CAFE, ENTRANCE, SALES]
            SalesEmployee's new sum = 9
            SalesEmployee's new access = [ENTRANCE, SALES]

        */

        // Generic class using BitSet - no cap. Vector of dynamically growing bits
        var bellyMarchChef = new BitSumGenericsUsingBitSet<>(Access.class);
        bellyMarchChef.addEnumVal(Access.ENTRANCE);
        bellyMarchChef.addEnumVal(Access.CAFE);
        bellyMarchChef.addEnumVal(Access.PANTRY);
        logger.info("BellyMarchChef's access= "+ bellyMarchChef.getAllEnumValues());
        /* Prints:
            INFO: BellyMarchChef's access= [ENTRANCE, PANTRY, CAFE]
        */

        //bellyMarch to be 24/7 open
        bellyMarchChef.removeEnumVal(Access.ENTRANCE);
        logger.info("BellyMarchChef's new access= "+ bellyMarchChef.getAllEnumValues());
        logger.info("...terminating");
        /* Prints:
            INFO: BellyMarchChef's new access= [PANTRY, CAFE]
            ...terminating
        */

    }
}
