package sample;



import java.util.Arrays;

public class HashTable {

   private String[] theArray;
    private  int arraySize;



   public HashTable(int size) {
        arraySize = size; //size should be prime number to avoid collisions
        theArray = new String[size];
        Arrays.fill(theArray, "-1");

    }

    public String[] getTheArray() {
        return theArray;
    }




    public int hashFunction(String stringForArray, String[] theArray) {





            int arrayIndex = Integer.parseInt(stringForArray) % 15;

            System.out.println("Modulus Index= " + arrayIndex + " for value "

                    + stringForArray);

            // Cycle through the array until we find an empty space

            while (theArray[arrayIndex] != "-1") {

                ++arrayIndex;

                System.out.println("Collision Try " + arrayIndex + " Instead");

                // If we get to the end of the array go back to index 0

                arrayIndex %= arraySize;

            }

            theArray[arrayIndex] = stringForArray;
            return arrayIndex ;
        }



 //return strings not int
    public int findKey(String key) {

        // Find the keys original hash key

        int arrayIndexHash = Integer.parseInt(key) % 15;

        while (theArray[arrayIndexHash] != "-1") {



            if (theArray[arrayIndexHash].equals(key) ) {



                // Found the key so return it

                System.out.println(key + " was found in index "

                        + arrayIndexHash);

                return arrayIndexHash;

            }

            // Look in the next index

            ++arrayIndexHash;

            // If we get to the end of the array go back to index 0

            arrayIndexHash %= arraySize;

        }

        // Couldn't locate the key

        return -1;

    }


    public int  deleteValue(String key){
        int deletedValueIndex= this.findKey(key);
        this.theArray[deletedValueIndex]= "-1";
       return  deletedValueIndex;
    }




}




