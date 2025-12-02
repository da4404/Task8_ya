package com.example.task8_ya;

public class Magazine extends LibraryItem implements Searchable, Displayable
{
    private int issueNumber;
    private String editorName;

    public Magazine(String title, int yearPublished, int issueNumber, String editorName)
    {
        super(title, yearPublished);
        this.issueNumber = issueNumber;
        this.editorName = editorName;
    }
    public int getIssueNumber()
    {
        return issueNumber;
    }
    public String getEditorName()
    {
        return editorName;
    }
    @Override
    public double calculateLateFee(int daysPastDue)
    {
        return daysPastDue * 2.0;
    }
    @Override
    public boolean matches(String query)
    {
        if (query == null || query.isEmpty())
        {
            return false;
        }


        return getTitle().equals(query) || getEditorName().equals(query);
    }


    @Override
    public void displayFullDetails() {
        System.out.println("Magazine Details");
        System.out.println(super.toString());
        System.out.println("Issue Number: " + this.issueNumber);
        System.out.println("Editor: " + this.editorName);
    }
}