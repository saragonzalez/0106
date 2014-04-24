/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * Esta clase es parte de la aplicación "World of Zuul". "World of Zuul" es un texto basado 
 * en juego de aventura muy simple. 
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * Esta clase contiene información acerca de un comando que fue emitida por el usuario. Un comando se 
 * compone actualmente de dos cadenas: una palabra de comando y un segundo Palabra (por ejemplo, si el 
 * comando se toman "mapa", luego las dos cadenas obviamente son "tener" y "mapa"). 

 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 * 
 *  La forma en que se utiliza es la siguiente: Los comandos ya se comprueban por ser válido palabras 
 *  de comando. Si el usuario introduce un comando no válido (una palabra que no es Conocido), 
 *  entonces la palabra de orden es <null>. 
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * Si el comando tenía una sola palabra, y luego la segunda palabra se <NULL>.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * Crear un objeto de comando. Primera y segunda palabra debe ser suministrado, pero uno (o ambos) 
     * pueden ser nulos. 
     * @param firstWord The first word of the command. Null if the command
     *                  was not recognised.
     * 
     * @ Param FirstWord La primera palabra del comando. Null si el comando No fue reconocido.
     * 
     * @param secondWord The second word of the command.
     * @ Param secondWord La segunda palabra del comando.
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * @return The command word.
     * 
     * Devolver la palabra de comando (la primera palabra) de este comando. Si el comando no se entendía,
     * el resultado es nulo. @ Return La palabra de orden.
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

