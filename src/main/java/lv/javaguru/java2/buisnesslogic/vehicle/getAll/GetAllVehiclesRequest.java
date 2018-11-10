package lv.javaguru.java2.buisnesslogic.vehicle.getAll;

public class GetAllVehiclesRequest {

    private Long userId;

    public GetAllVehiclesRequest(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
