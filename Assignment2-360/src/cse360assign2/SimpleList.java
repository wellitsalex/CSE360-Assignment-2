package cse360assign2;

/*	Author: Alex Peters
 *  Class ID: 311
 *  Assignment 1-2
 * 
 * This file implements a list using an array as the data structure. Similar to
 * a stack, our SimpleList will add and remove elements then shift elements to 
 * the right for adding and to the left for removing. We have the ability to 
 * get the number of elements within the list and also search for elements.
 * Finally the list can be printed out in a format similar to this "1 2 3"
 * 
 */
public class SimpleList {
	
	private int[] list;
	private int count;
	
	
	/*
	 * Constructor for our list, sets the size to 10 elements and sets count to
	 * 0.
	 * 
	 */
	public SimpleList() {
		//creating array list, with size 10
		list = new int[10];
		count = 0;
		
	}
	
	/*
	 * Adds an element 'x' to the list and shifts existing up. 
	 * 
	 * @param  x  an element to be added to the list
	 */
	public void add(int x) {
		
		//if list is full shift elements over 1
		if(count == list.length) {
			for(int i = count - 2; i >= 0; i--) {
				list[i + 1] = list[i];
			}
			list[0] = x;
		} else {
			//moving all elements in list the the right one position
			for(int i = count - 1; i >= 0; i--) {
				list[i + 1] = list[i];
			}
			
			list[0] = x;
			count++;
		}
		
	
	}
	
	/*
	 * Removes an element 'x' from the list and shifts existing elements down.
	 * if element does not exist, nothing is done.
	 * 
	 * @param  x  the element to be removed
	 */
	public void remove(int x) {
		
		//Checking for element to be removed
		for(int i = 0; i < list.length - 1; i++) {
			if(x == list[i]) {
				//shift all elements down one if element is found
				for(int j = i; j < list.length - 1; j++){
				    list[j] = list[j + 1];
				  }
				count--;
				//decrement i to account for consecutive duplicates
				i = list.length; //FIXED TEST ID 11 FAIL
			}
		}
	}
	
	/*
	 * Returns the number of elements in list. 
	 * 
	 * @return the number of elements in list.
	 */
	public int count() {
		
		return count;
	}
	
	/*
	 * Returns a string containing all of the elements within the list,
	 * formatted with a space in between and no space after the last element.
	 * 
	 * @return a formatted string of all elements in the list.
	 * 
	 */
	public String toString() {
		String rtnString = "";
		
		//looping through list and adding elements to rtnString
		for(int i = 0; i < count; i++) {
			rtnString += list[i] + " ";
		}
		//removing last space on rtnString  
		//FIXED TEST ID 1 FAIL
		if(rtnString != "") {
			rtnString = rtnString.substring(0, rtnString.length() - 1);
		}
		
		
		return rtnString;
		
	}
	
	/*
	 * Returns the location of 'x' within the list. Starting from 1 as index 0.
	 * 
	 * @param  the element we are searching for in list.
	 * @return the location of the element as an integer. 
	 */
	public int search(int x) {
		
		//looping though array looking for element x
		for(int i = 0; i < count; i++) {
			if(x == list[i]) {
				return i; //FIXED TEST ID 6,10 FAIL
			} 
		}
		
		return -1;
	}
	
}