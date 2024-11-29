class Journal extends PrintedMaterial {
    public Journal(String title, int year) {
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
}