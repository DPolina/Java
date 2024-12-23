/*
A few types of Java data structures (sometimes known as lists):

Arrays = a way of storing multiple values in a single variable. Arrays have a 
specific size, but their elements can be changed. This is similar to a shopping list written on a 
paper notepad. Each line can hold a shopping item, but a single piece of paper can only hold
so many shopping items.


ArrayList = like arrays, but you can add new elements to the array list to make 
it longer. This is similar to the Notes app on a phone that just keeps getting longer and longer the more 
you add.

Queue (not covered in this course) = like arrays, but the order is first in, first out, like a line at a 
grocery store. The first customers in line leave first before customers that 
line up later.

Dictionary (not covered in this course) = like an array, but it contains key-value pairs, like an actual
dictionary. In a dictionary, the keys are words and the values are their 
meaning.

In this course, we will just be focussing on arrays and arrayLists.
 */
 
public class Main {

    public static void main(String[] args) {
        /*parallel arrays: arrays where the i-th element in one array is linked to the i-th element in another, together representing an object or entity
        
        2 ways to set up arrays
                - filled from the beginning
                - empty array
        2 major characteristics
                - size can not change
                - only holds one type of data
         */

        String[] names = {"Bob", "Bobert", "Boberta", "Bobertium", "Boberto"}; //filled array: datatype[] arrayName = {value, another value, ...};
        // Note: The data entered into an array are called the elements of that array. The element's place in its array is its index, starting from 
        //       the 0th (first) entry with an index of 0.
        int[] hours = new int[5]; //empty array: datatype[] arrayName = new datatype[size]; 
        double[] wages = {15.0, 15.0, 15.0, 15.0, 15.0};

        hours[0] = 40; // Entering elements into the hours array one by one, specifying the index.  
        hours[2] = 25;
        hours[4] = 30;

        for (int i = 0; i < names.length; i++) {
            if (hours[i] > 0) {
                //System.out.print(names[i] + "   " + hours[i]);
                //System.out.println("   $" + wages[i] + "  Total: $" + (hours[i] * wages[i]));
                System.out.printf("   Name: %20s, hours: $%02d, total: $%5.2f;\n", names[i], hours[i], (hours[i] * wages[i]));
            }
        }

        //For loop that gives full time employees (>39 hours) a $5 raise
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 39) {
                wages[i] += 5;
            }
        }

        //For loop that reprints        
        for (int i = 0; i < names.length; i++) {

            System.out.print(names[i] + "   " + hours[i]);
            System.out.println("   $" + wages[i] + "  Total: $" + (hours[i] * wages[i]));

        }

    }//end main

}//end class