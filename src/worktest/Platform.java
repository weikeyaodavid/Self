package worktest;

public enum Platform {
    ANDROID(0),
    IOS(1),
    PAYFORT(2),
    PAYPAL(3),
    Onecard(4),
    Stripe(5),
    CASHU(6);

    private int platform;

    Platform(int platform) {
        this.platform = platform;
    }

    public int getPlatform() {
        return platform;
    }
}