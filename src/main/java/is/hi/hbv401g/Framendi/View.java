package is.hi.hbv401g.Framendi;


public enum View {
    OPNA("/is.hi.hbvg401g.Framendi/Forsida.fxml"),
    DETAIL("/is.hi.hbvg401g.Framendi/passenger.fxml"),
    FLIGHT("/is.hi.hbvg401g.Framendi/Flights.fxml"),
    RETURN("/is.hi.hbvg401g.Framendi/ReturnFlight.fxml"),
    FINALRETURN("/is.hi.hbvg401g.Framendi/FinalReturn.fxml"),
    FINALONEWAY("/is.hi.hbvg401g.Framendi/FinalOneWay.fxml");


    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
