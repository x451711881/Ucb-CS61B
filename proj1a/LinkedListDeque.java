public class LinkedListDeque <T> {

        private  class TNode{
            public T item;
            public TNode next;
            public TNode prev;
            public TNode( T x, TNode n, TNode p){
                item = x;
                next = n;
                prev = p;
            }

        }

        private TNode sentinel;
        public int size;



        /** create an empty LinkedListDeque*/
        public LinkedListDeque(){
            size = 0;
            sentinel = new TNode(null, null, null);
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
        }
        /** add x to the start*/
        public void addFirst(T x){
            if(size == 0){
                sentinel.next = new TNode(x, sentinel, sentinel);
                sentinel.prev = sentinel.next;
            }else {
                sentinel.next= new TNode(x, sentinel.prev, sentinel);
                sentinel.prev.prev = sentinel.next;
            }
            size++;

        }
        /**add x to the end*/
        public void addLast(T x){
            if(size == 0){
                sentinel.next = new TNode(x,sentinel,sentinel);
                sentinel.prev = sentinel.next;
            }else{
                sentinel.prev.next = new TNode(x, sentinel, sentinel.prev);
                sentinel.prev = sentinel.prev.next;
            }
            size++;
        }
        /** return true if the deque is empty, otherwise return false*/
        public boolean isEmpty(){
            if(size == 0){
                return true;
            }else{
                return false;
            }
        }
       /** return the number of TNodes in the deque*/
        public int size(){
            return this.size;
        }
       /** print all nodes in the deque*/
        public void printDeque(){
            if(size == 0){
                System.out.println("There is no item in the Deque. Please add items");
            }else{
                TNode p = sentinel.next;
                while (p != sentinel){
                    System.out.print(p.item +" ");
                    p = p.next;
                }
            }
        }
        /** removes and returns the item at the front of the deque*/
        public T removeFirst(){
            if(size == 0){
                return null;
            }
            else if (size == 1){
                T res = sentinel.next.item;
                sentinel.next = sentinel;
                sentinel.prev = sentinel;
                size--;
                return res;
            }
            else{
                T res = sentinel.next.item;
                sentinel.next = sentinel.next.next;
                sentinel.next.prev = sentinel;
                size--;
                return res;
            }
        }
        /**  Removes and returns the item at the back of the deque. */
        public T removeLast() {
            if (size == 0) {
                return null;
            } else if (size == 1) {
                T res = sentinel.prev.item;
                sentinel.next = sentinel;
                sentinel.prev = sentinel;
                size--;
                return res;
            } else {
                T res = sentinel.prev.item;
                sentinel.prev = sentinel.prev.prev;
                sentinel.prev.next = sentinel;
                size--;
                return res;
            }
        }
        /** Get the item at the given index by iteration*/
        public T get(int index){
            int len = this.size();
            if (index >= len){
                return null;
            }
            TNode p =sentinel.next;
            for(int i = 0; i < index;i++){
                p = p.next;
            }
            return p.item;

        }

       /** get the item at the given index by recursion */
       private T helperGet(int index, TNode p){
           if(index == 0){
               return p.item;
           }
           return helperGet(index-1 , p.next);
       }

       public T getRecursive(int index){
           if(index > this.size()){
               return null;
           }
           T res = helperGet(index, sentinel.next);
           return res;
       }






}
