package com.find.dao;

import com.find.application.Local;
import com.find.config.DatabaseConfig;

import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocalDao {

    //Create
    public void criarLocal(Local local) {
        String sql = "INSERT INTO Local(local) VALUES(?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, local.getNome());
            stm.setInt(2, local.getId_local());
            stm.executeUpdate();
            System.out.println("Local cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao criar local!" + e.getMessage());
        }
    }

    //Read
    public List<Local> listarLocal() {
        String sql = "SELECT * FROM local";
        List<Local> locais = new ArrayList<>();

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {

            while (rs.next()) {
                Local local = new Local();
                local.setNome(rs.getString("nome"));
                local.setId_local(rs.getInt("id_local"));

                locais.add(local);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar locais: " + e.getMessage());
        }

        return locais;
    }

    //Update
    public void atualizar_local(Local local) {
        String sql = "UPDATE Local SET local = ? WHERE id_local = ?";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, local.getNome());
            stm.setInt(2, local.getId_local());
            stm.executeUpdate();
            System.out.println("Local ataualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar local!" + e.getMessage());
        }
    }

    //Delete
    public void deletar_local(int id_local) {
        String sql = "DELETE FROM Local WHERE id+local = ?";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, id_local);
            stm.executeUpdate();
            System.out.println("Local deletado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao deletar local!" + e.getMessage());
        }
    }

}
