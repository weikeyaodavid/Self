package worktest;

import java.sql.Timestamp;

public class TopupDO {
    private int id;
    private int userId;
    private int coins;
    private float price;
    private String currency;
    private String type;
    private String channel;
    private Timestamp createdOn;
    private String orderId;
    private String eventItemId;

    public TopupDO() {
    }

    public TopupDO(int id,
                   int userId,
                   int coins,
                   float price,
                   String currency,
                   String type,
                   String channel,
                   Timestamp createdOn,
                   String orderId) {
        this.id = id;
        this.userId = userId;
        this.coins = coins;
        this.price = price;
        this.currency = currency;
        this.type = type;
        this.channel = channel;
        this.createdOn = createdOn;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEventItemId() {
        return eventItemId;
    }

    public void setEventItemId(String eventItemId) {
        this.eventItemId = eventItemId;
    }

    public static TopupDO buildDefaultTopupDO(
            int userId,
            int coins,
            float price,
            String currency,
            Platform platform,
            String orderId,
            String eventItemId
    ) {
        TopupDO topupDO = new TopupDO();
        topupDO.setUserId(userId);
        topupDO.setCoins(coins);
        topupDO.setPrice(price);
        topupDO.setCurrency(currency);
        topupDO.setType(platform.name());
        topupDO.setCreatedOn(new Timestamp(System.currentTimeMillis()));
        topupDO.setOrderId(orderId);
        topupDO.setEventItemId(eventItemId);
        return topupDO;
    }
}
