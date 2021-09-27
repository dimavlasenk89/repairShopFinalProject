import model.entity.Customer;
import org.junit.Test;
import org.junit.Assert;

public class CustomerTest {

@Test
 public void getIdTest() {
     Customer customer = new Customer();
     customer.setId(1);
    int expected = 1;
    int actual = customer.getId();
    Assert.assertEquals(expected, actual);
 }
    @Test
    public void getLoginTest() {
        Customer customer = new Customer();
        customer.setLogin("ivanov");
        String expected = "ivanov";
        String actual = customer.getLogin();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getPasswordTest() {
        Customer customer = new Customer();
        customer.setPassword("ivanov");
        String expected = "ivanov";
        String actual = customer.getPassword();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getBillTest() {
        Customer customer = new Customer();
        customer.setBill(100);
        int expected = 100;
        int actual = customer.getBill();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void toStringTest() {
        Customer customer = new Customer();
        customer.setId(100);
        customer.setBill(100);
        customer.setLogin("100");
        customer.setPassword("100");

        String cusToStr = "Customer{" +
                "id=?" + 100 + '?' +
                ", login='" + "100" + '\'' +
                ", password=." + "100" + '.' +
                ", bill=!" + 100 + '!' +
                '}';
        String expected = cusToStr;
        String actual = customer.toString();
        Assert.assertEquals(expected, actual);
    }
}
