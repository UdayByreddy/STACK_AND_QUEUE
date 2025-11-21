
class LRUCache {

   private class node{
    int key;
    int value;
    node prev;
    node next;
    public node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
    private int capacity;
    HashMap<Integer,node> cache;
    private node head;
    private node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

       cache = new HashMap<>();
       head = new node(0,0);
       tail = new node(0,0);
       head.next= tail;
       tail.prev = head;
        
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            node Node = cache.get(key);
            removeIt(Node);
            addInfront(Node);
            return Node.value;
        }
        return -1;
        
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            node leastnode = cache.get(key);
            removeIt(leastnode);

        }
        else if(cache.size()>=capacity){
            node leastused = tail.prev;
            removeIt(leastused);
            cache.remove(leastused.key);
            
        }
         node element = new node(key,value);
            cache.put(key,element);
            addInfront(element);
        
        
    }
    public void removeIt(node least){
        least.prev.next = least.next;
        least.next.prev = least.prev;

    }
    public void addInfront(node Node){
        Node.next = head.next;
        Node.prev = head;
        head.next.prev = Node;
        head.next = Node;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */