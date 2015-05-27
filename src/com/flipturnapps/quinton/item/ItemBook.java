package com.flipturnapps.quinton.item;

import java.util.HashMap;

import com.flipturnapps.quinton.id.ItemId;
import com.flipturnapps.quinton.xmldata.ItemGen;
import com.flipturnapps.quinton.xmldata.World;

public class ItemBook extends Item 
{
	public ItemBook(World world, ItemGen item)
	{
		super(world,item);
	}
	public ItemBook(World world)
	{
		super(world);	
	}
	public ItemBook(World world, String name, int id, String attributes)
	{
		super(world,name,id,attributes);
	}
	public ItemBook(World world, String name, int id)
	{
		super(world,name,id);
	}
	private static final String ATTRIBUTENAME_BOOKTEXT = "booktext";
	private String booktext;
	

	@Override
	public int getSubtypeId() 
	{
		return ItemId.ITEMTYPE_BOOK;
	}

	@Override
	public boolean useAsSubtype() 
	{
		this.getWorld().println("You read the " + this.getName() + ".  It reads: ");
		this.getWorld().println(" \"" + booktext + "\"");
		return false;
	}

	@Override
	public HashMap<String, String> getSubtypeAttributes()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put(ATTRIBUTENAME_BOOKTEXT, booktext);
		return map;
	}

	@Override
	protected void processSubtypeAttribute(String name, String value) 
	{
		if(name.equalsIgnoreCase(ATTRIBUTENAME_BOOKTEXT))
			booktext = value;

	}
	public String getBooktext() {
		return booktext;
	}
	public void setBooktext(String booktext) {
		this.booktext = booktext;
	}
	@Override
	public String[] getNounSynonyms() 
	{
		return null;
	}
	@Override
	public String[] getVerbSynonyms() 	
	{
		return new String[]{"read"};
	}
	@Override
	public boolean canInventory() 
	{
		return true;
	}
}
