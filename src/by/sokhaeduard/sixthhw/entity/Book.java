package by.sokhaeduard.sixthhw.entity;

import by.sokhaeduard.sixthhw.util.IdGenerator;

public class Book {

    private String id;
    private String title;
    private String authors;
    private int numberPages;
    private String typography;

    public Book(String title, String authors,
                      int numberPages, String typography) {
        this.id = IdGenerator.generateId();
        this.title = title;
        this.authors = authors;
        this.numberPages = numberPages;
        this.typography = typography;
    }

    public Book(String id, String title, String authors,
                      int numberPages, String typography) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.numberPages = numberPages;
        this.typography = typography;
    }

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return authors;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public String getTypography() {
		return typography;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}