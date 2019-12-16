import com.InvoiceService;
import com.InvoiceSummary;
import com.Rides;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_ShouldReturn_TOtalFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance=2.0;
        int time=5;
        double calculateFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25.0,calculateFare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_HsouldReturnMinFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance = 0.1;
        int time = 1;
        double result = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5,result,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldGive_ToatalFare() {
        InvoiceService invoiceService = new InvoiceService();
        Rides[] rides = {new Rides(2.0, 5),
                new Rides(0.1, 1)
                        };
        InvoiceSummary actualSummary = new InvoiceService().calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary,actualSummary);
    }

    @Test
    public void givenUserIdAndRides_ShouldGive_InvoiceSummary() {
        InvoiceService invoiceService = new InvoiceService();
        String userId="ANF";
        Rides[] rides = {new Rides(2.0, 5),
                new Rides(0.1, 1)
        };
        invoiceService.addRides(userId,rides);
        InvoiceSummary actualSummary = invoiceService.getSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary,actualSummary);
    }
}

