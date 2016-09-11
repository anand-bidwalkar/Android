package com.example.xmlparsing;

public class Score 
{
 String title;
 String link;
 public Score() 
 {

}
public Score(String title, String link) {
	super();
	this.title = title;
	this.link = link;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return title;
	}
}
