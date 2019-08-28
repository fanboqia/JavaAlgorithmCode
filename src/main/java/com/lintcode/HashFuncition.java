package com.lintcode;

public class HashFuncition {

    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public static int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        long hash = 0;
        for(int i = 0; i < key.length; i++){
            hash = (hash * 33 + (int)(key[i])) % HASH_SIZE;
        }
        return (int)hash;
    }
}
