package co.th.priorsolusion.marketplace.consummerapp.controller.rest;
import co.th.priorsolusion.marketplace.common.model.NotificationModel;
import co.th.priorsolusion.marketplace.common.model.ResponseModel;
import co.th.priorsolusion.marketplace.consummerapp.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class NotificationRestController {
    private  final NotificationService notificationService;

    public NotificationRestController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @GetMapping("/getAllNewNotification")
    public ResponseModel<List<NotificationModel>> getAllItem(){
        return  this.notificationService.getAllNewNotification();
    }

    @GetMapping("/allNotification")
    public ResponseModel<List<co.th.priorsolusion.marketplace.common.model.NotificationModel>> getAllNotifications() {
        return this.notificationService.getAllNotifications();
    }



}
