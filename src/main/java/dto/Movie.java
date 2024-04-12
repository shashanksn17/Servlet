package dto;

import javax.annotation.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class Movie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String name;
 private String genre;
 private String language;
 private double rating;
 @Lob
 private byte[] image;
//public String getName() {
//	return name;
//}
//public void setName(String name) {
//	this.name = name;
//}
//public String getGenre() {
//	return genre;
//}
//public void setGenre(String genre) {
//	this.genre = genre;
//}
//public double getRating() {
//	return rating;
//}
//public void setRating(double rating) {
//	this.rating = rating;
//}
//public byte[] getImage() {
//	return image;
//}
//public void setImage(byte[] image) {
//	this.image = image;
}
