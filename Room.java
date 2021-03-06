import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
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
    private ArrayList <Item> items;
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
        return "Tu estas " + description; 
    }

    public Room getExit (String direccion)
    {
        return exits.get(direccion); // Si no hay una entrada devolvera null
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString()
    {
        Set <String> nameOfDirection = exits.keySet();
        String exitDescription ="Las salidas son: ";
        for(String direction: nameOfDirection){
            exitDescription += direction + " ";
        }
        return exitDescription;
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room' --> getDescription
     *     Exits: north west southwest -->getExitString
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        String longDescription = "You are " + getDescription() + "\n" +getExitString() + "\n";
        longDescription = "There are " + items.size() + " items \n";
        for (Item item: items)
        {
            longDescription = " "+ item.getLongDescription() + "\n";
        }
        return longDescription;
    }

    public void addItem(Item item)
    {
        items.add(item);
    }
    
    
    
    
    
    
    
    
    
    
    
}

