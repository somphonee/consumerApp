package co.th.priorsolusion.marketplace.consummerapp.reporsitrory;

import co.th.priorsolusion.marketplace.common.model.MarketplaceModel;
import co.th.priorsolusion.marketplace.common.model.NotificationModel;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository {



    public void insertNoti (MarketplaceModel marketplaceModel);
    public List<NotificationModel> getAllNewNotification();
    public  void update(int id);
}
