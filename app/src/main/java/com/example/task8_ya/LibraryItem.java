package com.example.task8_ya;
import java.util.UUID;
public abstract class LibraryItem
{
    private final UUID itemId;
    private String title;
    private int yearPublished;

    private boolean isBorrowed;
    public abstract double calculateLateFee(int daysPastDue);

    public LibraryItem(String title, int yearPublished)
    {
        this.title = title;
        this.yearPublished = yearPublished;
        this.itemId = UUID.randomUUID();
        this.isBorrowed = false;
    }

    public UUID getItemId()
    {
        return itemId;
    }
    public String getTitle()
    {
        return title;
    }
    public int getYearPublished()
    {
        return yearPublished;
    }

    public boolean isBorrowed()
    {
        return isBorrowed;
    }
    public void borrow()
    {
        if (!this.isBorrowed)
        {
            this.isBorrowed = true;
        }
    }

    public void returnItem()
    {
        this.isBorrowed = false;
    }
    @Override
    public String toString()
    {
        return "LibraryItem[" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", yearPublished=" + yearPublished +
                ", isBorrowed=" + isBorrowed +
                ']';
    }
}


