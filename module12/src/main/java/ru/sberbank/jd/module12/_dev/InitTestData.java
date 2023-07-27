package ru.sberbank.jd.module12._dev;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ru.sberbank.jd.module12.entity.Client;
import ru.sberbank.jd.module12.entity.Item;
import ru.sberbank.jd.module12.entity.Order;
import ru.sberbank.jd.module12.repository.ClientRepository;
import ru.sberbank.jd.module12.repository.ItemRepository;
import ru.sberbank.jd.module12.repository.OrderRepository;

@Configuration
@AllArgsConstructor
@Slf4j
public class InitTestData {

    private ClientRepository clientRepository;
    private ItemRepository itemRepository;
    private OrderRepository orderRepository;

    @Autowired
    public void initData() {
        Client client = new Client();
        clientRepository.save(client);

        Order order = new Order();
        order.setClient(client);
        orderRepository.save(order);

        Item item = new Item();
        item.setName("Sneakers Adidas");
        item.setArticle("002");
        item.setOrder(order);

        itemRepository.save(item);
        orderRepository.findAll().stream().forEach(it -> log.info("{}", it.getClient()));

    }
}
