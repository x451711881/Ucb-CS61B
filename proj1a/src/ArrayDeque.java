public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    /**create an empty array*/
    public ArrayDeque() {
        size = 0;
        items = (T[])new Object[8];
        nextFirst = 0;
        nextLast = 1;
    }

    /** Increasing/Decreasing the underlying array to the target capacity*/
    private void revise(int capacity){
        T[] tmp =(T[]) new Object[capacity];
        int len = items.length;
        System.arraycopy(items,0,tmp,0,size);
        items = tmp;
        //若是因为加法调用，即原array上限了
        if(size == len){
            nextFirst = capacity-1;
            nextLast = size;
        }


    }

    /** Judging if the underlying array should be count down*/
    private int judge(){
        if(items.length >= 16){
            double a = 1.0 * size/ items.length;
            if (a <= 0.25) {
                return 1;
            }else{
                return 0;
            }
        }
        return 0;
    }

    /**Find next nextFirst index*/
    //很巧妙的逆时针循环
    // unlike Python, in Java, the % symbol represents "remainder" rather than "modulus",
    // therefore, it may give negative value, so + items.length is necessary,
    // or to use Math.floorMod(x, y)
    private int moveLeft(int a){
        int res = (a - 1 + items.length) % items.length;
        return res;
    }

    /**Find next nextLast index*/
    private int moveRight(int a){
        int res = (a + 1) % items.length;
        return res;
    }

    /** Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        if (size == items.length){
            revise(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = moveLeft(nextFirst);
        size++;
    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item){
        if (size == items.length){
            revise(size * 2);
        }
        items[nextLast] = item;
        nextLast = moveRight(nextLast);
        size++;
    }
    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        return (size == 0);
    }
    /** Returns the number of items in the deque.*/
    public int size(){
        return size;
    }
    /** Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque(){
       if(size <= 0){
           System.out.println("This is an empty deque");
       }else{
         //找实际起点和实际的末端
         int first = moveRight(nextFirst);
         int last = moveLeft(nextLast);
                                          //起点往后退一个就是2nd个数
         for( int i = first ; i <= last ; i = moveRight(i)){
             System.out.print(items[i] + " ");
         }
         System.out.println();
       }
    }

    /**  Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst(){
        if(size == 0){
            System.out.println("No such element exist");
            return null;
        }
        int trueFirst = moveRight(nextFirst);
        T res = items[trueFirst];
        nextFirst = trueFirst;
        items[trueFirst] = null;
        size--;
        int decision = judge();
        if(decision == 1){
            revise(size/2);
        }
        return res;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast(){
        if(size == 0){
            System.out.println("No such element exist");
            return null;
        }
        int trueLast = moveLeft(nextLast);
        T res = items[trueLast];
        nextLast = trueLast;
        items[trueLast] = null;
        size--;
        int decision = judge();
        if(decision == 1){
            revise(size/2);
        }
        return res;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null.*/
    public T get(int index){
       if(index < 0 || index >= size){
           return null;
       }
       int first = moveRight(nextFirst);
       //巧啊 不用循环，要前进几位就加几
       first = (first + index) % items.length;
       return items[first];
    }
}
