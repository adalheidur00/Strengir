package vidmot;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import vinnsla.Ordalisti;
import vinnsla.Strengir;

public class StrengirController {

    // fastar
    public static final String EKKI_FUNDID = "ekki fundið";
    public static final String ENGINN_TEXTI = "enginn-texti";
    public static final String OF_MARGIR = "of-margir";
    public static final String LEITARORD = "leitarord";
    public static final String TEXTI = "texti";

    // Notendaviðmóts tilviksbreytur
    @FXML
    private TextField fxLeitarord;   //Leitarorð
    @FXML
    private TextField fxStafur;     //Stafur
    @FXML
    private TextArea fxTexti;       //Texti sem notandi slær inn
    @FXML
    private Label fxFjoldiOrda;      // úttak fyrir fjölda orða
    @FXML
    private Label fxFjoldiStafa;
    @FXML
    private Label fxStadsetning;     // úttak fyrir staðsetningu leitarorðs

    // Vinnsluhlutur
    private final Strengir strengir = new Strengir();

    // aðferðir fyrir aðgerðir í notendaviðmóti

    public void initialize() {
        if (!Ordalisti.ordaListi.isEmpty()) {
            fxTexti.setText(String.join(" ", Ordalisti.ordaListi));
            strengir.setTexti(fxTexti.getText());
        }
    }

    /**
     * Leitar að orði og setur staðsetninguna í staðsetningarviðmótshlut
     * Ef orðið fannst ekki er skrifað ekki fundið í staðsetningarviðmótshlutinn
     * Ef leitarorðið er af lengd 0 verður leitarglugginn rauður
     * Ef textinn er null verður textglugginn rauður
     *
     * @param actionEvent ónotað
     */
    @FXML
    public void onLeit(ActionEvent actionEvent) {
        if (fxLeitarord.getText().isEmpty()) {
            Alert a =  ekkertLeitarOrdAlert();
            a.showAndWait();
        }
        try {
            int n = strengir.leita(fxLeitarord.getText());
            if (n >= 0) {
                fxStadsetning.setText(n + "");
            } else {
                fxStadsetning.setText(EKKI_FUNDID);
            }
        } catch (NullPointerException e) {
            fxTexti.getStyleClass().add(ENGINN_TEXTI);
        }
    }

    /**
     * Telur fjölda orða í textanum og setur í fjölda orða viðmótshlutinn
     * Ef textinn er null verður textglugginn rauður
     *
     * @param actionEvent ónotað
     */
    @FXML
    public void onTeljaOrd(ActionEvent actionEvent) {
        try {
            fxFjoldiOrda.setText(strengir.fjoldiOrda() + "");
        } catch (NullPointerException e) {
            fxTexti.getStyleClass().add(ENGINN_TEXTI);
        }
    }

    @FXML
    public void onTeljaStaf(ActionEvent actionEvent){
        try {
            String stafur = fxStafur.getText();
            if(stafur.length() != 1){
                fxStafur.getStyleClass().add(OF_MARGIR);
            } else {
                fxStafur.getStyleClass().remove(OF_MARGIR);
                strengir.setStafur(fxStafur.getText().charAt(0));
                fxFjoldiStafa.setText(strengir.fjoldiStafa() + "");
            }
        }catch (NullPointerException e){
            fxStafur.getStyleClass().add(ENGINN_TEXTI);
        }
    }

    /**
     * Vistar textann í vinnsluhlut
     * ramminn verður grár
     *
     * @param actionEvent ónotað
     */
    @FXML
    public void onVistaTexta(ActionEvent actionEvent) {
        String text = fxTexti.getText();
        if(text.length() > 100){
            Alert a = ofMargirStafirAlert();
            a.showAndWait();
        } else if (text.matches(".*\\d.*")) {
            Alert b = engirTolustafirAlert();
            b.showAndWait();
        } else {
            fxTexti.getStyleClass().add(TEXTI);
            strengir.setTexti(fxTexti.getText());

        }
    }

    /**
     * Ef notandi skrifar af lyklaborði í texta hlut (textinn eða leitarorð) þá verður ramminn grár
     *
     * @param keyEvent viðmótshlutur sem er TextField
     */
    @FXML
    public void onSkrifa(KeyEvent keyEvent) {
        // ef það væru fleiri en einn TextField en einnig má setja beint á fxLeitarord
        ((TextField) keyEvent.getSource()).getStyleClass().add(LEITARORD);
    }

    /**
     * Setur strenginn í orðalistann og færir notandann yfir í nýja senu
     * @param actionEvent ónotað
     */
    public void onNanar(ActionEvent actionEvent){
        Ordalisti.setStrengir(strengir);
        ViewSwitcher.switchTo(View.NANAR);
    }

    /* Alert viðmótshlutir sem láta notanda vita ef einhverjar
     kröfur sem fá forritið til að virka eru ekki uppfylltar */

    private Alert ofMargirStafirAlert(){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Viðvörun");
        a.setHeaderText("Ekki skrifa meira en 100 stafi í texta gluggan");
        return a;
    }

    private Alert engirTolustafirAlert(){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Viðvörun");
        a.setHeaderText("Ekki skrifa tölustafi í texta gluggan");
        return a;
    }

    private Alert ekkertLeitarOrdAlert(){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Viðvörun");
        a.setHeaderText("Þú átt eftir að slá inn leitarorð");
        return a;
    }
}
