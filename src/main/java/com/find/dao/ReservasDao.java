package com.find.dao;

import com.find.application.Reservas;
import com.find.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservasDao {

    //Create
    public void criarReservas(Reservas reservas) {
        String sql = "INSERT INTO Reservas(reservas) VALUES(?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, reservas.getData_inicio());
            stm.setString(2, reservas.getData_fim());
            stm.setInt(3, reservas.getId_reservas());
            stm.executeUpdate();
            System.out.println("Reserva criada com sucesso!");

        }catch (Exception e) {
            System.out.println("Erro ao criar reserva!" + e.getMessage());
        }
    }

    //Read
    public List<Reservas> listarReservas() {
        List<Reservas> listaReservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {

            while (rs.next()) {
                Reservas reserva = new Reservas();
                reserva.setId_reservas(rs.getInt("id_reservas"));
                reserva.setData_inicio(rs.getString("data_inicio"));
                reserva.setData_fim(rs.getString("data_fim"));

                listaReservas.add(reserva);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar reservas: " + e.getMessage());
        }

        return listaReservas;
    }

    //Update
    public void atualizarReservas(Reservas reservas) {
        String sql = "UPDATE Reservas SET reservas = ? WHERE id_reservas = ?";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, reservas.getData_inicio());
            stm.setString(2, reservas.getData_fim());
            stm.setInt(3, reservas.getId_reservas());
            stm.executeUpdate();
            System.out.println("Reserva atualizada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar reserva!"  + e.getMessage());
        }
    }

    //Delete
    public void deletarReservas(int id_reservas) {
        String sql = "DELETE FROM Reservas WHERE id_reservas  = ?";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, id_reservas);
            stm.executeUpdate();
            System.out.println("Reserva deletada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao deletar reserva!" + e.getMessage());
        }
    }

}
