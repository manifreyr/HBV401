package is.hi.hbv401g.Framendi;


public enum View {
    OPNA("/is.hi.hbvg401g.Framendi/Forsida.fxml"),
    DETAIL("/is.hi.hbvg401g.Framendi/passenger.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
