package projects;

public class Songs {

    String title;
    double duration;

    public Songs(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }
    public Songs() {

    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
