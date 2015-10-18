// Routines used for testing assertions.
// (c) 2001 duane a. bailey

/**
 * A library of assertion testing and debugging procedures.
 * <p>
 * This class of static methods provides basic assertion testing facilities.
 * An assertion is a condition that is expected to be true at a certain
 * point in the code.  Each of the assertion-based routines in this class
 * perform a verification of the condition, and do nothing (aside from
 * testing side-effects) if the condition holds.  If the condition fails,
 * however, the assertion throws an exception and prints the associated
 * message, that describes the condition that failed.  Basic support is 
 * provided for testing general conditions, and pre- and postconditions.
 * There is also a facility for throwing a failed condition for code that
 * should not be executed.
 * <p>
 * Features similar to assertion testing are expected to be incorporated
 * into the Java 2 language beginning in SDK 1.4.
 * <p>
 * The debugging facilities provide control that is slightly improved
 * over print statements.
 *
 * @author, 2001 duane a. bailey
 * @version $Id: Assert.java 22 2006-08-21 19:27:26Z bailey $
 * @since Java Structures, 1st edition
 */
public class Assert
{
    /**
     * The current level of debugging; generally 0 upward.
     * A level of 0 is generally considered off.
     */
    protected static int debugLevel = 0;
    /**
     * @pre An Assert cannot be constructed
     */
   

    /**
     * Increase the verbosity of the debugging messages.
     *
     * @post debugging level is increased
     */
    public static void debugging()
    {
        debugLevel++;
    }

    /**
     * Explictly set the debugging level (0 = none)
     *
     * @param level the desired level of verosity
     * @pre level >= 0
     * @post the level of debugging is set to <code>level</code>
     * @return the old level
     */
    public static int debugLevel(int level)
    {
        int oldLevel = debugLevel;
        debugLevel = level;
        return oldLevel;
    }

    /**
     * Set up a level 1 debugging message.
     *
     * @param message a string to be printed if debugging level is 1 or more
     * @post prints message if the debugging level is 1 or more
     */
    public static void debug(String message)
    {
        debug(1,message);
    }

    /**
     * Set up a debugging message at a specific level.
     *
     * @param level the level that triggers the printing of message
     * @param message the message to be printed at the desired level
     * @pre level >= 1 and message is non-null
     * @post prints message if debugging level is <code>level</code> or more
     */
    public static void debug(int level,String message)
    {
        if (level <= debugLevel) System.err.println(message);
    }

    /**
     * Test a precondition.  If the assertion fails the message
     * indicates that a precondition failed.  A precondition is something
     * you require to be true for the method to be executed correctly.
     *
     * @param test A boolean expression describing precondition.
     * @param message A string describing precondition.
     * @pre Result of precondition test
     * @post Does nothing if test true, otherwise abort w/message
     */
    static public void pre(boolean test, String message)
    {
        if (test == false) throw new FailedPrecondition(message);
    }
    
    static public void post(boolean test, String message)
    {
        if (test == false) {
            throw new FailedPostcondition(message);
        }
    }
}

