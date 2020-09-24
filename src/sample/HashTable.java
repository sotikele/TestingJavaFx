package sample;



import java.util.Arrays;

public class HashTable {

    private  int arraySize;
    private Pair[] map;

   public HashTable(int size) {
        arraySize = size; //size should be prime number to avoid collisions
        map = new Pair[size];
        Arrays.fill(map, null);

    }

    public Pair[] getTheArray() {
        return map;
    }


    public int hashFunction(String key) {

               int asciiNumber=0;

               for (int i=0;i<key.length();i++){

                   asciiNumber+=(int) key.charAt(i);

               }
            int arrayIndex = asciiNumber % 15;

        // Cycle through the array until you find an empty space
        while (this.map[arrayIndex] != null) {

            ++arrayIndex;

            // If you go to the end of the array go back to index 0

            arrayIndex %= arraySize;

        }

            return arrayIndex ;
        }

  public void put(String key,String value){


      int arrayIndex = this.hashFunction(key) ;

     // System.out.println("Modulus Index= " + arrayIndex + " for value " + key);


      this.map[arrayIndex] = new Pair(key,value);



  }

    public boolean hasKey(String key){

         for (Pair pair : map) {
             if(pair != null) {
                 if (pair.getKey().equals(key)) {
                     return true;
                 }
             }
         }
        return false;

    }

    public boolean isFull(){

        for (Pair pair : map) {
            if(pair == null) {
                    return false;
            }
        }
        return true;

    }

   //returns the index of input value
    public int search(String key) {

        // Find the keys original hash key
        int asciiNumbers=0;

        for (int i=0;i<key.length();i++){

            asciiNumbers+=(int) key.charAt(i);
        }

        int arrayIndexHash = asciiNumbers % 15;

        while (map[arrayIndexHash] != null) {



            if (map[arrayIndexHash].getKey().equals(key) ) {



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


    public int  delete(String key){
        int deletedValueIndex= this.search(key);
        if(deletedValueIndex!=-1){
            this.map[deletedValueIndex]= null;
            return  deletedValueIndex;
        }
        return deletedValueIndex ;

    }

}