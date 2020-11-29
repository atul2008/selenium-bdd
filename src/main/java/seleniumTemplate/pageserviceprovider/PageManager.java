package seleniumTemplate.pageserviceprovider;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;


public class PageManager {

    private final WebDriver driver;
    private boolean isAllPagesScanned = false;
    private Set<Class<? extends PageEngine>> allPageClasses;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * It will dynamically loads the page instance at runtime instead of doing it compile time
     * It will save your memory leakage issue as it allows you to pick only those classes that you
     * needed at runtime or for a specific test case.
     * @TODO: Code refactoring would be done at later stages.
     * @param page instance name that you want to load it.
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public Object getPageInstance(String page) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        String pageClassName = page.toLowerCase().endsWith("page") ? page.replace(" ", "") :
                page.replace(" " , "") + "Page";

        String pageClass = null;
        if (!isAllPagesScanned) {
            // @TODO: To make it dynamic
            String packagePath = "seleniumTemplate.page";
            Reflections reflections = new Reflections(packagePath);
            allPageClasses = reflections.getSubTypesOf(PageEngine.class);
            isAllPagesScanned = true;
        }


        for (Class pageClazz: allPageClasses) {
            if (pageClazz.getName().endsWith(pageClassName)) {
                pageClass = pageClazz.getName();
            }
        }

        Class<?> aClass = this.getClass().getClassLoader().loadClass(pageClass);
        Constructor<?> constructor = aClass.getConstructor(WebDriver.class);
        return constructor.newInstance(this.driver);

    }

    public void clearBrowsingData() throws InterruptedException {
        driver.get("chrome://settings/clearBrowserData");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement clearData = (WebElement) js.executeScript(
                "return document.querySelector('settings-ui').shadowRoot.querySelector('settings-main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('settings-section > settings-privacy-page').shadowRoot.querySelector('settings-clear-browsing-data-dialog').shadowRoot.querySelector('#clearBrowsingDataDialog').querySelector('#clearBrowsingDataConfirm')");
// now you can click on clear data button
        clearData.click();
        Thread.sleep(15000);
    }

}


