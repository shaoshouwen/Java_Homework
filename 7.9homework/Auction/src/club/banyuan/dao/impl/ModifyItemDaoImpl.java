package club.banyuan.dao.impl;

import club.banyuan.dao.ModifyItemDao;
import club.banyuan.entity.Auction_item;

import java.sql.Connection;
import java.sql.ResultSet;

public class ModifyItemDaoImpl extends BaseDaoImpl implements ModifyItemDao {

    public ModifyItemDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {

        return null;
    }


    @Override
    public int modifyProduct(Auction_item auction_item) {
        String sql = "update aution_item set item_name=? , description = ? ,start_time = ? , end_time = ? , starting_price = ? , base_price = ? where id = ?";
        Object[] params = new Object[]{auction_item.getItem_name()
                , auction_item.getDescription(), auction_item.getStart_time(), auction_item.getEnd_time(), auction_item.getStarting_price(), auction_item.getBase_price(), auction_item.getId()};
        int i = executeUpdate(sql, params);
        return i;
    }

    @Override
    public int insertProduct(Auction_item auction_item) {
        String sql = "insert into aution_item values(null,?,?,?,?,?,?)";
        Object[] params = new Object[]{auction_item.getItem_name(),auction_item.getDescription(),auction_item.getStart_time(),auction_item.getEnd_time(),auction_item.getStarting_price(),auction_item.getBase_price()};
        int i = executeInsert(sql,params);
        return  i;
    }
}
