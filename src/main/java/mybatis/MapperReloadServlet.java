package mybatis;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.Logger;

/**
 * @author tangxiaoshuang
 * @date 2018/4/25 15:01
 */

public class MapperReloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapperReloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init()throws ServletException
    {
        Logger logger = Logger.getLogger(this.getClass());
        logger.info("The mapper reload timer starting... ");

        try {
            new SqlSessionCache().refreshMapper();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}