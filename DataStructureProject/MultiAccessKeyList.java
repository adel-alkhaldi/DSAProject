/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adel
 * @param <K>
 * @param <V>
 */
public class MultiAccessKeyList<K,V> implements InterfaceMultiAccessKeyList<K,V>{
    
  int SIZE = 4; //default size
 
  Node<K, V>[] mainArray;
 
  public MultiAccessKeyList(int SIZE) {
    this.SIZE = SIZE;
    mainArray = new Node[SIZE];
  }
  
  public MultiAccessKeyList() {
    mainArray = new Node[SIZE];
  }
  
  public void add(K key, V value) {
    
    int hashIndex = key.hashCode() % SIZE;
    
    if(hashIndex < 0) { hashIndex = hashIndex + (SIZE - 1); } //Incase It's a negative & -1 is incase it goes out of bounds (missed the last index by going +1) for ex: index 1000 instead of 999 with an array size 1000
    
    
    //reference for the nodeList at that specific array Index
    Node<K, V> nodeListAtArrayIndex = mainArray[hashIndex];
    
    //navigates to the node BEFORE the last one
    if (nodeListAtArrayIndex == null) {
        mainArray[hashIndex]= new Node<K, V>(key, value); 
    } 
    
    //navigates to the node BEFORE the last one, checking if the added key has a matching key in the nodelist at the index and update it's value
    else {
        while (nodeListAtArrayIndex.next != null) {
            if (nodeListAtArrayIndex.getKey() == key) {
                    nodeListAtArrayIndex.setValue(value);
                    return;
            }
            nodeListAtArrayIndex = nodeListAtArrayIndex.next;
      }
    //Checks the Last Node , checking if the added key has a matching key in the nodelist at the index and update it's value
    if (nodeListAtArrayIndex.getKey() == key) {
          nodeListAtArrayIndex.setValue(value);
          return;
    }
    //If it doesn't find a matching key it simply adds it.
      nodeListAtArrayIndex.next = new Node<K, V>(key, value);
    }
  }
 
  public void add(K key, V value, int position) {
    
    if(position > SIZE || position <= 0) {throw new IllegalArgumentException("Position Entered Is Invalid, Pick Value In Range Of The Array & Above Zero.");} //OutOfBounds Exception...
    
    //In the Project Requirements, It's specified that position is meant by it's literal meaning, not as an index...
    Node<K, V> nodeListAtArrayIndex = mainArray[position - 1];
    
    if (nodeListAtArrayIndex == null) {
      mainArray[position]= new Node<K, V>(key, value); 
    } 
    else {
        while (nodeListAtArrayIndex.next != null) {
            if (nodeListAtArrayIndex.getKey() == key) {
                nodeListAtArrayIndex.setValue(value);
                return;
            }
            nodeListAtArrayIndex = nodeListAtArrayIndex.next;
        }
 
        if (nodeListAtArrayIndex.getKey() == key) {
          nodeListAtArrayIndex.setValue(value);
          return;
        }
 
        nodeListAtArrayIndex.next = new Node<K, V>(key, value);
    }
  }
  
  public void clear() {
      this.mainArray = new Node[0];
  }
  
  public boolean contains(K key) {
    int hashIndex = key.hashCode() % SIZE;
    
    if(hashIndex < 0) { hashIndex = hashIndex + (SIZE - 1); } //Incase It's a negative & -1 is incase it goes out of bounds (missed the last index by going +1)
    
    Node<K, V> nodeListAtArrayIndex = mainArray[hashIndex];
    
    /*
    if (nodeListAtArrayIndex == null) {
      return false;
    }
    */
    
    while (nodeListAtArrayIndex != null) {
      if (nodeListAtArrayIndex.getKey() == key) {return true;}
      nodeListAtArrayIndex = nodeListAtArrayIndex.next;
    }
    
    //the for loop will run incase it couldn't find the key, this happens if key is inserted using add(position:int)
    for(Node<K, V> NodeList : mainArray){ //for-each loop and cycle through the whole hashTable
        if(NodeList == null){ continue;}
        while(NodeList != null){
            if(NodeList.getKey().equals(key)) {return true;}
            NodeList = NodeList.next;
        }
    }
    
 
    return false; 
}
  
  public boolean contain(V value) {
    
    for(int i = 0; i < mainArray.length; i++){
        Node<K, V> nodeListAtArrayIndex = mainArray[i];
        if(nodeListAtArrayIndex == null){ continue;}
        while(nodeListAtArrayIndex != null){
            if(nodeListAtArrayIndex.getValue().equals(value) ) {return true;}
            nodeListAtArrayIndex = nodeListAtArrayIndex.next;
        }
    }
    
    
    return false;
  }
  
  public V remove(K key) {
      
    int hashIndex = key.hashCode() % SIZE;
    
    if(hashIndex < 0) { hashIndex = hashIndex + (SIZE - 1); } 
    
    Node<K, V> nodeListAtArrayIndex = mainArray[hashIndex];
 
    if (nodeListAtArrayIndex == null) {
      return null;
    }
 
    if (nodeListAtArrayIndex.getKey() == key) {
      mainArray[hashIndex] = nodeListAtArrayIndex.next;
      nodeListAtArrayIndex.next = null;
      return nodeListAtArrayIndex.value;
    }
 
    Node<K, V> prev = nodeListAtArrayIndex;
    nodeListAtArrayIndex = nodeListAtArrayIndex.next;
 
    while (nodeListAtArrayIndex != null) {
      if (nodeListAtArrayIndex.getKey() == key) {
        prev.next = nodeListAtArrayIndex.next;
        nodeListAtArrayIndex.next = null;
        return nodeListAtArrayIndex.getValue();
      }
      prev = nodeListAtArrayIndex;
      nodeListAtArrayIndex = nodeListAtArrayIndex.next;
    }
 
    return null;
  }
  
