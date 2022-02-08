package net.services.registration.moviemodel;


public class Movie {
    protected int id;
    protected String movieTitle;
    protected String movieDescr;
    protected String movieViews;
    protected String movieGenre;



    public Movie() {}

    public Movie(String movieTitle, String movieDescr, String movieViews, String movieGenre) {
        super();
        this.movieTitle = movieTitle;
        this.movieDescr = movieDescr;
        this.movieViews = movieViews;
        this.movieGenre=movieGenre;
    }
    public Movie(int id,String movieTitle, String movieDescr, String movieViews, String movieGenre) {
        super();
        this.movieTitle = movieTitle;
        this.movieDescr = movieDescr;
        this.movieViews = movieViews;
        this.movieGenre = movieGenre;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieDescr() {
		return movieDescr;
	}

	public void setMovieDescr(String movieDescr) {
		this.movieDescr = movieDescr;
	}

	public String getMovieViews() {
		return movieViews;
	}

	public void setMovieViews(String movieViews) {
		this.movieViews = movieViews;
	}


	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

 
   
}