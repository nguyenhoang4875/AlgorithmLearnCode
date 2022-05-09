package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Vector;

public class Borrowers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Vector<Book> booksOnShelves = new Vector<>();
        HashMap<String, Book> bookMap = new HashMap<>();
        String line;
        // read data and save in LinkedList
        while (!(line = br.readLine()).equals("END")) {
            String[] split = line.split("\" by ");
            booksOnShelves.add(new Book(split[1], split[0] + "\""));
            bookMap.put(split[0] + "\"", booksOnShelves.lastElement());
        }

        TreeSet<Book> booksNeedPutBackOnShelves = new TreeSet<>();
        while (!(line = br.readLine()).equals("END")) {
            if (!line.equals("SHELVE")) {
                int index = line.indexOf(" ");
                String op = line.substring(0, index);
                String book = line.substring(index + 1);

                if (op.equals("BORROW")) booksOnShelves.remove(bookMap.get(book));
                else if (op.equals("RETURN")) booksNeedPutBackOnShelves.add(bookMap.get(book));
            } else {
                StringBuilder sb = new StringBuilder();
                for (Book b : booksNeedPutBackOnShelves) {
                    int index = 0;
                    while (index < booksOnShelves.size() && b.compareTo(booksOnShelves.get(index)) > 0) {
                        index++;
                    }
                    if (index == 0) sb.append("Put " + b.name + " first\n");
                    else sb.append("Put " + b.name + " after " + booksOnShelves.get(index - 1).name + "\n");

                    booksOnShelves.add(index, b);
                }
                booksNeedPutBackOnShelves.clear();
                System.out.print(sb);
                System.out.println("END");
            }
        }
    }

    private static class Book implements Comparable<Book> {
        String author;
        String name;

        public Book(String author, String name) {
            this.author = author;
            this.name = name;
        }

        public int compareTo(Book b) {
            if (this.author.equals(b.author)) return this.name.compareTo(b.name);
            return this.author.compareTo(b.author);
        }

        public String toString() {
            return this.name;
        }
    }
}
