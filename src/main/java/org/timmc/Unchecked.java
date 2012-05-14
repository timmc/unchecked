package org.timmc;

/**
 * Throw and catch unchecked exceptions as if they were unchecked.
 * 
 * @author James Iry http://james-iry.blogspot.com/2010/08/on-removing-java-checked-exceptions-by.html
 */
public class Unchecked {
    private static <T extends Throwable, A> A pervertException(Throwable x)
      throws T {
        throw (T) x;
    }

    /**
     * Throw any exception as if it were unchecked.
     * Usage: <code>return Unchecked.chuck(new IOException("oops"));</code>
     * @param t an exception instance to throw sneakily
     * @return N/A, never returns normally
     */
    public static <A> A chuck(Throwable t) {
        return Unchecked.<RuntimeException, A>pervertException(t);
    }

    /**
     * Call in first line of a try/catch block to allow catching of the given
     * unchecked exception.
     * Usage:
     * <pre>try { Unchecked.chucks(IOException.class); ... }
     * catch(IOException ioe) { ... }</pre>
     * @param exc Class of exception that may be sneakily thrown in try block
     */
    public static <T extends Throwable> void chucks(Class<T> exc) throws T {}
}
