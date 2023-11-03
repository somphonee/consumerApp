package co.th.priorsolusion.marketplace.consummerapp.component.kafka.config;
import co.th.priorsolusion.marketplace.common.model.MarketplaceModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@Configuration
@EnableKafka
public class KafkaConsumerConfiguration {
    @Value("${kafka.server}")
    private String server;
   @Value("${kafka.groupid.regist}")
   private  String groupId;
    @Value("${kafka.offset-reset}")
    private String kafkaOffsetReset;
    @Bean
    public Map<String, Object> settingConsumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaOffsetReset);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class); // Use ErrorHandlingDeserializer for value deserialization
        return props;
    }

    @Bean
    public ConsumerFactory<String, MarketplaceModel> generateConsumerFactory() {
        JsonDeserializer<MarketplaceModel> jsonDeserializer = new JsonDeserializer<>(MarketplaceModel.class);
        jsonDeserializer.setRemoveTypeHeaders(false);
        jsonDeserializer.addTrustedPackages("*"); // Allow deserialization for all packages
        ErrorHandlingDeserializer<MarketplaceModel> errorHandlingDeserializer = new ErrorHandlingDeserializer<>(jsonDeserializer);
        return new DefaultKafkaConsumerFactory<>(
                settingConsumerConfigs(),
                new StringDeserializer(),
                errorHandlingDeserializer // Use ErrorHandlingDeserializer for deserialization
        );

    }
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, MarketplaceModel>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MarketplaceModel> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(generateConsumerFactory());
        return factory;
    }


}
