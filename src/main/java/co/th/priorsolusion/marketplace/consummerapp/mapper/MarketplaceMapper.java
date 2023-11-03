package co.th.priorsolusion.marketplace.consummerapp.mapper;

import co.th.priorsolusion.marketplace.common.model.MarketplaceModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarketplaceMapper implements RowMapper<MarketplaceModel> {
    @Override
    public MarketplaceModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        MarketplaceModel marketplaceModel = new MarketplaceModel();
        marketplaceModel.setId(rs.getInt("id"));
        marketplaceModel.setItemId(rs.getInt("itemId"));
        marketplaceModel.setItemName(rs.getString("itemName"));
        marketplaceModel.setPrice(rs.getInt("price"));
        marketplaceModel.setSellerId(rs.getInt("sellId"));
        marketplaceModel.setAdventureSell(rs.getString("adventureSell"));
        marketplaceModel.setBuyerId(rs.getInt("buyerId"));
        marketplaceModel.setAdventureBuyer(rs.getString("adventureBuyer"));
        marketplaceModel.setStatus(rs.getString("status"));
        marketplaceModel.setCreateDate(rs.getTimestamp("create_date"));
        marketplaceModel.setUpdatedDate(rs.getTimestamp("updated_at"));
        return marketplaceModel;
    }
}
