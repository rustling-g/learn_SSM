import com.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gg
 * @create 2020-11-24 下午7:15
 */
public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
        System.out.println("-------------------------");
        as.deleteAccount();
        System.out.println("-------------------------");
        as.updateAccount(1);
    }
}
