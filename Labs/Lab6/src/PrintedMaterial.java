abstract class PrintedMaterial {
    protected String title;
    protected int year;

    public PrintedMaterial(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public abstract String getTitle();
    public abstract int getYear();
}