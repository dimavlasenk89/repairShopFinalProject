import model.entity.Orders;
import org.junit.Test;
import org.junit.Assert;

public class OrdersTest {
    @Test
    public void getIdTest() {
        Orders orders = new Orders();
        orders.setId(1);
        int expected = 1;
        int actual = orders.getId();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getCustomerLoginTest() {
        Orders orders = new Orders();
        orders.setCustomerLogin("ivanov");
        String expected = "ivanov";
        String actual = orders.getCustomerLogin();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getMasterLoginTest() {
        Orders orders = new Orders();
        orders.setMasterLogin("ivanov");
        String expected = "ivanov";
        String actual = orders.getMasterLogin();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getCreatedAtTest() {
        Orders orders = new Orders();
        orders.setCreatedAt("ivanov");
        String expected = "ivanov";
        String actual = orders.getCreatedAt();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getCarTypeTest() {
        Orders orders = new Orders();
        orders.setCarType("ivanov");
        String expected = "ivanov";
        String actual = orders.getCarType();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getOrdersPriceTest() {
        Orders orders = new Orders();
        orders.setOrdersPrice(100);
        int expected = 100;
        int actual = orders.getOrdersPrice();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void isInDevelopmentTest() {
        Orders orders = new Orders();
        orders.setInDevelopment(true);
        boolean actual = orders.isInDevelopment();
        Assert.assertEquals(true, actual);
    }
    @Test
    public void isDoneTest() {
        Orders orders = new Orders();
        orders.setDone(true);
        boolean actual = orders.isDone();
        Assert.assertEquals(true, actual);
    }
    @Test
    public void isPaidTest() {
        Orders orders = new Orders();
        orders.setPaid(true);
        boolean actual = orders.isPaid();
        Assert.assertEquals(true, actual);
    }
    @Test
    public void isWaitingForPaymentTest() {
        Orders orders = new Orders();
        orders.setWaitingForPayment(true);
        boolean actual = orders.isWaitingForPayment();
        Assert.assertEquals(true, actual);
    }
    @Test
    public void isCanceledTest() {
        Orders orders = new Orders();
        orders.setCanceled(true);
        boolean actual = orders.isCanceled();
        Assert.assertEquals(true, actual);
    }
    @Test
    public void isCheckEngineTest() {
        Orders orders = new Orders();
        orders.setCheckEngine(true);
        boolean actual = orders.isCheckEngine();
        Assert.assertEquals(true, actual);
    }
    @Test
    public void isCheckElectricityTest() {
        Orders orders = new Orders();
        orders.setCheckElectricity(true);
        boolean actual = orders.isCheckElectricity();
        Assert.assertEquals(true, actual);
    }
    @Test
    public void isCheckWheelsTest() {
        Orders orders = new Orders();
        orders.setCheckWheels(true);
        boolean actual = orders.isCheckWheels();
        Assert.assertEquals(true, actual);
    }
    @Test
    public void getMasterReferenceTest() {
        Orders orders = new Orders();
        orders.setMasterReference("ivanov");
        String expected = "ivanov";
        String actual = orders.getMasterReference();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void toStringTest() {
        Orders orders = new Orders();
        orders.setInDevelopment(true);
        orders.setDone(true);
        orders.setPaid(true);
        orders.setWaitingForPayment(true);
        orders.setCanceled(true);
        orders.setCheckEngine(true);
        orders.setCheckElectricity(true);
        orders.setCheckWheels(true);
        orders.setId(1);
        orders.setOrdersPrice(100);
        orders.setCustomerLogin("ivanov");
        orders.setMasterLogin("ivanov");
        orders.setCreatedAt("ivanov");
        orders.setCreatedAt("ivanov");
        orders.setCarType("ivanov");
        orders.setMasterReference("ivanov");
        String ordToStr = "Orders{" +
                "isInDevelopment=" + true +
                ", isDone=" + true +
                ", isPaid=" + true +
                ", isWaitingForPayment=" + true +
                ", isCanceled=" + true +
                ", isCheckEngine=" + true +
                ", isCheckElectricity=" + true +
                ", isCheckWheels=" + true +
                ", id=" + 1 +
                ", ordersPrice=" + 100 +
                ", CustomerLogin='" + "ivanov" + '\'' +
                ", MasterLogin='" + "ivanov" + '\'' +
                ", createdAt='" + "ivanov" + '\'' +
                ", carType='" + "ivanov" + '\'' +
                ", masterReference='" + "ivanov" + '\'' +
                '}';
        String expected = ordToStr;
        String actual = orders.toString();
        Assert.assertEquals(expected, actual);
    }
}
