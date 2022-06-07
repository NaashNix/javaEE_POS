package bo.custom;

import bo.SuperBO;
import dto.ItemDTO;

public interface ItemBO extends SuperBO {
    ItemDTO getItem (String itemId);
}
