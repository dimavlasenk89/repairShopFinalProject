package model.entity;

import java.io.Serializable;
import java.util.Objects;

public class Orders implements Serializable {
    private boolean isInDevelopment;
    private boolean isDone;
    private boolean isPaid;
    private boolean isWaitingForPayment;
    private boolean isCanceled;
    private boolean isCheckEngine;
    private boolean isCheckElectricity;
    private boolean isCheckWheels;
    private int id;
    private int ordersPrice;
    private String CustomerLogin;
    private String MasterLogin;
    private String createdAt;
    private String carType;
    private String masterReference;



    public Orders() {
    }

    public String getMasterReference() {
        return masterReference;
    }

    public void setMasterReference(String masterReference) {
        this.masterReference = masterReference;
    }

    public boolean isInDevelopment() {
        return isInDevelopment;
    }

    public void setInDevelopment(boolean inDevelopment) {
        isInDevelopment = inDevelopment;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isWaitingForPayment() {
        return isWaitingForPayment;
    }

    public void setWaitingForPayment(boolean waitingForPayment) {
        isWaitingForPayment = waitingForPayment;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public boolean isCheckEngine() {
        return isCheckEngine;
    }

    public void setCheckEngine(boolean checkEngine) {
        isCheckEngine = checkEngine;
    }

    public boolean isCheckElectricity() {
        return isCheckElectricity;
    }

    public void setCheckElectricity(boolean checkElectricity) {
        isCheckElectricity = checkElectricity;
    }

    public boolean isCheckWheels() {
        return isCheckWheels;
    }

    public void setCheckWheels(boolean checkWheels) {
        isCheckWheels = checkWheels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdersPrice() {
        return ordersPrice;
    }

    public void setOrdersPrice(int ordersPrice) {
        this.ordersPrice = ordersPrice;
    }

    public String getCustomerLogin() {
        return CustomerLogin;
    }

    public void setCustomerLogin(String customerLogin) {
        CustomerLogin = customerLogin;
    }

    public String getMasterLogin() {
        return MasterLogin;
    }

    public void setMasterLogin(String masterLogin) {
        MasterLogin = masterLogin;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Orders(boolean isInDevelopment, boolean isDone, boolean isPaid, boolean isWaitingForPayment, boolean isCanceled, boolean isCheckEngine, boolean isCheckElectricity, boolean isCheckWheels, int id, int ordersPrice, String customerLogin, String masterLogin, String createdAt, String carType, String masterReference) {
        this.isInDevelopment = isInDevelopment;
        this.isDone = isDone;
        this.isPaid = isPaid;
        this.isWaitingForPayment = isWaitingForPayment;
        this.isCanceled = isCanceled;
        this.isCheckEngine = isCheckEngine;
        this.isCheckElectricity = isCheckElectricity;
        this.isCheckWheels = isCheckWheels;
        this.id = id;
        this.ordersPrice = ordersPrice;
        CustomerLogin = customerLogin;
        MasterLogin = masterLogin;
        this.createdAt = createdAt;
        this.carType = carType;
        this.masterReference = masterReference;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "isInDevelopment=" + isInDevelopment +
                ", isDone=" + isDone +
                ", isPaid=" + isPaid +
                ", isWaitingForPayment=" + isWaitingForPayment +
                ", isCanceled=" + isCanceled +
                ", isCheckEngine=" + isCheckEngine +
                ", isCheckElectricity=" + isCheckElectricity +
                ", isCheckWheels=" + isCheckWheels +
                ", id=" + id +
                ", ordersPrice=" + ordersPrice +
                ", CustomerLogin='" + CustomerLogin + '\'' +
                ", MasterLogin='" + MasterLogin + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", carType='" + carType + '\'' +
                ", masterReference='" + masterReference + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return isInDevelopment == orders.isInDevelopment && isDone == orders.isDone && isPaid == orders.isPaid && isWaitingForPayment == orders.isWaitingForPayment && isCanceled == orders.isCanceled && isCheckEngine == orders.isCheckEngine && isCheckElectricity == orders.isCheckElectricity && isCheckWheels == orders.isCheckWheels && id == orders.id && ordersPrice == orders.ordersPrice && CustomerLogin.equals(orders.CustomerLogin) && Objects.equals(MasterLogin, orders.MasterLogin) && createdAt.equals(orders.createdAt) && Objects.equals(carType, orders.carType) && Objects.equals(masterReference, orders.masterReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isInDevelopment, isDone, isPaid, isWaitingForPayment, isCanceled, isCheckEngine, isCheckElectricity, isCheckWheels, id, ordersPrice, CustomerLogin, MasterLogin, createdAt, carType, masterReference);
    }
}
