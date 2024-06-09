package org.example.gagrics_admin_app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class dashboardController {

    @FXML
    public TableColumn<TableData1,String> orderIdColumn;
    @FXML
    public TableColumn<TableData1,String> orderStatusColumn;
    @FXML
    public TableColumn<TableData1,Integer> qtyColumn;
    @FXML
    public TableColumn<TableData1,Integer> totalColumn;
    @FXML
    public TableColumn<TableData1,String> orderDateColumn;
    @FXML
    public TableColumn<TableData1,String> sellerEmailColumn;
    @FXML
    public TableColumn<TableData1,String> buyerEmailColumn;
    @FXML
    public TableView<TableData1> tb1;
    ArrayList<Order> orders;
    ObservableList<TableData1> observableList = FXCollections.observableArrayList();

    public void initialize(){
        callApi();
    }


    private void callApi() {
        Request request = new Request.Builder()
                .url("https://agriculture-server.onrender.com/api/v2/order/admin-all-orders")
                .get()
                .addHeader("Content-Type","application/json")
                .addHeader("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjAxM2JjZGIyYmZmNTNjNzBiMDk1YzkiLCJpYXQiOjE3MTc4MzU2MzgsImV4cCI6MTcxODQ0MDQzOH0.wk9KOhYt-Gos2OsQ7hDDlv-j7E6FrzAOL5M2fcEJ8Sg")
                .build();

        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("Failed to fetch data");
                callApi();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseBody = response.body().string();
                JSONObject jsonObject = new JSONObject(responseBody);
                System.out.println(responseBody);
                fillTableData(jsonObject);
            }
        });
    }

    private void fillTableData(JSONObject jsonObject) {
        orders = new ArrayList<>();

        ArrayList<JSONObject> ordersList;
        ordersList = new ArrayList<>();


        for (int i=0;i<jsonObject.getJSONArray("orders").length();i++){
            JSONObject obj = jsonObject.getJSONArray("orders").getJSONObject(i);
            ordersList.add(obj);
        }

        for (int i=0;i<ordersList.size();i++){
            Order order = new Order();
            order.setId(ordersList.get(i).getString("_id"));
            order.setShippingAddress(ordersList.get(i).getJSONObject("shippingAddress"));
            order.setUser(ordersList.get(i).getJSONObject("user"));
            order.setTotalPrice(ordersList.get(i).getInt("totalPrice"));
            order.setStatus(ordersList.get(i).getString("status"));
            order.setPaidAt(ordersList.get(i).getString("paidAt"));
            order.setCreatedAt(ordersList.get(i).getString("createdAt"));

            for(int j=0;j<ordersList.get(i).getJSONArray("cart").length();j++){
                order.setCartProduct(ordersList.get(i).getJSONArray("cart").getJSONObject(j));
                orders.add(order);
            }
        }

        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        orderStatusColumn.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        sellerEmailColumn.setCellValueFactory(new PropertyValueFactory<>("sellerEmail"));
        buyerEmailColumn.setCellValueFactory(new PropertyValueFactory<>("buyerEmail"));

        for(int i = 1; i<orders.size();i++){
            TableData1 td = new TableData1();
            td.setOrderId(orders.get(i).getId());
            td.setOrderStatus(orders.get(i).getStatus());
            td.setQty(orders.get(i).getCartProduct().getInt("qty"));
            td.setOrderDate(orders.get(i).getCreatedAt());
            td.setSellerEmail(orders.get(i).getCartProduct().getJSONObject("shop").getString("email"));
            td.setBuyerEmail(orders.get(i).getUser().getString("email"));
            observableList.add(td);
        }

        tb1.setItems(observableList);

    }



}
