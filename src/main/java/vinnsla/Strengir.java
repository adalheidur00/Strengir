package vinnsla;

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

    /**
     * setur staf í vinnsuhlutann
     * @param stafur stafur
     */
    public void setStafur(char stafur){
        this.stafur = stafur;
    }

    public String getTexti(){
        return texti;
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

    /**
     * telur fjölda stafa í textanum og skilar fjöldanum
     * @return fjöldi stafa
     */
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
