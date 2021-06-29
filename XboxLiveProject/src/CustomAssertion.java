import java.util.ArrayList;

import org.testng.asserts.Assertion;

public class CustomAssertion extends Assertion{
	private ArrayList<String> inputMessages = new ArrayList();
	private ArrayList<String> compareMessages = new ArrayList();
	
	public void addMessage(String n)
	{
		inputMessages.add(n);
		System.out.println("Added message: " + n);
	}
	
	public void addCompare(String n)
	{
		compareMessages.add(n);
		System.out.println("Added compareMessage: " + n);
	}
	
	public boolean assertCompare()
	{
		for (int i = 0; i < inputMessages.size(); i++)
		{
			if (inputMessages.get(i).compareTo(compareMessages.get(i))!=0)
			{
				return false;
			}
		}
		return true;
	}
	
	public void addLists(ArrayList<String> n, ArrayList<String> m)
	{
		for (int i = 0; i < n.size(); i++)
		{
			addMessage(n.get(i));
		}
		for (int i = 0; i < m.size(); i++)
		{
			addCompare(m.get(i));
		}
	}
	
	public void messagesClear()
	{
		inputMessages.clear();
		compareMessages.clear();
	}
}
