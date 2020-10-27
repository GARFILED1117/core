package hello.core.order;

public interface OrderService {
    Order order(Long memberId, String itemName, int itemPrice);
}
