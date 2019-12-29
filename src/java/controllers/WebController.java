/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entity.Buyer;
import entity.History;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessions.BuyerFacade;
import sessions.HistoryFacade;
import sessions.ProductFacade;

/**
 *
 * @author LARISSA
 */
@WebServlet(name = "WebController", urlPatterns = {
    "/showLogin",
    "/login",
    "/newProduct",
    "/addProduct",
    "/listProducts",
    "/newBuyer",
    "/addBuyer",
    "/listBuyers",
    "/showTakeOnProduct",
    "/takeOnProduct",
   })
public class WebController extends HttpServlet {

    @EJB
    ProductFacade productFacade;
    @EJB
    BuyerFacade buyerFacade;
    @EJB
    HistoryFacade historyFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        switch (path) {
            case "/showLogin":
                request.getRequestDispatcher("/WEB-INF/showLogin.jsp").forward(request, response);
                break;
            case "/login":
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                if ("Larissa".equals(login) && "123123".equals(password)) {
                    request.setAttribute("info", "Привет, " + login + "!");
                } else {
                    request.setAttribute("info", "Неправильный логин или пароль");
                }
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/newProduct":
                request.getRequestDispatcher("/WEB-INF/newProduct.jsp").forward(request, response);
                break;
            case "/addProduct":
                String title = request.getParameter("title");
                String model = request.getParameter("model");
                String price = request.getParameter("price");
                String quantity = request.getParameter("quantity");
                String count = request.getParameter("count");
                Product product = new Product(title, model, Integer.parseInt(price), Integer.parseInt(quantity), Integer.parseInt(count));
                productFacade.create(product);
                request.setAttribute("info", "Машина создана");
                request.setAttribute("product", product);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listProducts":
                List<Product> listProducts = productFacade.findAll();
                request.setAttribute("listProducts", listProducts);
                request.getRequestDispatcher("/listProducts.jsp").forward(request, response);
                break;
            case "/newBuyer":
                request.getRequestDispatcher("/WEB-INF/newBuyer.jsp").forward(request, response);
                break;
            case "/addBuyer":
                String name = request.getParameter("name");
                String lastname = request.getParameter("lastname");
                String email = request.getParameter("email");
                String money = request.getParameter("money");
                Buyer buyer = new Buyer(name, lastname, email, Integer.parseInt(money));
                buyerFacade.create(buyer);
                request.setAttribute("info", "Покупатель создан");
                request.setAttribute("buyer", buyer);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listBuyers":
                List<Buyer> listBuyers = buyerFacade.findAll();
                request.setAttribute("listBuyers", listBuyers);
                request.getRequestDispatcher("/listBuyers.jsp").forward(request, response);
                break;
            case "/showTakeOnProduct":
                listProducts = productFacade.findAll();
                listBuyers = buyerFacade.findAll();
                request.setAttribute("listProducts", listProducts);
                request.setAttribute("listBuyers", listBuyers);
                request.getRequestDispatcher("/WEB-INF/showTakeOnProduct.jsp").forward(request, response);
                break;
            case "/takeOnProduct":
                String productId = request.getParameter("productId");
                String buyerId = request.getParameter("buyerId");
                product = productFacade.find(Long.parseLong(productId));
                buyer = buyerFacade.find(Long.parseLong(buyerId));
                History history = new History();
                history.setProduct(product);
                history.setBuyer(buyer);
                history.setTakeOn(new Date());
              
                historyFacade.create(history);
                request.setAttribute("info",
                        "Машина \""
                        + product.getTitle()
                        + "\" продана покупателю : "
                        + buyer.getName()
                        + " " + buyer.getLastname()
                );
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
           
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
