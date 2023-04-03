package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.analitic.AnalyticService;
import org.example.analitic.AnalyticServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;
import static org.example.Purchase.parsePurchase;


public class Main {


    public static void main(String[] args) {
        UserData userData = new UserData();


        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            out.println("Сервер запущен");// стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream())
                ) {
                    System.out.println("Клиент подключился");
                    String answer = in.readLine();
                    Purchase purchase = parsePurchase(answer); //получем сообщение от клиента и распарсим его в объект
                    System.out.println(purchase.toString());
                    userData.addToData(purchase);

                    analyze(userData, purchase);

                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    String obj = gson.toJson(userData.getStatistic());

                    out.write(obj + "\n");
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

    public static void analyze(UserData userData, Purchase purchase) {
        AnalyticService analyticService = new AnalyticServiceImpl();
        userData.setMaxCategory(analyticService.searchMaxCategory(userData));
    }




}