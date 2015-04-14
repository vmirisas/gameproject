/**
 *
 */
package gr.teicm.game;


import java.util.ArrayList;

public class GamingWorld {

    private Parser parser;
    private Room currentRoom;
    private  ArrayList<Item> itemList = new ArrayList<Item>();



    /**
     *
     */
    public GamingWorld()
    {
        createRooms();
        parser = new Parser();
        createItems();
    }

        /**
         * creating rooms
         */
        Room yard, livingRoom, kitchen, bedroom, office, garage, bathroom;
        private void createRooms()
        {

            /**
             * creating rooms
             */
            yard = new Room("you are at the house yard.It's beautiful out here although the weather is freezing cold !");
            livingRoom = new Room("you are in the living room. As you enter the house you feel the cozy warmth of the fireplace. ");
            kitchen = new Room("the smell of fresh food indicates with closed eyes that this room is the kitchen.");
            bedroom = new Room("this is where le sexy time happens......or where you can just sleep.");
            office = new Room("there is a huge desk as you enter the office. An Apple computer is on it.Also there is a big library with a plethora o books");
            bathroom = new Room("this bathroom is full of steam.You also distinguish rem stains on the mirror.");
            garage = new Room("the garage seems pretty tidy.I wonder where the car could possibly be...");

            /**set room exits
             *
             */
            yard.setExits(livingRoom, garage, null, null);
            livingRoom.setExits(bedroom, kitchen, yard, office);
            kitchen.setExits(null, null, garage, livingRoom);
            bedroom.setExits(null, null, livingRoom, bathroom);
            office.setExits(bathroom, livingRoom, null, null);
            bathroom.setExits(null, bedroom, office, null);
            garage.setExits(kitchen, null, null, yard);



            currentRoom = yard;  // starting  point

        }
        private void createItems(){

            Item note = new Item("note", "this is Alex Mercer, i wrote this message for myself in case The incident happens. Whatever happens don't let the others get in your mind !", ItemType.Notes, true, livingRoom );
            livingRoom.addItem(note); //the room in which the item is located.
            Item table = new Item("table","a very well made table carved from ebony wood", ItemType.Misc, false, livingRoom);
            livingRoom.addItem(table);
        }



        /**
         * Our main loop that begins the program
         */
        public void play()
        {
            printWelcome();

            boolean finished = false;
            while (! finished)
            {
                Command command = parser.getCommand();
                finished = processCommand(command);
            }
            System.out.println("Thank you for playing.  Good bye.");
        }


        private void printWelcome()
        {
            System.out.println();
            System.out.println("Welcome");
            System.out.println("\n");
            System.out.println("Type 'help' if you need help.");
            System.out.println();
            System.out.println(currentRoom.longDescription());
        }


        private boolean processCommand(Command command)
        {
            if(command.isUnknown())
            {
                System.out.println("I don't know what you mean...");
                return false;
            }

            String commandWord = command.getCommandWord();


            if (commandWord.equalsIgnoreCase("help"))
                printHelp();
            else if (commandWord.equalsIgnoreCase("go"))
                goRoom(command);
            else if (commandWord.equalsIgnoreCase("quit"))
            {
                if(command.hasSecondWord())

                    System.out.println("Quit what?");
                else
                    return true;  // signal that we want to quit
            }
            return false;
        }

        // implementations of user commands:

        /**
         *
         */
        private void printHelp()
        {
            System.out.println("I think you asked for my help..");
            System.out.println("well...");
            System.out.println();
            System.out.println("Your available command words are:");
            parser.showCommands();
        }

//        private void getRoomItemList(Room currentRoom){
//            itemList = currentRoom.getItemList(itemList);
//
//        }




        /**
         *
         */
        private void goRoom(Command command)
        {
            if(!command.hasSecondWord())
            {
                // if we have problems with the second word or there isn't any word at all
                System.out.println("Go where?");
                return;
            }

            String direction = command.getSecondWord();

            // Try to leave current room.
            Room nextRoom = currentRoom.nextRoom(direction);


            if (nextRoom == null)
                System.out.println("There is no room!");
            else
            {
                currentRoom = nextRoom;
                System.out.println(currentRoom.longDescription() );
            }
        }

}


