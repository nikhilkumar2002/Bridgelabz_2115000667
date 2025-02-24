class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature. Use newFeature() instead.");
    }

    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class TestDeprecated {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
