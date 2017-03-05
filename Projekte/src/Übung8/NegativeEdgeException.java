package Übung8;

/**
 * this class menaged inhernde from Exception and handle NegativeEdgeException
 * if thrown
 *
 * @author Stephan Duenkel, Emil Steinkopf, Loen Roesler
 */
public class NegativeEdgeException extends Exception {

    /**
     * Creates a new instance of <code>NegativeEdgeException</code> without
     * detail message.
     */
    public NegativeEdgeException() {
        super(" NegativeEdgeException is thrown! One of the edges has an negativ value!! this file is invalid !!");
    }

    /**
     * Constructs an instance of <code>NegativeEdgeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NegativeEdgeException(String msg) {
        super(msg);

    }

//    public String exceptionMessage(){
//        
//    }
}
