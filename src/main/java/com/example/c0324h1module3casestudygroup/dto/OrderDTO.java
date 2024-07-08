package com.example.c0324h1module3casestudygroup.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private int idOrder;
    private Date dateOrder;
    private String status;
    private List<OrderProductDTO> orderProductDTOS;

    public OrderDTO(int idOrder, Date dateOrder, String status) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.status = status;
    }

    public List<OrderProductDTO> getOrderProductDTOS() {
        return orderProductDTOS;
    }

    public void setOrderProductDTOS(List<OrderProductDTO> orderProductDTOS) {
        this.orderProductDTOS = orderProductDTOS;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
