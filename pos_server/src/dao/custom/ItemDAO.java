package dao.custom;

import dao.SuperDAO;
import entity.ItemEntity;

public interface ItemDAO extends SuperDAO {
    ItemEntity getItem(String itemId);
}
