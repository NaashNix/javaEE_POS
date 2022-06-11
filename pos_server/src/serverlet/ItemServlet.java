package serverlet;


import bo.BoFactory;
import bo.custom.ItemBO;
import dto.ItemDTO;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/item")
public class ItemServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    public static DataSource ds;

    ItemBO itemBO = (ItemBO) BoFactory.getBO(BoFactory.BoTypes.ITEM);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Heres contineu
        ItemDTO requestedItem = itemBO.getItem(req.getParameter("requestedId"));
        System.out.println("getAll requestedID : "+req.getParameter("requestedId"));
        resp.setContentType("application/json");
        PrintWriter writer1 = resp.getWriter();
        if (requestedItem != null){
            System.out.println("Not NUll method revoked!");
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("id",requestedItem.getItemId());
            objectBuilder.add("itemName",requestedItem.getItemName());
            objectBuilder.add("mfd",(String.valueOf(requestedItem.getMfd())));
            objectBuilder.add("exd",(String.valueOf(requestedItem.getExd())));
            objectBuilder.add("unitPrice",(String.valueOf(requestedItem.getUnitPrice())));
            objectBuilder.add("batchNumber",(String.valueOf(requestedItem.getBatchNumber())));
            objectBuilder.add("inStock",(String.valueOf(requestedItem.getInStock())));


            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("STATUS",200);
            response.add("data",objectBuilder.build());
            response.add("message","Done");
//                        resp.setStatus(HttpServletResponse.SC_OK);
            writer1.print(response.build());
        }else{
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("STATUS",400);
            response.add("data","");
            response.add("message","Item not found!");
//                        resp.setStatus(HttpServletResponse.SC_OK);
            writer1.print(response.build());
        }

    }
}
