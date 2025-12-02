package com.example.task8_ya;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LibraryManager
{
    public static void main(String[] args)
    {
        Map<UUID, LibraryItem> inventory = new HashMap<>();


        Book b1 = new Book("Harry Potter and the Philosopher's Stone", 1997, "J.K. Rowling", 309);
        Book b2 = new Book("1984", 1949, "George Orwell", 328);
        Book b3 = new Book("The Hitchhiker's Guide to the Galaxy", 1979, "Douglas Adams", 224);
        Magazine m1 = new Magazine("National Geographic", 2023, 10, "Susan Goldberg");
        Magazine m2 = new Magazine("Wired", 2023, 12, "Nicholas Thompson");

        inventory.put(b1.getItemId(), b1);
        inventory.put(b2.getItemId(), b2);
        inventory.put(b3.getItemId(), b3);
        inventory.put(m1.getItemId(), m1);
        inventory.put(m2.getItemId(), m2);



        UUID idToFind = b2.getItemId();

        LibraryItem foundItem = inventory.get(idToFind);
        System.out.println("Retrieved:");
        System.out.println(foundItem);
        System.out.println();

        UUID nonExistentId = UUID.randomUUID();
        LibraryItem notFoundItem = inventory.get(nonExistentId);

        System.out.println("Attempt to retrieve a non-existing item (ID: " + nonExistentId + "):");
        if (notFoundItem == null)
        {
            System.out.println("Result: Item not found.");
        }
        else
        {
            System.out.println("Result: " + notFoundItem);
        }
        System.out.println();


        b1.borrow();
        m1.borrow();


        for (LibraryItem item : inventory.values())
        {
            if (item.isBorrowed())
            {
                double fee = item.calculateLateFee(10);
                System.out.println(item.getTitle() + " has a late fee after 10 days: " + fee);
            }
        }
        System.out.println();


        String searchQuery = "Harry Potter";

        System.out.println("מחפש פריטים התואמים ל: '" + searchQuery + "'...");

        for (LibraryItem item : inventory.values())
        {
            if (item instanceof Searchable)
            {
                Searchable searchableItem = (Searchable) item;
                if (searchableItem.matches(searchQuery))
                {
                    System.out.println( item.getTitle());
                }
            }
        }
    }
}
