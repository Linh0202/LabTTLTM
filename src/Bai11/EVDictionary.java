/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai11;
import java.util.*;
/**
 *
 * @author Linh Nguyen
 */
public class EVDictionary 
{
	public TreeMap<String,EVWordClass> dic;
	
	// Tao TreeMap bao gom tu va 
	public EVDictionary() 
{
		dic = new TreeMap<String,EVWordClass>();
	}
	
	// Them tu moi vao tu dien
        public void themtu(EVWordClass word)
        {
            dic.put(word.getWord().toLowerCase(),word);
        }
	public boolean addWord(EVWordClass word)
	{
		if(dic.put(word.getWord().toLowerCase(),word) != null)
			return false;
		return true;
	}
	
	// Tra tu
	public EVWordClass lookup(String word)
	{
		return dic.get(word);
	}

	public String toString() 
	{
		String ret = "";
		for(EVWordClass w:dic.values())
			ret += w.toString()+"\n";
		return ret;
	}
}
