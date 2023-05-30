package bo;

import model.OrderDetailDTO;

import java.time.LocalDate;
import java.util.List;

public interface PlaceOrderBo {
    boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);
}
