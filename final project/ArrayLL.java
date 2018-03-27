package Common;
import java.io.IOException;

public class ArrayLL<E> {

	
    private int MAX_CAP = 30;
    @SuppressWarnings("rawtypes")
	private ANode[] list;
    private int size;
    private int startOfListIndex = 0;

    public ArrayLL() {
        list = new ANode[MAX_CAP];        
        for (int i = 0; i < list.length; i++) {
            list[i] = new ANode<E>(null);
        }
        size = 0;
    }


    public void addElem(E d) throws IOException {
        if (this.getSize() == 0) {
            ANode<E> newNode = new ANode<E>(d, -1);
            list[0] = newNode;
        } else if (size == MAX_CAP + 1) {
            throw new IOException("List is full");
        } else {
            int index = 0;
            for (int i = 0; i < list.length; i++) {
                if (list[i].getData() == null) {
                    index = i;
                    break;
                }
            }
            ANode<E> b = new ANode<E>(d);
            list[index] = b;
            if (this.getSize() == 1) {
                
                    list[index].setLink(-1);
                    list[0].setLink(index);
                
            } else {
                int i = startOfListIndex;
                int prevIndex = -1;
                while (i!=-1 && list[i].getData() != null) {
                    
                        prevIndex = i;
                        i=list[i].getLink();
                    }
                if(i==-1)
                {
                    list[prevIndex].setLink(index);
                }
            }
        }
        size++;
    }

    @SuppressWarnings("rawtypes")
	public ANode[] getList() {
        return list;
    }

    public int getSize() {
        return size;
    }
    public String toString() {
    	
        ArrayLL<E> myList  = new ArrayLL<E>();
        String s = null;
        int i = myList.startOfListIndex;
        while(myList.list[i].getLink()!=-1)
        {
            s += myList.list[i].getData();
            i = myList.list[i].getLink();
        }
            s += myList.list[i].getData();
            return s;
    }




    @SuppressWarnings("hiding")
	class ANode<E> {
    	private E data;
    	private int link;

    public ANode(E d) {
        data = d;
        link = -1;
    }

    public ANode(E d, int l) {
        data = d;
        link = l;
    }

    public E getData() {
        return data;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int l) {
        link = l;
    }
    
}
}