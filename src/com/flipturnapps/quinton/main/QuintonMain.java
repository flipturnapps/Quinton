package com.flipturnapps.quinton.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.flipturnapps.kevinLibrary.command.BasicCommandParser;
import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.CommandParseException;
import com.flipturnapps.kevinLibrary.command.IncorrectDataException;
import com.flipturnapps.kevinLibrary.command.NonExistentCommandException;
import com.flipturnapps.quinton.command.CommandMoveDown;
import com.flipturnapps.quinton.command.CommandMoveEast;
import com.flipturnapps.quinton.command.CommandMoveNorth;
import com.flipturnapps.quinton.command.CommandMoveSouth;
import com.flipturnapps.quinton.command.CommandMoveUp;
import com.flipturnapps.quinton.command.CommandMoveWest;
import com.flipturnapps.quinton.command.GoCommand;
import com.flipturnapps.quinton.command.ItemUseCommand;
import com.flipturnapps.quinton.command.QorkHelpCommand;
import com.flipturnapps.quinton.room.RoomCommand;
import com.flipturnapps.quinton.worldgeneration.WorldGenerator;
import com.flipturnapps.quinton.xmldata.Room;
import com.flipturnapps.quinton.xmldata.World;

public class QuintonMain 
{

	private static final boolean SHOULD_READ_WORLD_FROM_FILE = false;
	public static void main(String[] args) 
	{
		new QuintonMain().go();
	}
	private BasicCommandParser parser;
	private void go() 
	{
		boolean generate = !this.SHOULD_READ_WORLD_FROM_FILE;
		if(!generate && !this.getWorldsaveFile().exists())
			generate = true;
		World world;
		WorldGenerator gen = new WorldGenerator();
		if(generate)
			world = gen.generateAndSaveTestWorld(this.getWorldsaveFile());
		else
			world = gen.readWorld(this.getWorldsaveFile());
		ArrayList<Command> commands = new ArrayList<Command>();
		commands.add(new CommandMoveDown());
		commands.add(new CommandMoveUp());
		commands.add(new CommandMoveNorth());
		commands.add(new CommandMoveSouth());
		commands.add(new CommandMoveWest());
		commands.add(new CommandMoveEast());
		commands.add(new QorkHelpCommand(world));
		commands.add(new GoCommand(this));
		ItemUseCommand itemUseCommand = new ItemUseCommand();
		commands.add(itemUseCommand);
		parser = new BasicCommandParser(commands);
		Scanner scanner = new Scanner(System.in);
		Room lastRoom = null;
		Room room = null;
		while(true)
		{
			room = world.getPlayersRoom();
			if(room == null)
			{
				world.println("You can't go that way.");				
				room = lastRoom;
				world.getPlayer().setLocation(lastRoom.getLocation().copy());
			}
			itemUseCommand.clearItemList();
			try
			{
				for(int i = 0; i < world.getPlayer().getInventory().getInflatedItems().size(); i++)
					itemUseCommand.registerItem(world.getPlayer().getInventory().getInflatedItems().get(i));
			}
			catch (Exception ex){}
			try{
				for(int i = 0; i < room.getItemContainer().getInflatedItems().size(); i++)
				{
					itemUseCommand.registerItem(room.getItemContainer().getInflatedItems().get(i));
				}
			}
			catch (Exception ex){}
			System.out.println();
			System.out.println(room.getName());
			if(room.getExploredByIdsList() == null)
				room.setExploredByIdsList(new ArrayList<Integer>());
			if(!(room.getExploredByIdsList().contains(world.getPlayer().getId())))
			{
				room.getExploredByIdsList().add(world.getPlayer().getId());
				System.out.println(room.getStartNarration());
				System.out.println(room.getDescription());
			}
			//System.out.println("-DEBUG-Playerlocation: " + world.getPlayer().getLocation() + "");
			//System.out.println("-DEBUG-Roomlocation: " + room.getLocation() + "");
			try
			{
				if(room.getItemContainer().getInflatedItems().size() > 0)
				{
					System.out.println("  You see beside you: ");
					for(int i = 0; i < room.getItemContainer().getInflatedItems().size(); i++)
						System.out.println("   " + room.getItemContainer().getInflatedItems().get(i).getName());
				}
			}
			catch(Exception ex)
			{}
			System.out.print(">");


			String input = scanner.nextLine();
			this.parseCommand(input, world, room);
			lastRoom = room;
		}
	}
	public void parseCommand(String input, World world, Room room) 
	{
		try
		{
			parser.runCommand(input, null, world);
		} 
		catch (CommandParseException e) 
		{
			System.out.println("syntax!");
		} 
		catch (NonExistentCommandException e)
		{
			RoomCommand[] roomCommands = room.getRoomCommands();
			boolean complete = false;
			if(roomCommands != null)
			{
				for (int i = 0; i < roomCommands.length; i++) 
				{
					boolean output = roomCommands[i].performCommand(input, world);
					if(output)
					{
						complete = true;
						break;
					}
				}
			}
			if(!complete)
				System.out.println("I dont know how to " + input);
		} 
		catch (IncorrectDataException e)
		{
			System.out.println(e.getErrorTypeText());
			System.out.println("The program is broken.");
		}
		
	}
	public File getWorldsaveFile()
	{
		return new File("world.qrk");
	}


}
