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

               int asciiNumbers=0;

               for (int i=0;i<key.length();i++){

                   asciiNumbers+=(int) key.charAt(i);
                   System.out.println("ASCII value of : "+ key.charAt(i) + "    is :"+(int) key.charAt(i));
               }
           //TODO better hashing
            int arrayIndex = asciiNumbers % 15;



            return arrayIndex ;
        }

  public void put(String key,String value){


      int arrayIndex = this.hashFunction(key) ;

      System.out.println("Modulus Index= " + arrayIndex + " for value "

              + key);

      // Cycle through the array until we find an empty space

      while (this.map[arrayIndex] != null) {

          ++arrayIndex;

          System.out.println("Collision Try " + arrayIndex + " Instead");

          // If we get to the end of the array go back to index 0

          arrayIndex %= arraySize;

      }

      this.map[arrayIndex] = new Pair(key,value);



  }


   //returns the index of input value
    public int findValue(String key) {

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


    public int  deleteValue(String key){
        int deletedValueIndex= this.findValue(key);
        this.map[deletedValueIndex]= null;
       return  deletedValueIndex;
    }




}


