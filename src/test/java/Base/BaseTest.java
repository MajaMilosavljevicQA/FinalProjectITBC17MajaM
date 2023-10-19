package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public HomePage homePage;
    public InventoryProductsPage inventoryProductsPage;

    public CartPage cartPage;
    public SidebarPage sidebarPage;
    public LogoPage logoPage;
    public FooterPage footerPage;
    public ShoppingCartPage shoppingCartPage;
    public CheckoutStepOnePage checkoutStepOnePage;
    public CheckoutStepTwoPage checkoutStepTwoPage;

    public CheckoutCompletePage checkoutCompletePage;

    public JavascriptExecutor js = (JavascriptExecutor) driver;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        // excelReader = new ExcelReader("D:\\IT Bootcamp Divac\\QA\\Finalni projekat\\TestData.xlsx");
        excelReader = new ExcelReader("src/test/java/TestData.xlsx");
        homePage = new HomePage();
        inventoryProductsPage = new InventoryProductsPage();
        cartPage = new CartPage();
        sidebarPage = new SidebarPage();
        logoPage = new LogoPage();
        footerPage = new FooterPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutStepOnePage = new CheckoutStepOnePage();
        checkoutStepTwoPage = new CheckoutStepTwoPage();
        checkoutCompletePage = new CheckoutCompletePage();
    }

    public void scroll(int x, int y) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x, y);
        actions.perform();
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}

