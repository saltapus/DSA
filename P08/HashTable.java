/*****************************
 * Author: Anthony C
 * Program: HashTable
 * Date Created: 14/05/2019
 * ***************************/

import java.util.*;
import java.math.*;

public class HashTable<E>
{
    private class HashEntry
    {
        String key;
        E value;
        int state;

        public HashEntry()
        {
            key = "";
            value = null;
            state = 0;
        }
        
        public HashEntry(String inKey, E inValue)
        {
            key = inKey;
            value = inValue;
            state = 1;
        }
    
        public String toString()
        {
            return key + " " + value;
        }

        
    }

    private HashEntry[] m_hashTable;
    private int size;

    public HashTable(int tableSize)
    {
        int actualSize = findNextPrime(tableSize);
        
    }
    
    private int hash(String key)
    {
        int hashIdx = 0;
    
        for (int ii = 0; ii< key.length(); ii++)
        {
            hashIdx = (31 * hashIdx) + key.charAt(ii);
        }
        return hashIdx % m_hashTable.length;
    }
    
    
    public E get(String inKey)
    { 
        int hashIdx, origIdx;
        hashIdx = hash(inKey);
        origIdx = hashIdx;
        boolean found = false;
        boolean giveUp = false;
        
        while((!found)&& (!giveUp))
        {
            if (m_hashTable[hashIdx].state == 0)
            {
                giveUp = true;
            }
            else
            {
                hashIdx = (hashIdx + 1) % m_hashTable.length;
                if (hashIdx == origIdx)
                {
                    giveUp = true;
                }   
            }
        }
        if(!found)
        {
            throw new IllegalArgumentException("cann't be found");
        }
        return m_hashTable[hashIdx].value;
        
    }

    public void put(String key, E value)
    {
        int hashIdx = hash(key);
        HashEntry<E> hash = new HashEntry<E>(key, value);
        if (m_hashTable[hashIdx] == null)
        {
            m_hashTable[hashIdx] = hash;
        }
        else
        {
            HashTable temp = m_hashTable[hashIdx];
        }
        return temp;
    }


        
    public E remove(String key)
    {
    }

    public boolean containsKey(String key)
    {
        return HashEntry.containsKey(key);
    }
    
    private void resize(int size)
    {
    }



    public int findNextPrime(int startVal)
    {
        int i;
        int primeVal;
        if(startVal % 2 == 0)
        {
            primeVal = startVal--;
        }
        else
        {
            primeVal = startVal;
        }
        boolean isPrime = false;
        do
        {
            primeVal = primeVal + 2;
            isPrime = true;
            i = 3;
            do
            {
                if(primeVal % 2 == 0)
                {
                    isPrime = false;
                }
                else
                {
                    i = i + 2;
                }
            }while(i<= primeVal && isPrime);
            
        }while (!isPrime);
        return primeVal;       
    }


    public String toString()
    {
        return m_hashTable.toString();
    }
}

