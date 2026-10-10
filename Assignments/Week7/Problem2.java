
abstract class ArtPiece {
    private static int counter = 0;
    private final String pieceId;
    protected String title;

    ArtPiece(String title) {
        this.title = title;
        pieceId = "ART-" + (++counter);
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}

class Painting extends ArtPiece {
    Painting(String title) {
        super(title);
    }

    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    Sculpture(String title) {
        super(title);
    }

    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        Sculpture s = new Sculpture("The Thinker II");

        System.out.println(p.describe());
        System.out.println(p.getPieceId());

        System.out.println(s.describe());
        System.out.println(s.getPieceId());
    }
}