  //This Remove Method Variante Can Delete The Entire nodeList at that index of the mainArray & Print Their values while returning the last node in that nodeList.
  public V removeEntirePosition(int position) {
    
    if(position > SIZE || position <= 0) {throw new IllegalArgumentException("Position Entered Is Invalid, Pick Value In Range Of The Array & Above Zero.");} //OutOfBounds Exception...
    
    //In the Project Requirements, It's specified that position is meant by it's literal meaning, not as an index...
    Node<K, V> nodeListAtArrayIndex = mainArray[position - 1];   
    
    V value = null;
    while (nodeListAtArrayIndex != null) {//repeat loop until there are no more nodes left in the nodeList
         value = nodeListAtArrayIndex.getValue(); 
         nodeListAtArrayIndex = nodeListAtArrayIndex.next; // Remove first node from chain
         System.out.println("Node's Value: " + value);
    }
    mainArray[position - 1] = null;
    System.out.println();
    System.out.print("Final Deleted Node's Value From Position " + position + ": ");
    return value;
    
    }
  
  /* 
     I Included 2 remove methods because you didn't specify the behavior of the remove method in the array 
     So removeEntirePosition removes all nodes in that position
     and remove simply removes first node in the nodeList.
  */
  
  //Delete First Node In That position in the mainArray.
  public V remove(int position) {
    
    if(position > SIZE || position <= 0) {throw new IllegalArgumentException("Position Entered Is Invalid, Pick Value In Range Of The Array & Above Zero.");} //OutOfBounds Exception...
    
    //In the Project Requirements, It's specified that position is meant by it's literal meaning, not as an index...
    Node<K, V> nodeListAtArrayIndex = mainArray[position - 1];   
    K key = nodeListAtArrayIndex.getKey();    
    
    
    if (nodeListAtArrayIndex == null) {
      return null;
    }
 
    if (nodeListAtArrayIndex.getKey() == key) {
      mainArray[position - 1] = nodeListAtArrayIndex.next;
      nodeListAtArrayIndex.next = null;
      return nodeListAtArrayIndex.value;
    }
 
    Node<K, V> prev = nodeListAtArrayIndex;
    nodeListAtArrayIndex = nodeListAtArrayIndex.next;
 
    while (nodeListAtArrayIndex != null) {
      if (nodeListAtArrayIndex.getKey() == key) {
        prev.next = nodeListAtArrayIndex.next;
        nodeListAtArrayIndex.next = null;
        return nodeListAtArrayIndex.value;
      }
      prev = nodeListAtArrayIndex;
      nodeListAtArrayIndex = nodeListAtArrayIndex.next;
    }
 
    return null;
  }
  
  /* //Use This Version of the toString to print out data in CSV Format
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    
    if(mainArray.length == 0) {return "HashTable is empty";}
    
    for (int i = 0; i < SIZE; i++) {
      if (mainArray[i] != null) {
        sb.append(mainArray[i]);
      }
    }
 
    return sb.toString();
  }
  */
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    
    if(mainArray.length == 0) {return "HashTable is empty";}
    
    for (int i = 0; i < SIZE; i++) {
      //if (mainArray[i] != null) {
        sb.append("Index: "+ i + "  " + mainArray[i] + "\n");
      //}

    }
 
    return sb.toString();
  }
   
 private class Node<K,V> {
    
    private final K key;
    private V value;
    private Node<K, V> next;
 
    public Node(K key, V value) {
        
      if(key == null) {throw new IllegalArgumentException(" Value That Is Being Set Is Null & Invalid");}
      else{
          this.key = key;
      }
      
      if(value == null) {throw new IllegalArgumentException(" Value That Is Being Set Is Null & Invalid");}
      else {
          this.value = value;
      }
      
    }
 
    public K getKey() {
      return this.key;
    }
 
    public V getValue() {
      return this.value;
    }
 
    public void setValue(V value) {
      if(value == null) {throw new IllegalArgumentException(" Value That Is Being Set Is Null & Invalid");}
      else{
      this.value = value;
      }
    }
    /* //Use This Version of the toString to print out data in CSV Format
    @Override
    public String toString() {
      Node<K,V> temp = this;
      StringBuilder sb = new StringBuilder();
      while (temp != null) {
        sb.append(temp.key + "," + temp.value + "\n" );
        temp = temp.next;
      }      
      return sb.toString();
    }
    */
    /*Using StringBuilder was a suggestion on one of the forums in StackOverFlow regarding printing nodes of a hashmap ...*/ 
    @Override
    public String toString() {
      Node<K,V> temp = this;
      StringBuilder sb = new StringBuilder();
      while (temp != null) {
        if(temp.next !=null){
        sb.append("Key:"+temp.key + " , " + "Value:"+ temp.value + " -->  " );
        }
        if(temp.next == null){
        sb.append("Key:"+temp.key + "  " + "Value:"+ temp.value );
        }
        temp = temp.next;
      }      
      return sb.toString();
    }
    
}    
    
}
