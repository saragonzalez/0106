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
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room suresteExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Define the exits of this room.  Everydireccion either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     * @param sureste la salida sureste
     */
    public void setExits(Room north, Room east, Room south, Room west, Room sureste) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        if(sureste !=null)
            suresteExit = sureste;
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
            nextRoom = northExit;
        }
        if(direccion.equals("east")) {
            nextRoom = eastExit;
        }
        if(direccion.equals("south")) {
            nextRoom = southExit;
        }
        if(direccion.equals("west")) {
            nextRoom = westExit;
        }
        if(direccion.equals("sureste")) {
            nextRoom = suresteExit;
        }
        return nextRoom;
    }
    

}
