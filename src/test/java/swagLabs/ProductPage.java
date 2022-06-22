package swagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public WebDriver driver;
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[@id=\"item_4_img_link\"]/img")
    private WebElement productItem;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addToCardBtn;

    public void userLogout() {
        logoutBtn.click(); }

    public void addToCardBtn() {
        addToCardBtn.click(); }
    public void productItem() {
        productItem.click(); }


}
