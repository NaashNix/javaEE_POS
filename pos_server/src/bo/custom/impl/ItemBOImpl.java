package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.ItemEntity;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDao(DAOFactory.DAOTypes.ITEM);

    @Override
    public ItemDTO getItem(String itemId) {
        ItemEntity item = itemDAO.getItem(itemId);
        if (item != null){
            return new ItemDTO(item.getItemId(),
                    item.getItemName(),
                    item.getUnitPrice(),
                    item.getInStock(),
                    item.getBatchNumber(),
                    item.getMfd(),
                    item.getExd());
        }
        return null;
    }
}
