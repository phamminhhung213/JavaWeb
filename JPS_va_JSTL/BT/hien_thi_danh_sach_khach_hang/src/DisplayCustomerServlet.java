import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DisplayCustomerServlet")
public class DisplayCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truy vấn dữ liệu từ DB (Mô phỏng).
        List<Customer> list = DBUtils.queryCustomers();

        // Lưu dữ liệu vào thuộc tính 'listcustomer' của request.
        request.setAttribute("listcustomer", list);

        // Tạo đối tượng RequestDispatcher
        // để Forward (chuyển tiếp) yêu cầu tới/display_customer.jsp
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/display_customer.jsp");

        // Forward (Chuyển tiếp) yêu cầu, để hiển thị dữ liệu trên trang JSP.
        dispatcher.forward(request, response);
    }


}