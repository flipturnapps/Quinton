package com.flipturnapps.quinton.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

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
import com.flipturnapps.quinton.command.ItemUseCommand;
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
		commands.add(new ItemUseCommand());
		BasicCommandParser parser = new BasicCommandParser(commands);
		Scanner scanner = new Scanner(System.in);
		Room lastRoom = null;
		Room room = null;
		while(true)
		{
			room = world.getPlayersRoom();
			if(room == null)
			{
				world.outputLine("You can't go that way.");				
				room = lastRoom;
				world.getPlayer().setLocation(lastRoom.getLocation().copy());
			}
			System.out.println();
			System.out.println(room.getName());
			System.out.println(room.getStartNarration());
			System.out.println(room.getDescription());
			System.out.println("Playerlocation: " + world.getPlayer().getLocation() + "");
			System.out.println("Roomlocation: " + room.getLocation() + "");
			System.out.print(">");
			String input = scanner.nextLine();
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
			lastRoom = room;
		}
	}
	public File getWorldsaveFile()
	{
		return new File("world.qrk");
	}


}
