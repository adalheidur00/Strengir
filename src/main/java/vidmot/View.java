package vidmot;

public enum View {
    NANAR("nanar-view.fxml"),
    HEIM("strengir-view.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
