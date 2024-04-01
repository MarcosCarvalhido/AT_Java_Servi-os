package com.sparkweb.sparkweb.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoControllerTest {

    @BeforeEach
    void setUp() throws IOException {
        String path = "http://127.0.0.1:4567/produto";
        String message = "{\"nome\" : \"Lanterna Vermelho\"}" ;

        System.out.println(message);
        try {
            URL url = new URL(path);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type","application/json");
            connection.setDoOutput(true);

            DataOutputStream out =
                    new DataOutputStream(connection.getOutputStream());
            out.writeBytes(message);
            out.flush();
            out.close();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if ( responseCode != HttpURLConnection.HTTP_CREATED){
                System.out.println("Aconteceu algum erro inesperado");
                System.out.println(connection.getResponseMessage());
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while ( ( line = in.readLine())!= null){
                System.out.println(line);
            }
            in.close();
        }catch( MalformedURLException mfu){
            mfu.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void testeDelete () throws IOException {
        URL url = new URL ("http://127.0.0.1:4567/produto/1");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Content-type","application/json");
        connection.setDoOutput(true);
        String message = "{\"id\" : \"1\"}" ;
        DataOutputStream out =
                new DataOutputStream(connection.getOutputStream());
        out.writeBytes(message);
        out.flush();
        out.close();
        BufferedReader in =
                new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        String result= "";
        while ((line = in.readLine()) != null) {
            result = result + line;
        }
        System.out.println(result);
        in.close();
        int responseCode = connection.getResponseCode();

        assertEquals(200, responseCode);
    }

    @Test
    public void testeAtualizacao () throws IOException {
        String path = "http://127.0.0.1:4567/produto";
        String message = "{\"id\" : \"1\", \"nome\" : \"Lanterna amarela\"}" ;

        System.out.println(message);
        try {
            URL url = new URL(path);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-type","application/json");
            connection.setDoOutput(true);

            DataOutputStream out =
                    new DataOutputStream(connection.getOutputStream());
            out.writeBytes(message);
            out.flush();
            out.close();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if ( responseCode != HttpURLConnection.HTTP_CREATED){
                System.out.println("Aconteceu algum erro inesperado");
                System.out.println(connection.getResponseMessage());
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while ( ( line = in.readLine())!= null){
                System.out.println(line);
            }
            in.close();
        }catch( MalformedURLException mfu){
            mfu.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

        URL url = new URL ("http://127.0.0.1:4567/produtos");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        ObjectMapper objMapper = new ObjectMapper();
        BufferedReader in =
                new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        String result= "";
        while ((line = in.readLine()) != null) {
            result = result + line;
        }
        System.out.println(result);
        in.close();
        int responseCode = connection.getResponseCode();

        assertEquals(200, responseCode);
    }
}