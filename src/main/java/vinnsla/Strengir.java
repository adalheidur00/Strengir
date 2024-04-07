package vinnsla;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Vinnsluklasi fyrir strengi
 *
 *****************************************************************************/

public class Strengir {
    private String texti;
    private char stafur;

    public Strengir() {

    }

    /**
     * setur texta í vinnsluhlutann
     *
     * @param texti texti
     */
    public void setTexti(String texti) {
        this.texti = texti;
    }

    public void setStafur(char stafur){
        this.stafur = stafur;
    }

    /**
     * Leitar að leitarord í textanum og skilar staðsetningu leitarorðsins
     *
     * @param leitarord leitarorðið
     * @return staðsetningu ef leitarorðið finnst en annars -1
     * @throws NullPointerException undantekning ef texti er null
     */
    public int leita(String leitarord) throws NullPointerException {
        if (texti == null) {
            throw new NullPointerException();
        } else {
            return texti.indexOf(leitarord);
        }
    }

    /**
     * telur fjölda orða í texti og skilar fjöldanum.
     *
     * @return fjöldi orða
     * @throws NullPointerException undantekning ef texti er null
     */
    public int fjoldiOrda() throws NullPointerException {
        if (texti == null) {
            throw new NullPointerException();
        } else {
            return texti.split(" ").length;
        }

    }

    public int fjoldiStafa() {
        if (texti == null) {
            return 0;
        }
        int teljari = 0;
        for(int i = 0;i < texti.length(); i++){
            if(texti.charAt(i) == stafur){
                teljari++;
            }
        }

        return teljari;
    }
}
