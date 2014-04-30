import java.util.HashMap;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For eachdireccion, the room stores a reference
 * to the neighboring room, or null if there is no exit in thatdireccion.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    public String description;    
    private HashMap<String, Room> exits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

     
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExit (String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public Room getExit (String direccion)
    {
        Room nextRoom = null;
        if(direccion.equals("north")) {
            nextRoom = exits.get("north");
        }
        if(direccion.equals("east")) {
            nextRoom = exits.get("east");
        }
        if(direccion.equals("south")) {
            nextRoom = exits.get("south");
        }
        if(direccion.equals("west")) {
            nextRoom = exits.get("west");
        }
        if(direccion.equals("sureste")) {
            nextRoom = exits.get("sureste");
        }
        if(direccion.equals("noroeste")) {
            nextRoom = exits.get("noroeste");
        }
        return nextRoom;
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString()
    {
        String salidas = "Exits: ";
        if (getExit("north")!=null) {
            salidas = "north "; 
        }
        if (getExit("east")!=null) {
            salidas += "east "; 
        }
        if (getExit("south")!=null) {
            salidas += "south "; 
        }
        if (getExit("west")!=null) {
            salidas += "west "; 
        }
        if (getExit("sureste")!=null) {
            salidas += "sureste "; 
        }
        if (getExit("noroeste")!=null) {
            salidas += "noroeste "; 
        }
        return salidas;
    }

}
