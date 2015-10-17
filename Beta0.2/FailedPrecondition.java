/**
 * This error is thrown by the Assert class in the event of a failed
 * precondition. Errors are thrown rather than exceptions because
 * failed preconditions are assumed to be an indication of such
 * an egregious program failure that recovery is impossible.
 */
class FailedPrecondition extends FailedAssertion
{
    final static long serialVersionUID = 0L;
    /**
     * Constructs an error indicating failure to meet a precondition.
     * @post Constructs a new failed precondition
     * @param reason String describing precondition.
     */
    public FailedPrecondition(String reason)
    {
        super("\nA precondition: " + reason);
    }
}

