package com.tutorialsninja.sw.testsuite;

import com.tutorialsninja.sw.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class DeskTopTest extends BaseTest {
    DeskTopTest desktopPage = new DeskTopTest();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        //1.1 Mouse hover on Desktops Tab.and click
        desktopPage.mouseHoverToElementAndClick(mouseHoverToElementAndClick());

        //1.2 Click on “Show All Desktops”
        desktopPage.clickOnElement();

        // Get all the products name and stored into array list
        ArrayList<String> originalProductsName = desktopPage.getAllProductName();
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);

        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.sortByZtoA();

        // After filter Z -A Get all the products name and stored into array list
        ArrayList<String> afterSortByZToAProductsName = desktopPage.getAllProductName();
        System.out.println(afterSortByZToAProductsName);
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // Select currency as £ Pound Sterling
        desktopPage.clickOnPoundCurrency();

        //2.1 Mouse hover on Desktops Tab.and click
        desktopPage.mouseHoverToElementAndClick();

        //2.2 Click on “Show All Desktops”
        desktopPage.clickOnShowAllDesktop();

        //2.3 Select Sort By position "Name: A to Z"
        desktopPage.sortByAtoZ();

        //2.4 Select product “HP LP3065”
        desktopPage.clickOnHPLP3065();

        //2.5 Verify the Text "HP LP3065"
        String actualProduct = desktopPage.getHPLP3065();
        String expectedProduct = "HP LP3065";
        Assert.assertEquals(actualProduct, expectedProduct);

        //2.6 Select Delivery Date "2023-11-30"
        desktopPage.selectDeliveryDate();

        //2.7.Enter Qty "1” using Select class.
        desktopPage.setQuantityTo1();

        //2.8 Click on “Add to Cart” button
        desktopPage.clickOnAddToCart();

        Thread.sleep(2500);

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!";
        boolean isContains = desktopPage.getCartSucessMessage().contains(expectedMessage);
        Assert.assertEquals(true, isContains);

        //2.10 Click on link “shopping cart” display into success message
        desktopPage.clickOnCartSucessMessage();

        //2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(desktopPage.getShopingCartText().contains("Shopping Cart"));

        //2.12 Verify the Product name "HP LP3065"
        Assert.assertEquals("HP LP3065", desktopPage.getProductNameHp());
        //2.13 Verify the Delivery Date "2022-11-30"
        Assert.assertTrue(desktopPage.getDate().contains("2023-11-30"));
        //2.14 Verify the Model "Product21"
        Assert.assertEquals("Product 21", desktopPage.getModel());
        //2.15 Verify the Todat "£74.73"
        Assert.assertEquals("£74.73", desktopPage.getTotal());
    }


}
