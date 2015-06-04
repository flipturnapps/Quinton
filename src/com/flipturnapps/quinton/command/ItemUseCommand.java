package com.flipturnapps.quinton.command;

import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.SimpleCommand;
import com.flipturnapps.kevinLibrary.helper.ArrayHelper;
import com.flipturnapps.quinton.item.Item;

public class ItemUseCommand extends SimpleCommand 
{

	private  ArrayList<Item> itemList;

	@Override
	public String getName()
	{
		return "use";
	}

	@Override
	public String getHelpText() 
	{
		return "useitem [item]";
	}

	@Override
	public int getMaximumParams() 
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int getMinimumParams() 
	{
		return 0;
	}

	@Override
	public boolean willInterceptCommand(Command command, String[] params) 
	{
		return false;
	}

	@Override
	public void interceptCommand(Command command, String[] params) 
	{

	}

	@Override
	public int getInterceptPriority() 
	{
		return 0;
	}

	@Override
	public String[] getAliases() 
	{
		return null;
	}

	@Override
	public Object execute(String verb, String[] nouns, Object data) 
	{
		Item useItem = this.itemList.get(this.getItemIndexUsed(verb, nouns));
		useItem.interactWith(verb);		
		return null;
	}

	@Override
	public ArrayList<String> getPermissionsCanHave()
	{
		return null;
	}

	@Override
	public boolean objectDataOK(Object data) 
	{
		return true;
	}

	@Override
	public boolean permProtected() 
	{
		return false;
	}
	public boolean namesMatch(String verb, String[] nouns)
	{
		if(this.getItemIndexUsed(verb, nouns) > -1)
			return true;
		return false;
	}
	private int getItemIndexUsed(String verb, String[] nouns)
	{
		if(nouns == null || nouns.length == 0)
			return -1; 
		int itemIndex = -1;
		String nounString = "";
		for (int i = 0; i < nouns.length; i++)
		{
			nounString += nouns[i];
			if(i != (nouns.length - 1))
				nounString += " ";
		}
		for(int i = 0; i < itemList.size(); i++)
		{
			
			boolean nounsMatch = nounString.equalsIgnoreCase(itemList.get(i).getName());
			
			
			boolean verbsMatch = itemList.get(i).isVerbAllowed(verb);
			if(nounsMatch && verbsMatch)
				itemIndex = i;
			
		}
		return itemIndex;
	}

	public void clearItemList()
	{
		if(itemList == null)
			itemList = new ArrayList<Item>();
		itemList.clear();
	}
	public void registerItem(Item item)
	{
		if(itemList == null)
			itemList = new ArrayList<Item>();
		itemList.add(item);
		
	}

}
