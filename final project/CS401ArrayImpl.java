package Common;


public class CS401ArrayImpl<E> implements CS401CollectionInterface<E>
{
   private E[] elements;
   private E[] new_elements;
   private int num_elements;
   private int capacity;

  
   @SuppressWarnings("unchecked")
   public CS401ArrayImpl(int size)
   {
      elements = (E[]) new Object[size];
      num_elements = 0;
      capacity = size;
   }

   public CS401ArrayImpl()
   {

      this(30);
   }

   /**
    * Methods inherited from CS401CollectionInterface
    */
   public boolean is_full()
   {
      if (num_elements == capacity)
          return true;
      return false;
   }

   public boolean is_empty()
   {
      if (num_elements == 0) 
          return true;
      return false;
   }

   public int size() { 
	   return num_elements; 
	  }
   

   public boolean add(E e)  {
      add(Where.BACK, e);  // Add at the end
      return true;
   }

   /*
    * Remove element at index i.  If the element exists in the collection, 
    * return that element back to the user.  If the index is out of bounds,
    * return null.
    */
   public E remove(int i) {
      /*
       * Add code here.
       * Remember to compact the array so there are no spaces in between
       * if an element from the middle is removed or an element at the
       * beginning of the array is removed.
       */
	   System.out.println("Now removing: " + elements[i]); 
	  if (i == num_elements) 
		  return null;
	  
	  if (i == 0) 
		  for (int removeFront = num_elements; removeFront >= 0; removeFront--){
			  elements[num_elements + 1] = elements[num_elements];
		  }
	  	 
	  	 if (i < capacity & i > 0) 
		  for (int removeLoop = i; removeLoop < num_elements; removeLoop++ ) { 
			  elements[removeLoop] = elements[removeLoop + 1];
		  }
		  num_elements--;     
	  return null;
   }

   /*
    * Return true if e is in the collection class, false otherwise.
    */
   public boolean contains(E e) {

	   for (int k = 0; k <= num_elements; k++) {
	   if (elements[k] == e)
       return true;
	   }
	return false;
   }
   
   
 

   /**
    * ---- Methods defined by this class 
    * ----------------------------------------------------------
    * Methods that are added by this class and not in the 
    * CS401CollectionInterface
    */

   /**
    * Add element in middle.
    * Preconditions: where == MIDDLE
    *                index <= num_elements - 1
    */
   public boolean add(Where where, int index, E e) { 
  
      /* 
       * If there is no space to add the new element, grow the array. */
      if (is_full())  {
          grow();
      }

      /**
       * Add code here 
       */
      if (where == Where.MIDDLE){
    	  for (int m = num_elements; m >= num_elements - index - 2; m--){
    	  elements[m + 1] = elements[m];
    	
    	  }
    	  elements[index] = e;
    	  num_elements++;
      }
    	  
      return true; 
   }

   /**
    * Add element in front or at the end, as dictated by where.
    * Preconditions: where != MIDDLE
    */
   public boolean add(Where where, E e) { 
   
      /* 
       * If there is no space to add the new element, grow the array. */
      if (is_full())  {
          grow();
      }

      if (where == Where.BACK)  {

          elements[num_elements] = e;
          num_elements++;
      } 
      else if (where == Where.FRONT)  {
 
          for (int f = num_elements; f >= 0; f--){
        	  elements[f + 1] = elements[f];
          }
          elements[0] =e;
          num_elements++;
      }

      return true; 
   }

   /*
    * Gets the element at index i (0 <= i <= num_elements-1)
    */
   public E get(int i)  {

      if (i < 0 && i > num_elements)
          return null;

      return elements[i];
   }
   
   
   

   /**
    * ----------- Private methods
    */
   /*
    * Grows elements array to hold more elements.  Copies old (existing)
    * elements in the new array.
    * 
    * Postcondition: (a) elements must contain the contents of the old array
    *                (b) elements must now have twice as much capacity as
    *                    before
    */
   @SuppressWarnings("unchecked")
   private boolean grow()  {

      /* 
       * Add code here 
       * Expand capacity (double it) and copy old array contents to the
       * new one. 
       */
	  capacity += 10;
	  new_elements = (E[]) new Object[capacity];
	  System.arraycopy(elements, 0, new_elements, 0, elements.length);
	  elements = (E[]) new Object[capacity];
      System.arraycopy(new_elements, 0, elements,0 , new_elements.length);
	  
	  
      System.out.println("Capacity reached.  Increasing storage...");
      

      return true;
   }
   
   
   @SuppressWarnings("unchecked")
public boolean newCap(int newsize)  {


		  capacity = newsize;
		  new_elements = (E[]) new Object[capacity];
		  System.arraycopy(elements, 0, new_elements, 0, elements.length);
		  elements = (E[]) new Object[capacity];
	      System.arraycopy(new_elements, 0, elements,0 , new_elements.length);
		  
		  
	      System.out.println("Capacity is now: " + newsize);
	      

	      return true;
	   }
   
   
   public String toString() {
	   int index;
	   String s = "";
	   for(index = 0; index < num_elements; index++)
		   s += elements[index];
   
   		return s;
}

   
}
