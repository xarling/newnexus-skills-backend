package nl.newnexus.skills.model;

/**
 * User: xanderarling
 * Date: 9/15/13
 * Time: 20:22
 */
public enum Geslacht {
    MAN("man"), VROUW("vrouw");

    private String geslacht;


    private Geslacht(final String geslacht) {
        this.geslacht = geslacht;
    }

    public Boolean isMan() {
        return "man".equals(geslacht);
    }

    public Boolean isVrouw() {
        return "vrouw".equals(geslacht);
    }
}
