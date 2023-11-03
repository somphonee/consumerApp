package co.th.priorsolusion.marketplace.consummerapp.service;

import co.th.priorsolusion.marketplace.common.model.NotificationModel;
import co.th.priorsolusion.marketplace.common.model.ResponseModel;
import co.th.priorsolusion.marketplace.consummerapp.reporsitrory.impl.NotificationRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepositoryImpl notificationRepository;

    public NotificationService(NotificationRepositoryImpl notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
    public ResponseModel<List<NotificationModel>> getAllNewNotification() {
        ResponseModel<List<NotificationModel>> responseModel = new ResponseModel<>();
        responseModel.setStatus(200);
        responseModel.setDescription("ok");
        try {
            List<NotificationModel> notificationModelsList = notificationRepository.getAllNewNotification();

            if(notificationModelsList.size()>0){
                for(NotificationModel notificationModel: notificationModelsList)
                {
                    this.notificationRepository.update(notificationModel.getId());
                }
            }
            responseModel.setData(notificationModelsList);
        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while fetching buyers: " + e.getMessage());
        }
        return responseModel;
    }
    public ResponseModel<List<NotificationModel>> getAllNotifications() {
        ResponseModel<List<NotificationModel>> responseModel = new ResponseModel<>();

        try {
            List<NotificationModel> notificationModels = notificationRepository.getAllNotifications();
            responseModel.setStatus(200);
            responseModel.setData(notificationModels);
        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while fetching notifications: " + e.getMessage());
        }
        return responseModel;
    }
}
