/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Adel
 */
public interface InterfaceMultiAccessKeyList<K,V> {
    
    public void add(K key, V value,int position);
    
    public void add(K key, V value);
    
    public V remove(int position);
    
    public V remove(K key);
    
    public void clear();//Just set HashTable to new HashTable w SIZE zero
    
    public boolean contain(V value); //naming both of them contain results in error for some reason...
    
    public boolean contains(K key); //naming both of them contain results in error for some reason...

}

