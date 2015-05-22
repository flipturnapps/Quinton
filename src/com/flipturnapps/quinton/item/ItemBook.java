package com.flipturnapps.quinton.item;

import java.util.HashMap;

import com.flipturnapps.quinton.xmldata.ItemGen;
import com.flipturnapps.quinton.xmldata.World;

public class ItemBook extends Item 
{
	public static final String SUBTYPE_NAME = "book";
	private static final String ATTRIBUTENAME_BOOKTEXT = "booktext";
	private String booktext;
	
	public ItemBook(World world, ItemGen item) 
	{
		super(world, item);
	}

	@Override
	public String getSubtypeName() 
	{
		return SUBTYPE_NAME;
	}

	@Override
	public void useAsSubtype() 
	{
		this.getWorld().outputLine("You read the " + this.getName() + ".  It reads: ");
		this.getWorld().outputLine(booktext);
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
		if(name.equalsIgnoreCase("ATTRIBUTENAME_BOOKTEXT"))
			booktext = value;

	}
	public String getBooktext() {
		return booktext;
	}
	public void setBooktext(String booktext) {
		this.booktext = booktext;
	}
}
