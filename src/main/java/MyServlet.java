import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet("/hello")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
//        super.init();
        emf = Persistence.createEntityManagerFactory("myPU");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Employee e", Board.class);
        List<Board> PostList = query.getResultList();

        em.getTransaction().commit();

        em.close();

        req.setAttribute("PostList", PostList);

        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String WRITER = request.getParameter("WRITER");
        String WRITING = request.getParameter("WRITING");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Board Poster = new Board(WRITER, WRITING);
        em.persist(Poster);

        em.getTransaction().commit();

        em.close();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("Posting is Done!");

    }

    @Override
    public void destroy() {
        emf.close();
    }
}