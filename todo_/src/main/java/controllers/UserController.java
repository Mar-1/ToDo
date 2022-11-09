package controllers;

import java.io.IOException;
import java.util.Base64;

import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;

import entities.User;
import repositories.TarefaRepository;
import repositories.UserRepository;

/**
 * Servlet para tratar dos dados das tarefas
 * Tem atividade assíncronas servindo como registro para requisições assíncronas
 */
@WebServlet(urlPatterns = {"/cadastro", "/usuario"})
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private UserRepository userRepository;

    @EJB
    private TarefaRepository tarefaRepository;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
    }

    /**
     * O GET é usado para logout de usuário ou para exibir a página de login
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        if (request.getServletPath().equals("/cadastro"))
            request.getRequestDispatcher("/WEB-INF/criar-conta.jsp").forward(request, response);  
        
        if (request.getServletPath().equals("/usuario"))
            request.getRequestDispatcher("/WEB-INF/usuario.jsp").forward(request, response); 
    }

    /**
     * O POST pode realizar o cadastro do usuário (se action=cadastro) ou fazer
     * login (caso contrário)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (action != null && (action.equals("cadastro") || action.equals("info"))) {
            String name = request.getParameter("name");
            String encodedString = null;

            try {
                User previousInfo = this.userRepository.findByEmail(email);

                if (action.equals("cadastro") && previousInfo != null) {
                    throw new Exception("Email já cadastrado!");
                } else if (action.equals("info") && encodedString == null) {
                    encodedString = previousInfo.getUsername();
                }

                String encriptedPassword = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt(12));
                User user = new User();

                this.userRepository.save(user);

                request.getSession().setAttribute("user", user);

            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
                this.doGet(request, response);
                return;
            }
        }

        try {
            User user = this.userRepository.findByEmail(email);

            if (!BCrypt.checkpw(password, user.getPassword()))
                throw new NoResultException("Email ou password não conferem");

            request.getSession().setAttribute("user", user);

    
        } catch (NoResultException nre) {
            request.setAttribute("message", "Usuário não encontrado ou senha incorreta!");
            this.doGet(request, response);
        }
    }
}