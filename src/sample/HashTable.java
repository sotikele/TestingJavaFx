package sample;



import java.util.Arrays;

public class HashTable {

   private String[] theArray;
    private  int arraySize;
    private int itemsInArray;


   public HashTable(int size) {
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");

    }

    public String[] getTheArray() {
        return theArray;
    }




    public int hashFunction2(String[] stringsForArray, String[] theArray) {


        for (int n = 0; n < stringsForArray.length; n++) {


            String newElementVal = stringsForArray[n];


            // Create an index to store the value in by taking

            // the modulus

            int arrayIndex = Integer.parseInt(newElementVal) % 15;

            System.out.println("Modulus Index= " + arrayIndex + " for value "

                    + newElementVal);

            // Cycle through the array until we find an empty space

            while (theArray[arrayIndex] != "-1") {

                ++arrayIndex;

                System.out.println("Collision Try " + arrayIndex + " Instead");

                // If we get to the end of the array go back to index 0

                arrayIndex %= arraySize;

            }

            theArray[arrayIndex] = newElementVal;
            return arrayIndex ;
        }
       return 0;
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







}




/*  HashTable theHash=new HashTable(30);
        //String[] elementsToAdd = {"1","5","17","21","26"};
        // theHash.hashFunction1(elementsToAdd,theHash.theArray);
        // theHash.displayTheStack();
        String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",

                "235", "802", "900", "723", "699", "1", "16", "999", "890",

                "725", "998", "978", "988", "990", "989", "984", "320", "321",

                "400", "415", "450", "50", "660", "624" };
        theHash.hashFunction2(elementsToAdd2,theHash.theArray);
        theHash.displayTheStack();

        theHash.findKey("989");*/