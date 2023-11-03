package co.th.priorsolusion.marketplace.consummerapp.mapper;
import co.th.priorsolusion.marketplace.common.model.NotificationModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationMapper implements RowMapper<NotificationModel> {
    @Override
    public NotificationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        NotificationModel notificationModel = new NotificationModel();
        notificationModel.setId(rs.getInt("id"));
        notificationModel.setTitle(rs.getString("titel"));
        notificationModel.setItemId(rs.getInt("itemId"));
        notificationModel.setItemName(rs.getString("itemName"));
        notificationModel.setSellerId(rs.getInt("sellerId"));
        notificationModel.setSellerName(rs.getString("sellerName"));
        notificationModel.setStatus(rs.getString("status"));
        notificationModel.setCreateDate(rs.getTimestamp("create_date"));
        notificationModel.setUpdatedDate(rs.getTimestamp("updated_at"));
        return notificationModel;

    }
}
