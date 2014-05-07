/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 *  
 *  Esta clase es la clase principal de la aplicación "World of Zuul". "World of Zuul" es un texto basado
 *  en juego de aventura muy simple. Usuarios puede caminar por un paisaje. Eso es todo. Realmente 
 *  debería ampliarse para que sea más interesante!   
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  Para jugar a este juego, cree una instancia de esta clase y llamar a la "obra" Método. 
 *  
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 *  
 *  Esta clase principal crea y se inicializa todos los demás: crea todo Habitaciones, crea el 
 *  analizador y comienza el juego. También evalúa y Ejecuta los comandos que devuelve el analizador.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     * Crear el juego e inicializar su mapa interno.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     * Crea todas las habitaciones y vincular sus salidas juntos.
     */
    private void createRooms()
    {
        Room campo, madrigueraUno, madrigueraDos, madrigueraTres, despensa;
      
        // create the rooms
        campo = new Room("En el campo");
        madrigueraUno = new Room("En la madriguera uno");
        madrigueraDos = new Room("En la madriguera dos");
        madrigueraTres = new Room("En la madriguera tres");
        despensa = new Room("En la despensa");
        
        // initialise room exits
        campo.setExit("north", madrigueraUno);
        campo.setExit("south", madrigueraDos);
        campo.setExit("sureste", madrigueraTres);
        
        madrigueraUno.setExit("south", campo);
        
        madrigueraDos.setExit("north", campo);
        madrigueraDos.setExit("east", despensa);
        
        madrigueraTres.setExit("north", campo);
        
        despensa.setExit("west", madrigueraUno);
        
        campo.addItem(new Item("encuentra una mochila", 100f));
        madrigueraUno.addItem(new Item("hay una naranja", 25f));
        madrigueraDos.addItem(new Item("hay un cacahuete", 2f));
        madrigueraTres.addItem(new Item("hay una manzana", 18f));
        despensa.addItem(new Item("hay una aguja", 0.5F));
        currentRoom = campo;  // start game campo
    }

    /**
     *  Main play routine.  Loops until end of play.
     *  Rutina de reproducción principal. Los bucles hasta el final del juego.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     * Imprima el mensaje de apertura para el jugador.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }
    
    private void printLocationInfo(){
        System.out.println( currentRoom.getLongDescription()); 
        System.out.println();
        }
    
    /**
     * Given a command, process (that is: execute) the command.
     * Dado un comando, el proceso (es decir: lo ejecuta) el comando.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look")) {
            printLocationInfo();
        }
        else if (commandWord.equals("eat")){
            System.out.println("You have eaten now and you are not hungry any more");
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     * Aquí imprimimos algunos, críptico mensaje estúpido y una lista de la palabras de comando.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        //parser.comandos().showAll();
        parser.printComandosDisponibles();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     * Trate de ir en una dirección. Si hay una salida, introduzca 
     * la nueva sala, de lo contrario se imprime un mensaje de error.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;            
            printLocationInfo();
        }
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * "Quit(Salir)" se ingresó. Compruebe el resto de la orden para ver si realmente sale del juego.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}

