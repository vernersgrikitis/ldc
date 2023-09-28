package com.example.ldc.vehiclehistory;

import com.example.ldc.client.Client;
import com.example.ldc.vehicle.Vehicle;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "vehicle_history")
public class VehicleHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;
    private LocalDateTime startOfOwnership;
    private LocalDateTime endOfOwnership;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "previous_owner_id")
    private Client previousOwner;
    @ManyToOne
    @JoinColumn(name = "current_owner_id")
    private Client currentOwner;

    public VehicleHistory(LocalDateTime startOfOwnership, LocalDateTime endOfOwnership, Vehicle vehicle, Client previousOwner, Client currentOwner) {
        this.startOfOwnership = startOfOwnership;
        this.endOfOwnership = endOfOwnership;
        this.vehicle = vehicle;
        this.previousOwner = previousOwner;
        this.currentOwner = currentOwner;
    }

    public VehicleHistory() {
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public LocalDateTime getStartOfOwnership() {
        return startOfOwnership;
    }

    public void setStartOfOwnership(LocalDateTime startOfOwnership) {
        this.startOfOwnership = startOfOwnership;
    }

    public LocalDateTime getEndOfOwnership() {
        return endOfOwnership;
    }

    public void setEndOfOwnership(LocalDateTime endOfOwnership) {
        this.endOfOwnership = endOfOwnership;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getPreviousOwner() {
        return previousOwner;
    }

    public void setPreviousOwner(Client previousOwner) {
        this.previousOwner = previousOwner;
    }

    public Client getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(Client currentOwner) {
        this.currentOwner = currentOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleHistory history = (VehicleHistory) o;
        return Objects.equals(historyId, history.historyId) && Objects.equals(startOfOwnership, history.startOfOwnership) && Objects.equals(endOfOwnership, history.endOfOwnership) && Objects.equals(vehicle, history.vehicle) && Objects.equals(previousOwner, history.previousOwner) && Objects.equals(currentOwner, history.currentOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historyId, startOfOwnership, endOfOwnership, vehicle, previousOwner, currentOwner);
    }

    @Override
    public String toString() {
        return "VehicleHistory{" +
                "historyId=" + historyId +
                ", startOfOwnership=" + startOfOwnership +
                ", endOfOwnership=" + endOfOwnership +
                ", vehicle=" + vehicle +
                ", previousOwner=" + previousOwner +
                ", currentOwner=" + currentOwner +
                '}';
    }
}
