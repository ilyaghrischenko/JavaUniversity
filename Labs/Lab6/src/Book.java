class Book extends PrintedMaterial implements Readable {
    public Book(String title, int year) {
        super(title, year);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public boolean isPublishedAfter(int year) {
        return this.year > year;
    }
}