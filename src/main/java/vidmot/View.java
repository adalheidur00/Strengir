package vidmot;

public enum View {
    NANAR("nanar.fxml"),
    HEIM("strengir-view.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
