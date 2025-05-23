/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    Statement st;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        try{
            conn = new conectaDAO().connectDB();
            st = conn.createStatement();
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar produto.");
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        try{
            conn = new conectaDAO().connectDB();
            st = conn.createStatement();
            rs = st.executeQuery("select * from produtos");
            while(rs.next()){
                    ProdutosDTO p = new ProdutosDTO();
                    p.setNome(rs.getString("nome"));
                    p.setValor(rs.getInt("valor"));
                    p.setStatus(rs.getString("status"));
                    p.setId(rs.getInt("id"));
                    listagem.add(p);
                    System.out.println("added "+ rs.getString("nome"));
            }
        }catch(SQLException e){System.out.println("SQL exception occured: "+e.getMessage());};
        return listagem;
    }
    
    
    
        
}

