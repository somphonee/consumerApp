package co.th.priorsolusion.marketplace.consummerapp.component.kafka.component;
import co.th.priorsolusion.marketplace.common.model.MarketplaceModel;
import co.th.priorsolusion.marketplace.consummerapp.reporsitrory.impl.NotificationRepositoryImpl;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class KafkaConsumerComponent {
    private  final NotificationRepositoryImpl notificationRepository;

    public KafkaConsumerComponent(NotificationRepositoryImpl notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @KafkaListener(topics = "${kafka.topics.regist}", groupId = "${kafka.groupid.regist}")
    public void consumeNotification(@Payload MarketplaceModel marketplaceModel) {
        try {
            this.notificationRepository.insertNoti(marketplaceModel);
           log.info(">>>>>>>>>>>>>>{}>>>>>>>>>>>",marketplaceModel);




            //log.error("Deserialization error: {}", e.getMessage(), e);
        } catch (Exception e) {

            // log.error("Error processing message: {}", e.getMessage(), e);
        }
    }
}
