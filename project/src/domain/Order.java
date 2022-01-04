package domain;

public class Order {
    private int id;
    private String productName; //产品名称
    private String num; //订单编号
    private String date; //下单时间
    private String desc; //描述
    private int payType; //支付类型
    private int status; //支付状态
    private String userName; //下单用户

    public Order() {
    }

    public Order(int id, String num, String date, String desc, int payType, int status, String productName, String userName) {
        this.id = id;
        this.num = num;
        this.date = date;
        this.desc = desc;
        this.payType = payType;
        this.status = status;
        this.productName = productName;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
