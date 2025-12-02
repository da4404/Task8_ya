package com.example.task8_ya;


public class Book extends LibraryItem implements Searchable, Displayable {

    private String author;
    private int numOfPages;

    public Book(String title, int yearPublished, String author, int numOfPages)
    {
        super(title, yearPublished);
        this.author = author;
        this.numOfPages = numOfPages;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getNumOfPages()
    {
        return numOfPages;
    }

    @Override
    public double calculateLateFee(int daysPastDue)
    {
        return daysPastDue * 0.5;
    }

    @Override
    public boolean matches(String query)
    {
        if (query == null || query.isEmpty())
        {
            return false;
        }
        return this.getAuthor().equals(query) || this.getTitle().equals(query);
    }
    @Override
    public void displayFullDetails()
    {
        System.out.println(super.toString());
        System.out.println("Author: " + this.author);
        System.out.println("Number of Pages: " + this.numOfPages);
    }
}
