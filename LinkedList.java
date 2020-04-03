import java.util.ArrayList;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return this.head;
    }

    public void incSize() {
        this.size++;
    }

    public void decSize() {
        this.size--;
    }

    public int getSize() {
        return this.size;
    }

    public void add(String editor, String title) {
        Node isFound = this.searchData(editor);

        if (isFound == null) {
            this.setHead(new Node(new Data(editor,title), this.getHead()));
        } else {
            isFound.getData().setTitle(title);
            isFound.getData().addFreq();
        }
    }

    public void sort(){ // Gak tau sort apa ni 
        Node current = this.getHead();
        Data tempData;
        while(current.getNext()!=null) {
            while (current.getData().getName().compareTo(current.getNext().getData().getName()) > 0){
                tempData = current.getNext().getData();
                current.getNext().setData(current.getData());
                current.setData(tempData);
                current = this.getHead();
            }
            current = current.getNext();
        }
    }

        public Node searchData(String editor) {
            Node current = this.getHead();
            while (current != null) {
                if (current.getData().getName().contains(editor))
                    return current;
                if (current.getNext() == null)
                    break;
                current = current.getNext();
            }
    
            return null;
        }

    public void specialSearch(String editor) {
        sort();
        Node current = this.getHead();
        ArrayList<String> nameFound = new ArrayList<>();
        while(current!=null){
            if ( current.getData().getName().contains(editor)){
                nameFound.add(current.getData().getName());
                displayWithTitle(current);
                if (current.getNext() == null)
                break;
            }
            current = current.getNext();
        }
    }

    public void displayWithTitle(Node c) {
        Node current = c;
            System.out.println(current.getData().getName() + " -  Menulis " + current.getData().getFreq() + " Artikel");
            for (int i = 0; i< current.getData().getFreq() ; i++) {
                System.out.println("\t"+(i+1)+". "+current.getData().getTitle(i));
            }
            System.out.println();
            if (current.getNext() != null)
            current = current.getNext();
    }

    public void displayWithTitle() {
        sort();
        Node current = this.getHead();
        while (current != null) {
            System.out.println(current.getData().getName() + " -  Menulis " + current.getData().getFreq() + " Artikel");
            for (int i = 0; i< current.getData().getFreq() ; i++) {
                System.out.println("\t"+(i+1)+". "+current.getData().getTitle(i));
            }
            System.out.println();
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
    }

    public void displayWithoutTitle() {
        sort();
        Node current = this.getHead();

        while (current != null) {
            System.out.println(current.getData().getName() + " - Menulis " + current.getData().getFreq() + " Artikel");
                 if (current.getNext() == null)
                break;
            current = current.getNext();
        }
    }
}

