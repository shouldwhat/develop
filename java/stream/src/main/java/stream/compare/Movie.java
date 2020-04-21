package stream.compare;

public class Movie {

	private String name;
	private double rating;
	private boolean startted;
	
	@Override
	public String toString() {
		return "Movie [name=" + name + ", rating=" + rating + ", startted=" + startted + "]";
	}
	public Movie(String name, double rating, boolean startted) {
		this.setName(name);
		this.setRating(rating);
		this.setStartted(startted);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public boolean isStartted() {
		return startted;
	}
	public void setStartted(boolean startted) {
		this.startted = startted;
	}
}
