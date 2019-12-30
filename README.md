# Final Project IT Bootcamp
Tested site: https://phptravels.com/demo/

Project structure:
- pages – POM&PageFactory classes
- tests – Tests
- utils – Helper class

Used:
- Selenium WebDriver,
- Apache POI,
- ChromeDriver.

### TravelsLogin
Page Object Model with Page Factory is used to find HTML elements of site. 
**TravelsLogInTest** check admin login.
![](https://i.imgur.com/a6m77VK.png)

### TravelsMenu
Left side of site is tested -  TravelsMenu.  PageFactory is used to finds elements. 
**TravelsMenuCheckTest** tests menu and all pages.

![](https://i.imgur.com/L5q0mUP.png)

![](https://i.imgur.com/tjkBLzE.png)

![](https://i.imgur.com/XkKF9Ea.png)

### TravelsCars
On page **Rent-a-Car**-- PageFactory test (**CarsCountTest**) which:
- Is number of rented models equal to  10 - *Name*
- Is total customer orders higher than 50 – *Orders* 

![](https://i.imgur.com/4XxATT3.png)

### TravelsCarsExtras
Adding a new car is tested on page **Cars-Extras**. All fields are filled (like on the picture).
Test -**TravelCarsExtrasAddTest** check is car added in table.
Also in this test is shown how to remove Pop-Up message.

![](https://i.imgur.com/dczW5qC.png)

![](https://i.imgur.com/wulvckW.png)

### TravelCustomer
Adding new customers is shown on page **Accounts – Customers**.

All info is added in fields (like on the picture).

**TravelsCustomerEditTest** use <Search> option to check if customer is added.

![](https://i.imgur.com/EzQBMod.png)

![](https://i.imgur.com/Hd25yOT.png)

### TravelsLogInUsingApachePoi 
use excel table to login admin.

![](https://i.imgur.com/vJsfgnw.png)

Project created in collaboration with [Braca QA](https://github.com/BracaQA "Braca QA")
